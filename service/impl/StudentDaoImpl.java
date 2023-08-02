package service.impl;

import dao.DaoException;
import dao.StudentDao;
import empty.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static utils.JdbcUtils.getConnection;

public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAllStudent() throws DaoException {
        ArrayList<Student> students=new ArrayList<>();
        String sql="SELECT * FROM student";
        try (Connection conn=getConnection();
             PreparedStatement pstmt= conn.prepareStatement(sql);
             ResultSet rst= pstmt.executeQuery()
        ){
            while (rst.next()){
                Student student=new Student();
                student.setSno(rst.getString("Sno"));
                student.setSname(rst.getString("Sname"));
                student.setSage(rst.getInt("Sage"));
                student.setSaddress(rst.getString("Saddress"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
