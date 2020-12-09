package com.lucian.vhr_server.dao;

import com.lucian.vhr_server.entity.MenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MenuRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 20:11:30
 */
public interface MenuRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MenuRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MenuRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menuRole 实例对象
     * @return 对象列表
     */
    List<MenuRole> queryAll(MenuRole menuRole);

    /**
     * 新增数据
     *
     * @param menuRole 实例对象
     * @return 影响行数
     */
    int insert(MenuRole menuRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MenuRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MenuRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MenuRole> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<MenuRole> entities);

    /**
     * 修改数据
     *
     * @param menuRole 实例对象
     * @return 影响行数
     */
    int update(MenuRole menuRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过角色id删除其下的所有menu权限
     * @param rId
     * @return
     */
    Integer deleteByRoleId(Integer rId);
}