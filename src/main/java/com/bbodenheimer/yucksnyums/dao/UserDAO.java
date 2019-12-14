package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.User;

public interface UserDAO {
    public void insert(User user);
    public User findUserById(int id);
}
