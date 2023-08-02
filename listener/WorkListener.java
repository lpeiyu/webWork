package listener;

import empty.Work;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener
public class WorkListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext context=null;
    public WorkListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<Work> workList=new ArrayList<>();
        workList.add(new Work("0001","190025","2022-8-9","2022-9-10","课本p52第8题"));
        workList.add(new Work("0001","190025","2022-8-9","2022-9-10","课本p52第8题"));
        workList.add(new Work("0001","190025","2022-8-9","2022-9-10","课本p52第8题"));

        context= sce.getServletContext();
        context.setAttribute("workList",workList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        context=sce.getServletContext();
        context.removeAttribute("workList");
    }

    @Override
    public void sessionCreated(HttpSessionEvent sec) {
        /* Session is created. */


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
