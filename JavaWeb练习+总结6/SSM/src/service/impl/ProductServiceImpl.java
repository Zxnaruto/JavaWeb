package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ProductMapper;
import mapper.UserMapper;
import pojo.Product;
import pojo.UserInfo;
import service.ProductService;
import service.UserService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}
	@Override
	public Product findProductById(Integer pid) {
		return productMapper.findProductById(pid);
	}
	@Override
	public void updateProduct(Product product) {
		  productMapper.updateProduct(product);
	}
    

}
