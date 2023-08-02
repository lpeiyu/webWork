package service.impl;

import dao.WorkDao;
import empty.Work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addWorkServlet.do", value = "/addWorkServlet.do")
public class AddWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WorkDao dao=new WorkDaoImpl();
        Work work=new Work();
        String message=null;
        try {
            work.setCno(new String(request.getParameter("Cno").getBytes("iso-8859-1"),"UTF-8"));
//            work.setTno(new String(request.getParameter("Tno").getBytes("iso-8859-1"),"UTF-8"));
            work.setPublishDate(new String(request.getParameter("publishDate").getBytes("iso-8859-1"),"UTF-8"));
            work.setDeadline(new String(request.getParameter("deadline").getBytes("iso-8859-1"),"UTF-8"));
            work.setMessage(new String(request.getParameter("content").getBytes("iso-8859-1"),"UTF-8"));
            boolean success=dao.addWork(work);
            if(success){
                message="<li>成功插入一条记录！</li>";
            }else {
                message="<li>插入记录错误</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>插入记录错误</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/Work.jsp");
        rd.forward(request,response);
    }
}
