package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by home on 2019/2/23.
 */
public
interface CategoryService {
    ProductCategory findOne(Integer categoryId);//查询一条记录
    List<ProductCategory> findAll();//查询所有,用于后台管理
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);//查询类型,用于客户端
    ProductCategory save(ProductCategory productCategory);//新增和更新都是save方法
}
