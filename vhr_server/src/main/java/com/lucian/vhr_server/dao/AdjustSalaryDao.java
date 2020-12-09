package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.AdjustSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AdjustSalary)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:08
 */
public interface AdjustSalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdjustSalary queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdjustSalary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adjustSalary 实例对象
     * @return 对象列表
     */
    List<AdjustSalary> queryAll(AdjustSalary adjustSalary);

    /**
     * 新增数据
     *
     * @param adjustSalary 实例对象
     * @return 影响行数
     */
    int insert(AdjustSalary adjustSalary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdjustSalary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AdjustSalary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdjustSalary> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AdjustSalary> entities);

    /**
     * 修改数据
     *
     * @param adjustSalary 实例对象
     * @return 影响行数
     */
    int update(AdjustSalary adjustSalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}