package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by home on 2019/2/22.
 * 数据库的表名 product_category
 */
@Entity
@DynamicUpdate//自动更新时间
@Data
public class ProductCategory {
    //类目ID
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名字
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date updateTime;
    //修改时间
    private Date createTime;

//    public
//    Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public
//    void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public
//    Date getCreateTime() {
//        return createTime;
//    }
//
//    public
//    void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public
//    void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public
//    Integer getCategoryType() {
//        return categoryType;
//    }
//
//    public
//    void setCategoryType(Integer categoryType) {
//        this.categoryType = categoryType;
//    }
//
//    @Override
//    public
//    String toString() {
//        return "ProductCategory{" +
//                "categoryId=" + categoryId +
//                ", categoryName=" + categoryName +
//                ", categoryType=" + categoryType +
//                '}';
//    }


    public
    ProductCategory() {

    }

    public
    ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

