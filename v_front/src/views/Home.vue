<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">
          微人事
        </div>
        <el-dropdown class="userinfo" @command="commandHandler">
          <span class="el-dropdown-link">
            {{user.name}}<i><img :src="user.userFace"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="userinfo">个人中心</el-dropdown-item>
            <el-dropdown-item command="setting">设置</el-dropdown-item>
            <el-dropdown-item divided command="logout">注销登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu @select="menuClick">
            <el-submenu :index="index.toString()" v-for="(item, index) in routes.filter(route => !route.hidden)" :key="index">
              <template slot="title">
                <i :class="item.iconCls" style="margin-right: 5px;"></i>
                <span>{{item.meta.name}}</span>
              </template>
              <el-menu-item :index="sub.path" v-for="(sub, indexj) in item.children" :key="indexj">{{sub.meta.name}}</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right" v-if="this.$router.currentRoute.path !== '/home' ">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$router.currentRoute.meta.name}}</el-breadcrumb-item>
          </el-breadcrumb>
          <div v-else class="homeWelcome">欢迎来到微人事</div>
          <router-view class="homeRouterView"/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data(){
    return {
      user: JSON.parse(window.sessionStorage.getItem("user"))
    }
  },
  computed: {
    routes() {
      return this.$store.state.routes;
    }
  },
  methods: {
    commandHandler(cmd){
      if(cmd === "logout"){
        this.$confirm('此操作将注销登录，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消'
        }).then(confirm => {
          this.getRequest('/logout');
          window.sessionStorage.removeItem('user');
          this.$store.commit('initRoutes', []);
          this.$router.replace('/');
        }).catch(cancel => {
          this.$message.info("已取消该操作");
        });
      }
    },
    menuClick(index, indexPath){
      this.$router.push(index)
    }
  }
}
</script>

<style>
.homeHeader {
  background-color: #409eff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 15px;
  box-sizing: border-box;
}

.homeHeader .title {
  font-size: 30px;
  font-family: "Xingkai SC";
  color: #ffffff;
}

.homeHeader .userinfo{
  cursor: pointer;
}

.homeWelcome{
  text-align: center;
  font-size: 30px;
  font-family: "Xingkai SC";
  padding-top: 50px;
}
.el-dropdown-link img {
  width: 48px;
  height: 48px;
  border-radius: 24px;
  margin-left: 8px;
}
.el-dropdown-link{
  display: flex;
  align-items: center;
}
.homeRouterView{
  margin-top: 10px;
}
</style>
