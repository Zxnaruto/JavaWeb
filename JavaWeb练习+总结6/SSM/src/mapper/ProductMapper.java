package mapper;

import java.util.List;

import pojo.Product;
import pojo.UserInfo;

public interface ProductMapper {

	List<Product> findAll();

	Product findProductById(Integer pid);

	void updateProduct(Product product);


}
