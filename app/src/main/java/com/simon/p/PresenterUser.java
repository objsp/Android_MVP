package com.simon.p;

import com.simon.bean.User;
import com.simon.m.ModelUser;
import com.simon.m.ModelUserImpl;
import com.simon.v.ViewUser;

/**
 * Created by Simon on 2016-05-10 0010.
 */
public class PresenterUser {

    private ModelUser model;
    private ViewUser view;

    public PresenterUser(ViewUser view) {
        this.view = view;
        this.model = new ModelUserImpl();
    }

    public void saveUser(User user) {
        this.model.setUser(user);
    }

    public void getUser() {
        this.view.setViewUser(this.model.getUser());
    }

}
