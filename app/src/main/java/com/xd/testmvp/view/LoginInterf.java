package com.xd.testmvp.view;

/**
 * Created by hhhhwei on 16/3/20.
 * 不管具体的业务逻辑，在这个例子里就是不管任何的登录逻辑
 */
public interface LoginInterf {

    //初始化界面
    public void initViews();

    //设置监听事件
    public void initListeners();

    //得到用户名
    public String getUserName();

    //得到用户的密码
    public String getUserPasswd();

    public void showLoading();

    public void hideLoading();

    public void toMainActivity();

    public void showErrorMessage();

    public void clear();

}
