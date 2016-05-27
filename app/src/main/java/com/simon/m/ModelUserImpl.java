package com.simon.m;

import com.simon.bean.User;

/**
 * Created by Simon on 2016-05-10 0010.
 */
public class ModelUserImpl implements ModelUser {

    private User user = new User();

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }
}
