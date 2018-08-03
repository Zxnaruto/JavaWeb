package service;

import java.util.List;

import org.springframework.stereotype.Service;

import pojo.Product;
import pojo.UserInfo;

@Service
public interface ProductService {

	List<Product> findAll();

	Product findProductById(Integer pid);

	void updateProduct(Product product);


}
