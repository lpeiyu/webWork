package servlet;

import dao.DaoException;
import dao.ScoreDao;
import service.impl.ScoreDaoImpl;
import empty.Score;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "displayScoreServlet", value = "/displayScoreServlet")
public class displayScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ScoreDao dao=new ScoreDaoImpl();
            ArrayList<Score> scores=null;
            scores=dao.findAllScore();
            request.setAttribute("scores",scores);
            request.getServletContext().getRequestDispatcher("/displayAllScore.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
