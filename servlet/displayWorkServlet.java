package servlet;

import dao.DaoException;
import dao.WorkDao;
import service.impl.WorkDaoImpl;
import empty.Work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "displayWorkServlet.do", value = "/displayWorkServlet.do")
public class displayWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            WorkDao dao=new WorkDaoImpl();
            ArrayList<Work> works=null;
            works=dao.findAllWork();
            request.setAttribute("works",works);
            request.getServletContext().getRequestDispatcher("/displayAllWork.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
