package listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebListener
public class ScoreListener implements ServletContextListener, ServletContextAttributeListener {
    private ServletContext context=null;

    public ScoreListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        Context ctx = null;
        DataSource dataSource=null;
        context= sce.getServletContext();
        try {
            if (ctx==null){
                ctx=new InitialContext();
            }
            dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/webstoreDS");
            System.out.println("数据源对象2222222："+dataSource);
        } catch (NamingException e) {
            context.log("发生异常"+e);
        }
        //添加属性
        context.setAttribute("dataSource",dataSource);
        context.log("应用程序已启动："+ LocalTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        context = sce.getServletContext();
        context.removeAttribute("dataSource");
        context.log("应用程序已关闭："+ LocalTime.now());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent sce) {
        /* This method is called when an attribute is added to a session. */
        context=sce.getServletContext();
        context.log("添加一个属性："+sce.getName()+":"+sce.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce) {
        /* This method is called when an attribute is removed from a session. */
        context=sce.getServletContext();
        context.log("删除一个属性："+sce.getName()+":"+sce.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce) {
        /* This method is called when an attribute is replaced in a session. */
        context=sce.getServletContext();
        context.log("替换一个属性："+sce.getName()+":"+sce.getValue());
    }
}
