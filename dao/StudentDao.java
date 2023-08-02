package dao;

import empty.Student;
import empty.Work;

import java.util.ArrayList;

public interface StudentDao {
    public ArrayList<Student> findAllStudent() throws DaoException;
}
