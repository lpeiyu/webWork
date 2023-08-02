package service.impl;

import dao.DaoException;
import dao.ScoreDao;
import empty.Score;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static utils.JdbcUtils.getConnection;

public class ScoreDaoImpl implements ScoreDao {
    @Override
    public ArrayList<Score> findAllScore() throws DaoException {
        ArrayList<Score> scores=new ArrayList<>();
        String sql="SELECT * FROM score";
        try (Connection conn=getConnection();
             PreparedStatement pstmt= conn.prepareStatement(sql);
             ResultSet rst= pstmt.executeQuery()
        ){
            while (rst.next()){
                Score score=new Score();
                score.setCno(rst.getString("Cno"));
                score.setSno(rst.getString("Sno"));
                score.setScore(rst.getInt("Score"));
                scores.add(score);
            }
            return scores;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Score findScore(String Sno) throws DaoException {
        String sql="SELECT Sno,Cno,Score FROM score WHERE Sno= ?";
        Score score=new Score();
        Connection conn = null;
        try{
            conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, Sno);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()){
                score.setSno(rst.getString("Sno"));
                score.setCno(rst.getString("Cno"));
                score.setScore(rst.getInt("Score"));
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
        return score;
    }

    @Override
    public int updateScore(Score score) throws DaoException {
        String sql="UPDATE score SET Score=?, Cno=? WHERE Sno=?";
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            //查询学号是否存在数据库
            String checkSql="SELECT Sno FROM score WHERE Sno=?";
            PreparedStatement checkPstmt=conn.prepareStatement(checkSql);
            checkPstmt.setString(1,score.getSno());
            ResultSet rst=checkPstmt.executeQuery();
            if(rst.next()){
                pstmt.setInt(1,score.getScore());
                pstmt.setString(2,score.getCno());
                pstmt.setString(3,score.getSno());
            }
            int rowsUpdate=pstmt.executeUpdate();
            return rowsUpdate;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
