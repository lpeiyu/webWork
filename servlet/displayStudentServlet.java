package servlet;

import dao.DaoException;
import dao.StudentDao;
import service.impl.StudentDaoImpl;
import empty.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "displayStudentServlet", value = "/displayStudentServlet")
public class displayStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StudentDao studentDao=new StudentDaoImpl();
            ArrayList<Student> studentArrayList=null;
            studentArrayList= studentDao.findAllStudent();
            request.setAttribute("students",studentArrayList);
            request.getServletContext().getRequestDispatcher("/AllStudent.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
