package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Salary)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:39
 */
public interface SalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Salary queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Salary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param salary 实例对象
     * @return 对象列表
     */
    List<Salary> queryAll(Salary salary);

    /**
     * 新增数据
     *
     * @param salary 实例对象
     * @return 影响行数
     */
    int insert(Salary salary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Salary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salary> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Salary> entities);

    /**
     * 修改数据
     *
     * @param salary 实例对象
     * @return 影响行数
     */
    int update(Salary salary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}