package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by home on 2019/2/23.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public
class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public
    void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public
    void findAll() throws Exception {
       List<ProductCategory> productCategoryList = categoryService.findAll();
       Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public
    void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(2,9,3));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public
    void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("男生专享",10);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}