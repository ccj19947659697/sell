package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by home on 2019/3/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
@Slf4j
public
class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;
    @Test
    public
    void insertByMap() throws Exception {
        Map<String,Object>map =new HashMap<>();
        map.put("categoryName","陈娇最不爱");
        map.put("categoryType","109");
       int result= mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }
    @Test
    public void insertByObject(){
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(109);
        int result=mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }
    @Test
    public void findByCategoryType() {
        ProductCategory result = mapper.findByCategoryType(103);
        //System.out.println(result);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryName() {
       List<ProductCategory> result = mapper.findByCategoryName("师兄最不爱");
        //System.out.println(result);
        Assert.assertNotEquals(0,result.size());
    }
    @Test
    public void updateByCategoryType(){
        int result = mapper.updateByCategoryType("师兄最不喜欢的分类",103);
        Assert.assertEquals(1,result);
    }
    @Test
    public void updateByObject(){
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(109);
        int result=mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }
@Test
    public  void deleteByCategoryType(){
        int result =mapper.deleteByCategoryType(101);
        Assert.assertEquals(1,result);
}
@Test
    public void selectByCategoryType(){
        ProductCategory productCategory=mapper.selectByCategoryType(103);
        Assert.assertNotNull(productCategory);
}


}