package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Product;
import service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Resource
  private ProductService productService;
  @RequestMapping("findAll")
  public String findAll(Model model){
	  List<Product> plist=productService.findAll();
	  model.addAttribute("plist", plist);
	  return "productList";
  }
  @RequestMapping("findProductById/{pid}")
  public String findProductById(@PathVariable Integer pid,Model model){
	  Product p=productService.findProductById(pid);
	  model.addAttribute("p", p);
	  return "updateProduct";
  }
  @RequestMapping("updateProduct")
  public String updateProduct(@ModelAttribute ("product") Product product){
	  productService.updateProduct(product);
	  return "redirect:/product/findAll";
  }
}
