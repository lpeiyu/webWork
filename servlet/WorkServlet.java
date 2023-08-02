package servlet;

import empty.Work;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WorkServlet", value = "/WorkServlet")
public class WorkServlet extends HttpServlet {
    //private WorkService workService = new WorkServiceImpl();
    ServletContext context;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno=request.getParameter("Cno");
        String Tno=request.getParameter("Tno");
        String publishDate=request.getParameter("publishDate");
        String deadline=request.getParameter("deadline");
        String content=request.getParameter("content");
        Work work=new Work(Cno,Tno,publishDate,deadline,content);
        //workService.addWork(work);
        request.getRequestDispatcher("Work.jsp").forward(request,response);
    };
//    ArrayList<Work> arrayList=new ArrayList<>();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String Cno = request.getParameter("Cno");
//        String Tno = request.getParameter("Tno");
//        String pushDate = request.getParameter("publishDate");
//        String deadline = request.getParameter("deadline");
//        String content = request.getParameter("content");
//        Work work1 = new Work(Cno, Tno, pushDate, deadline, content);
//        HttpSession session = request.getSession();
//        Work work=(Work)session.getAttribute("work1");
//        arrayList.add(work1);
//        System.out.println(arrayList);
//        session.setAttribute("work1",work1);
//        response.sendRedirect("Work.jsp");
    }


}
