package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.EmpSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmpSalary)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:11
 */
public interface EmpSalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpSalary queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpSalary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param empSalary 实例对象
     * @return 对象列表
     */
    List<EmpSalary> queryAll(EmpSalary empSalary);

    /**
     * 新增数据
     *
     * @param empSalary 实例对象
     * @return 影响行数
     */
    int insert(EmpSalary empSalary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpSalary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpSalary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpSalary> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmpSalary> entities);

    /**
     * 修改数据
     *
     * @param empSalary 实例对象
     * @return 影响行数
     */
    int update(EmpSalary empSalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}