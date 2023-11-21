package com.ra.service;

import com.ra.model.entity.User;

public interface UserService extends IGenericService<User, Integer> {
    boolean login(User user);
}
