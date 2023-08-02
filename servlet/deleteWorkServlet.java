package servlet;

import dao.WorkDao;
import service.impl.WorkDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteWorkServlet.do", value = "/deleteWorkServlet.do")
public class deleteWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WorkDao dao=new WorkDaoImpl();
        String message=null;
        try {
            String deleteId=request.getParameter("deleteId");
            dao.deleteWork(deleteId);

//            if(){
//                message="<li>成功删除一条记录！</li>";
//            }else {
//                message="<li>删除记录错误</li>";
//            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>删除记录错误</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/Work.jsp");
        rd.forward(request,response);
    }
}
