package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by home on 2019/2/22.
 */
public
interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryTypeList);//通过categorytype
}
