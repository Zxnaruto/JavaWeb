package pers.zx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.zx.service.GoodsService;
import pers.zx.service.GoodsServiceImpl;
import pers.zx.utils.PrintUtil;
import pers.zx.utils.ReturnResult;

/**
 * Servlet implementation class ShopCarServlet
 */
@WebServlet("/ShopCarServlet")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public Class getServletClass(){
		return ShopCarServlet.class;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionIndicator = request.getParameter("action");//获取servlet返回的字符串特指action
		 Method method = null;
	      //  Object result = null;
	      
           try {
           	//获取该类所需求的方法,这里指获取check方法
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
				//执行方法
				method.invoke(this, request, response);//方法实现，调用ShopCarServlet类里面的相应方法	
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
	}
	
	public ReturnResult add(HttpServletRequest request, HttpServletResponse response) {
	
		int flag=0;
		boolean flag1=false;
		ReturnResult result=new ReturnResult();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price=Float.parseFloat(request.getParameter("price"));
		int num=Integer.parseInt(request.getParameter("num"));
		GoodsService goods = new GoodsServiceImpl();
		flag1=goods.isExist(id);
		if(flag1==true) {
			result.returnFail("该商品已经在购物车中！！！");
			PrintUtil.write(result, response);
		}else {
		flag=goods.add(id,name, price, num);
		if(flag==1) {
			result.returnSuccess("添加购物车成功！！！");
			 PrintUtil.write(result, response);
		}else {	
			result.returnFail("添加购物车失败！！！");
			 PrintUtil.write(result, response);
		}
		}
		return result;
	}
	
	public ReturnResult del(HttpServletRequest request, HttpServletResponse response) {
		int flag=0;
		ReturnResult result=new ReturnResult();
		int id=Integer.parseInt(request.getParameter("id"));
		GoodsService goods = new GoodsServiceImpl();
		flag=goods.del(id);
		if(flag==1) {
			result.returnSuccess("删除成功！！！");
			 PrintUtil.write(result, response);
		}else {	
			result.returnFail("删除失败！！！");
			 PrintUtil.write(result, response);
		}
		
		return result;
	}
	
	public void change(HttpServletRequest request, HttpServletResponse response) {
		int flag=0;
		int id=Integer.parseInt(request.getParameter("id"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		GoodsService goods = new GoodsServiceImpl();
		flag=goods.change(id, amount);
		if(flag!=1) {
			System.out.println("失败");
		}
	}
	
	public void show(HttpServletRequest request, HttpServletResponse response) {
		GoodsService goods = new GoodsServiceImpl();
		HttpSession session = request.getSession(); // 将数据存到session中以便于在前台获取
		session.setAttribute("list", goods.show());
		 try {
			request.getRequestDispatcher("shopcar.jsp").forward(request, response);//转发
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
