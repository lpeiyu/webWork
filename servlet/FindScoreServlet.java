package servlet;

import dao.DaoException;
import dao.ScoreDao;
import service.impl.ScoreDaoImpl;
import empty.Score;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindScoreServlet", value = "/FindScoreServlet")
public class FindScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreDao scoreDao=new ScoreDaoImpl();
        try {
            String Sno=request.getParameter("Sno");
            Score score = scoreDao.findScore(Sno);
            request.setAttribute("score",score);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/findScore.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            System.out.println(e);
        }

    }
}
