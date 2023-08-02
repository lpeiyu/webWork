package service.impl;

import dao.DaoException;
import dao.WorkDao;
import empty.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static utils.JdbcUtils.getConnection;

public class WorkDaoImpl implements WorkDao {

       @Override
    public boolean addWork(Work work) throws DaoException {
        String sql="INSERT INTO work VALUES(?,?,?,?)";
        try (
            Connection conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql))
        {
            pstmt.setString(1, work.getCno());
//            pstmt.setString(2, work.getTno());
            pstmt.setString(2, work.getPublishDate());
            pstmt.setString(3, work.getDeadline());
            pstmt.setString(4, work.getMessage());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Work> findAllWork() throws DaoException {

        ArrayList<Work> works=new ArrayList<>();
        String sql="SELECT * FROM work";
        try (Connection conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rst= pstmt.executeQuery()
        ){
            while (rst.next()){
                Work work=new Work();
                work.setCno(rst.getString("Cno"));
//                work.setTno(rst.getString("Tno"));
                work.setPublishDate(rst.getString("publishDate"));
                work.setDeadline(rst.getString("deadline"));
                work.setMessage(rst.getString("content"));
                works.add(work);
            }
            return works;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteWork(String deleteId) throws DaoException {
        String sql="DELETE FROM work WHERE Cno = ?";
        try (Connection conn=getConnection();
             PreparedStatement pstmt= conn.prepareStatement(sql)){
            pstmt.setString(1, deleteId);
            pstmt.executeUpdate();
            return deleteId;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}