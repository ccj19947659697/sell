package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by home on 2019/3/13.
 */
public
interface ProductCategoryMapper {
    //通过Map,变量名不需要与映射表中一样
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);
    //通过对象,变量名就要与映射表中对应起来
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            //数据库字段映射dao中变量
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            //数据库字段映射dao中变量
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);
    //通过字段更新
    @Update("update product_category set category_name = #{categoryName} where category_type =#{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);
    //通过对象更新
    @Update("update product_category set category_name = #{categoryName} where category_type =#{categoryType}")
    int updateByObject(ProductCategory productCategory);
    @Delete("delete from product_category where category_type =#{categoryType}")
    int deleteByCategoryType(Integer categoryType);
    //申明XML方法
    ProductCategory selectByCategoryType(Integer categoryType);


}
