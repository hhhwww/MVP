package com.xd.testmvp.bean;

/**
 * Created by hhhhwei on 16/3/20.
 */
public interface UserInterf {

    public void toLogin(String account , String password , OnLoginListener listener);
}
