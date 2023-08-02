package listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class MyRequestListener implements ServletRequestListener, HttpSessionListener, HttpSessionAttributeListener {
    private int count=0;
    public MyRequestListener() {
    }

    @Override
    public void requestInitialized(ServletRequestEvent re) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        HttpServletRequest request=(HttpServletRequest) re.getServletRequest();
        if (request.getRequestURI().endsWith("teaWelcome.jsp")||request.getRequestURI().endsWith("stuWelcome.jsp")){
            count++;
            re.getServletContext().setAttribute("count",new Integer(count));
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent re) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
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
