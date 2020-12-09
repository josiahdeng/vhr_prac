package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.MailSendLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MailSendLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:29
 */
public interface MailSendLogDao {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MailSendLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mailSendLog 实例对象
     * @return 对象列表
     */
    List<MailSendLog> queryAll(MailSendLog mailSendLog);

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 影响行数
     */
    int insert(MailSendLog mailSendLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MailSendLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MailSendLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MailSendLog> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<MailSendLog> entities);

}