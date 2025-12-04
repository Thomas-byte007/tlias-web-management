package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j  //用log记录日志
@RequestMapping("/depts")
@RestController
public class DeptController {

    //调用service层
    @Autowired
    private DeptService deptService;

    /*
    * 查询全部部门数据
    * @return 部门数据
    * */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /*
    * 根据id删除部门数据
    * @return
    * */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);

        deptService.delete(id);

        return Result.success();
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门：{}",dept);

        deptService.add(dept);

        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据查询部门:{}",id);

        Dept dept = deptService.selectByid(id);

        return Result.success(dept);
    }

    @PutMapping
    public Result modify(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);

        deptService.modify(dept);

        return Result.success(dept);
    }
}
