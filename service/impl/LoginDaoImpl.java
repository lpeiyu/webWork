package service.impl;

import dao.DaoException;
import dao.LoginDao;
import empty.UserData;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.JdbcUtils.getConnection;

public class LoginDaoImpl implements LoginDao {

    @Override
    public UserData user(String id) throws DaoException {
        String sql="select * from user where id=?";
        Connection conn = null;
        UserData user=new UserData();
        try{
            conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()){
                user.setId(rst.getString("id")) ;
                user.setPassword(rst.getString("password"));
            }
        } catch (SQLException e) {
            if(conn != null){
                JdbcUtils.closeConn(conn);
            }
            return null;
        }
        if(conn != null){
            JdbcUtils.closeConn(conn);
        }
        return user;
    }
}
