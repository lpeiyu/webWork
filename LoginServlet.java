import dao.DaoException;
import dao.LoginDao;
import service.impl.LoginDaoImpl;
import empty.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    String message=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id").trim();  //删除头尾空白符
        String password=request.getParameter("password").trim();
        String userType=request.getParameter("user");
        LoginDao loginDao=new LoginDaoImpl();
        UserData userData=new UserData();
        try {
            userData=loginDao.user(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        String value1="",value2="";
        Cookie cookie = null;
        Cookie[] cookies= request.getCookies();
        if(cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("id")) {
                    value1 = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    value2 = cookie.getValue();
                }
            }
            if (value1.equals(userData.getId()) && value2.equals(userData.getPassword())) {
                message = "欢迎您！再次登录该页面！";
                request.getSession().setAttribute("message", message);
                if(userType.equals("stu")) {
                    response.sendRedirect("stuWelcome.jsp");
                }else {
                    response.sendRedirect("teaWelcome.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id").trim();  //删除头尾空白符
        String password=request.getParameter("password").trim();
        String userType=request.getParameter("user");
        LoginDao loginDao=new LoginDaoImpl();
        UserData userData=new UserData();
        try {
            userData=loginDao.user(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if(!id.equals(userData.getId()) || !password.equals(userData.getPassword())){
            message="用户名或密码不正确，请重试";
            request.getSession().setAttribute("message",message);
            response.sendRedirect("loginError.jsp");
        }else {
            //如果用户选择自动登录，向浏览器发送2个cookie
            if ((request.getParameter("check") != null) && (request.getParameter("check").equals("check"))) {
                Cookie idCookie = new Cookie("id", id);
                Cookie pswdCookie = new Cookie("password", password);
//                设置存活时间
                idCookie.setMaxAge(60 * 60);
                pswdCookie.setMaxAge(60 * 60);
//                发送cookie
                response.addCookie(idCookie);
                response.addCookie(pswdCookie);
            }
            message = "您已成功登录";
            request.getSession().setAttribute("message", message);
            if(userType.equals("stu")) {
                response.sendRedirect("stuWelcome.jsp");
            }else {
                response.sendRedirect("teaWelcome.jsp");
            }
        }
    }
}