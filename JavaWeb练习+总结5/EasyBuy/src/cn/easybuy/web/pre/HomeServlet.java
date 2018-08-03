package cn.easybuy.web.pre;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.service.product.ProductCategoryServiceImpl;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;
import cn.easybuy.utils.ProductCategoryVo;
import cn.easybuy.web.AbstractServlet;

@WebServlet(urlPatterns = {"/Home"}, name = "Home")
public class HomeServlet extends AbstractServlet {

    private ProductService productService;
    private NewsService newsService;
    private ProductCategoryService productCategoryService;
   //初始化产品的业务层，新闻业务层，产品分类业务层
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        newsService = new NewsServiceImpl();
        productCategoryService = new ProductCategoryServiceImpl();
    }

    /**
     * 商城主页的方法
     * @param request
     * @param response
     * @return
     */
    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception {
        //查询商品分裂
        List<ProductCategoryVo> productCategoryVoList = productCategoryService.queryAllProductCategoryList();
        List<News> news = newsService.getAllNews(new Pager(5, 5, 1));
        //查询一楼
        for (ProductCategoryVo vo : productCategoryVoList) {
            List<Product> productList = productService.getProductList(1, 8, null, vo.getProductCategory().getId(), 1);
            //List<Product> productList = productService.getProductList(currentPageNo, pageSize, proName, categoryId, level)
            vo.setProductList(productList);
        }
        //封装返回
        request.setAttribute("productCategoryVoList", productCategoryVoList);
        request.setAttribute("news", news);
        return "/pre/index";
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
