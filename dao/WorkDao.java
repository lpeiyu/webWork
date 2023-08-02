package dao;

import empty.Work;

import java.util.ArrayList;

public interface WorkDao{
    public boolean addWork (Work work) throws DaoException;
    public ArrayList<Work> findAllWork() throws DaoException;
    public String deleteWork (String deleteId) throws DaoException;
//    public int addWork(Work work);
}
