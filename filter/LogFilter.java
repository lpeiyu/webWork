package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LogFilter",urlPatterns = {"/*"})
public class LogFilter extends HttpFilter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext context=config.getServletContext();
        long start=System.currentTimeMillis();
        System.out.println("请求的资源："+request.getRequestURI());
        System.out.println("用户地址："+request.getRemoteAddr());
        context.log("请求的资源："+request.getRequestURI());
        context.log("用户地址："+request.getRemoteAddr());
        chain.doFilter(request, response);
        long end=System.currentTimeMillis();
        System.out.println("请求的总时间："+(end-start)+"毫秒");
        context.log("请求的总时间："+(end-start)+"毫秒");
    }
}
