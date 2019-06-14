package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by home on 2019/2/23.
 */
@Service
//@CacheConfig(cacheNames = "product")
public
class ProductServiceImpl implements ProductService {
@Autowired
    private ProductInfoRepository repository;

    @Override
   // @Cacheable(key = "123")
    public
    ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public
    List<ProductInfo> findUpAll() {

        //代码出现0,1不好分辨,最好用枚举解决enums
        return repository. findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public
    Page<ProductInfo> findAll(Pageable pageable) {
//findAll这个方法传入是pageable这个参数的话,返回是一个pageable对象,
// 不是List,所有会报错,返回ProductService接口中修改方法
        return repository.findAll(pageable);
    }

    @Override
    //@CachePut(key = "123")
    public
    ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public
    void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if ( productInfo == null ) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public
    void decreaseStock(List<CartDTO> cartDTOList) {
        //首先遍历它,获取商品的ID和响应的数量
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if ( productInfo == null ) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //查出相应的商品在数据库的库存.进行比较
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if ( result < 0 ) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //如果还有,就减库存
            productInfo.setProductStock(result);
            //存库
            repository.save(productInfo);
        }
        }

    @Override
    public
    ProductInfo onSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if ( productInfo==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if ( productInfo.getProductStatusEnum()==ProductStatusEnum.UP ){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public
    ProductInfo offSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if ( productInfo==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if ( productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN ){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
