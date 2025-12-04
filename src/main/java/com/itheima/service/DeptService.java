package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     */
    Dept selectByid(Integer id);

    /**
     * 修改部门数据
     * @param dept
     */
    void modify(Dept dept);
}
