package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "validationServlet", value = "/validationServlet")
public class validationServlet extends HttpServlet {

    private static final String URL="jdbc:mysql://localhost:3306/test?useSSL=true";
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String USER="root";
    public static final String PWD="root";
    private static Connection conn=null;
    private static PreparedStatement pst=null;
    private static ResultSet rs=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("连接成功");
            String sql = "select count(id) from user where id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    out.print("true");
                } else {
                    out.print("false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }