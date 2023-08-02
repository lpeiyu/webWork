package servlet;

import dao.DaoException;
import dao.ScoreDao;
import service.impl.ScoreDaoImpl;
import empty.Score;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateScoreServlet", value = "/UpdateScoreServlet")
public class UpdateScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreDao scoreDao=new ScoreDaoImpl();
        Score score=new Score();
        try {
            score.Sno=request.getParameter("Sno");
            score.Cno=request.getParameter("Cno");
            score.score= Integer.parseInt(request.getParameter("Score"));
            scoreDao.updateScore(score);
            String message2="修改成绩成功";
            request.setAttribute("message2",message2);
            request.getRequestDispatcher("/updateScore.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
