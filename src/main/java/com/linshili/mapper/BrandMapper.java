package com.linshili.mapper;

import com.linshili.pojo.Brand;


import java.util.List;

public interface BrandMapper {
//查询数据
    List<Brand> selectAll();
//添加数据
    void add(Brand brand);
//修改数据
    void update(Brand brand);
    //根据id查询
    Brand selectById(int id);
    //删除
    void delectById(Brand brand);
}
