package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.EmployeeTrain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmployeeTrain)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:22
 */
public interface EmployeeTrainDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeTrain queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmployeeTrain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeTrain 实例对象
     * @return 对象列表
     */
    List<EmployeeTrain> queryAll(EmployeeTrain employeeTrain);

    /**
     * 新增数据
     *
     * @param employeeTrain 实例对象
     * @return 影响行数
     */
    int insert(EmployeeTrain employeeTrain);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeTrain> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeTrain> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeTrain> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeTrain> entities);

    /**
     * 修改数据
     *
     * @param employeeTrain 实例对象
     * @return 影响行数
     */
    int update(EmployeeTrain employeeTrain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}