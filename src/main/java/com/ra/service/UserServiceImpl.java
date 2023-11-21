package com.ra.service;

import com.ra.model.dao.UserDAO;
import com.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public boolean login(User user) {
        User userLogin = userDAO.getByEmail(user.getEmail());
        if (userLogin != null) {
            return userLogin.getPassword().equals(user.getPassword());
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public boolean save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User getById(Integer userId) {
        return userDAO.getById(userId);
    }

    @Override
    public boolean update(User user, Integer userId) {
        return userDAO.update(user, userId);
    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }
}
