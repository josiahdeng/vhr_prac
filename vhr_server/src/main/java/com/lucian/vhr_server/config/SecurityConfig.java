package com.lucian.vhr_server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucian.vhr_server.entity.Hr;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.*;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Autowired
    RoleFilter roleFilter;

    @Autowired
    MyAccessDecisionManager accessDecisionManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 将hr信息放在security中
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);
                        o.setSecurityMetadataSource(roleFilter);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    RespBean bean = RespBean.ok("登出成功！");
                    out.write(new ObjectMapper().writeValueAsString(bean));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(401);
                PrintWriter out = response.getWriter();
                RespBean error = RespBean.error("访问失败");
                if (authException instanceof InsufficientAuthenticationException){
                    error.setMsg("尚未登录，请登录");
                }
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
            }
        });
        http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry(), event -> {
            HttpServletResponse resp = event.getResponse();
            resp.setContentType("application/json;charset=utf-8");
            resp.setStatus(401);
            PrintWriter out = resp.getWriter();
            out.write(new ObjectMapper().writeValueAsString(RespBean.error("您已在另一台设备登录，本次登录已下线!")));
            out.flush();
            out.close();
        }), ConcurrentSessionFilter.class);
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class).sessionManagement().maximumSessions(1);
    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationManager(authenticationManager());
        loginFilter.setFilterProcessesUrl("/doLogin");
        loginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setPassword(null);
            RespBean ok = RespBean.ok("登录成功", hr);
            printWriter.write(new ObjectMapper().writeValueAsString(ok));
            printWriter.flush();
            printWriter.close();
        });
        loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            RespBean error = RespBean.error("登录失败");
            if (exception instanceof LockedException){
                error.setMsg("账号被锁定，请联系管理员");
            } else if (exception instanceof CredentialsExpiredException){
                error.setMsg("密码过期，请联系管理员");
            } else if (exception instanceof AccountExpiredException){
                error.setMsg("账户过期，请联系管理员");
            } else if (exception instanceof DisabledException){
                error.setMsg("账户被禁用，请联系管理员");
            } else if (exception instanceof BadCredentialsException){
                error.setMsg("用户名或密码错误,请重试");
            } else if (exception instanceof SessionAuthenticationException){
                error.setMsg("此账号，在另外的设备中已登陆！请稍后再试。");
            }
            out.write(new ObjectMapper().writeValueAsString(error));
            out.flush();
            out.close();
        });

//        ConcurrentSessionControlAuthenticationStrategy strategy = new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
        loginFilter.setSessionAuthenticationStrategy(compositeSessionAuthenticationStrategy());
        return loginFilter;
    }

    @Bean
    SessionRegistryImpl sessionRegistry(){
        return new SessionRegistryImpl();
    }

    // 处理自定义filter的session问题
    @Bean
    CompositeSessionAuthenticationStrategy compositeSessionAuthenticationStrategy(){
        List<SessionAuthenticationStrategy> delegateStrategies = new ArrayList<>();
        //清除过期session
        ConcurrentSessionControlAuthenticationStrategy controlAuthenticationStrategy = new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
        //最多一个用户最多只能存在一个session
        controlAuthenticationStrategy.setMaximumSessions(1);
        //允许被挤下线
        controlAuthenticationStrategy.setExceptionIfMaximumExceeded(false);
        delegateStrategies.add(controlAuthenticationStrategy);
        SessionFixationProtectionStrategy fixationProtectionStrategy = new SessionFixationProtectionStrategy();
        delegateStrategies.add(fixationProtectionStrategy);
        //认证后保存sessionid到用户的信息中
        RegisterSessionAuthenticationStrategy registerSessionAuthenticationStrategy = new RegisterSessionAuthenticationStrategy(sessionRegistry());
        delegateStrategies.add(registerSessionAuthenticationStrategy);
        return new CompositeSessionAuthenticationStrategy(delegateStrategies);
    }

    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
