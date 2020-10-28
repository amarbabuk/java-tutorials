package com.ab.cache.service;

import com.ab.cache.entity.User;

public interface UserService {
    public User getUser(long id);
    public User getRefreshUser(long id);
    public User deleteUser(long id);
}
