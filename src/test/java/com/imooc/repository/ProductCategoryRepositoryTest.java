package com.imooc.repository;

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
 * Created by home on 2019/2/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryRepositoryTest {
@Autowired
 private ProductCategoryRepository repository;
@Test
//查询
public void findOneTest() {
         ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
        }
@Test
//@Transactional
//添加数据,dataobject  有参构造方法
    public void saveTest(){
  ProductCategory productCategory = new ProductCategory("美女最爱",3);
//    ProductCategory productCategory = new ProductCategory();
//    productCategory.setCategoryName("女生最爱");
//    productCategory.setCategoryType(3);
    ProductCategory result = repository.save(productCategory);
    Assert.assertNotNull(result);
}
@Test
//更新数据
    public void saveTest1(){
    ProductCategory productCategory = repository.findOne(2);
    productCategory.setCategoryType(1);
    repository.save(productCategory);
}

@Test //通过catagoryType进行查询,返回对象是一个列表,无参构造
    public void fingByCategoryTypeIntest(){
        List<Integer> list = Arrays.asList(2,1,3);
       List<ProductCategory> result = repository.findByCategoryTypeIn(list);
       Assert.assertNotEquals(0,result.size());
}




}