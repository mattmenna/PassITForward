package com.gc.dao;

import com.gc.models.UsersEntity;

public interface UserDAO {
    Integer save(UsersEntity newUser);
}