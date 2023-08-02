package utils;
import com.sun.jndi.cosnaming.CNCtx;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
        private static final String URL="jdbc:mysql://localhost:3306/test?useSSL=true";
        private static final String DRIVER="com.mysql.cj.jdbc.Driver";

        static {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        /**
         * 获取数据连接池中的连接
         * @return 如果返回null 则获取数据库连接失败
         */
        public static Connection getConnection(){
            try {
                return DriverManager.getConnection(URL,"root","root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 关闭连接,放回数据库连接池
         * @param
         */
        public static void closeResultSet(ResultSet resultSet) {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public static void closePs(PreparedStatement ps){
            try {
                if (ps != null) {
                    ps.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
    public static void closeConn(Connection conn){
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

