package dao;

import empty.Score;
import empty.UserData;

public interface LoginDao {
    UserData user(String id) throws DaoException;
}
