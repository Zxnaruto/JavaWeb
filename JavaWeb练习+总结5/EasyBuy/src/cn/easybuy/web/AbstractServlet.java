package cn.easybuy.web;

import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.PrintUtil;
import cn.easybuy.utils.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 公共的Servlet抽象类
 */
public abstract class AbstractServlet extends HttpServlet {


    public abstract Class getServletClass();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionIndicator = req.getParameter("action");//获取servlet返回的字符串
        Method method = null;
        Object result = null;
        try {
            if (EmptyUtils.isEmpty(actionIndicator)) {//判断请求是否为空
                result = execute(req, resp);//返回首页
            } else {
            	//获取该类所需求的方法
                method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
                result = method.invoke(this, req, resp);//方法实现
            }
            toView(req, resp, result);//根据请求的action跳转相应的界面
        } catch (NoSuchMethodException e) {
            String viewName = "404.jsp";
            req.getRequestDispatcher(viewName).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            if (!EmptyUtils.isEmpty(result)) {
                if (result instanceof String) {
                    String viewName = "500.jsp";
                    req.getRequestDispatcher(viewName).forward(req, resp);
                } else {
                    ReturnResult returnResult = new ReturnResult();
                    returnResult.returnFail("系统错误");
                    PrintUtil.write(returnResult, resp);
                }
            } else {
                String viewName = "500.jsp";
                req.getRequestDispatcher(viewName).forward(req, resp);
            }

        }
    }

    protected void toView(HttpServletRequest req, HttpServletResponse resp, Object result) throws IOException, ServletException {
        if (!EmptyUtils.isEmpty(result)) {
            if (result instanceof String) {
                String viewName = result.toString() + ".jsp";
                req.getRequestDispatcher(viewName).forward(req, resp);//转发
              
                // resp.sendRedirect(viewName);//重定向
            } else {
                PrintUtil.write(result, resp);//写出错误原因
            }
        }
    }

    public Object execute(HttpServletRequest req, HttpServletResponse resp) {
        return "pre/index";
    }
}
