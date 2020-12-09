package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.EmployeeRemove;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmployeeRemove)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:20
 */
public interface EmployeeRemoveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeRemove queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmployeeRemove> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeRemove 实例对象
     * @return 对象列表
     */
    List<EmployeeRemove> queryAll(EmployeeRemove employeeRemove);

    /**
     * 新增数据
     *
     * @param employeeRemove 实例对象
     * @return 影响行数
     */
    int insert(EmployeeRemove employeeRemove);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeRemove> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeRemove> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeRemove> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeRemove> entities);

    /**
     * 修改数据
     *
     * @param employeeRemove 实例对象
     * @return 影响行数
     */
    int update(EmployeeRemove employeeRemove);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}