package com.ab.cache.service;

import com.ab.cache.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames={"users"})
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable
    public User getUser(long id) {
        return createUser(id);
    }

    @Override
    @CachePut
    public User getRefreshUser(long id) {
        return createUser(id);
    }

    @Override
    @CacheEvict
    public User deleteUser(long id) {
        return createUser(id);
    }

    private User createUser(long id) {

        System.out.println("creating user ....!"+System.currentTimeMillis());

        User user = new User();

        user.setNatId(id);
        user.setName("foo-name-"+System.currentTimeMillis());
        user.setCity("foo-city-"+System.currentTimeMillis());

        return  user;
    }
}
