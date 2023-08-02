package dao;

import empty.Score;

import java.util.ArrayList;

public interface ScoreDao {
    public ArrayList<Score> findAllScore() throws DaoException;
    public Score findScore(String Cno) throws DaoException;
    public int updateScore(Score score) throws DaoException;
}
