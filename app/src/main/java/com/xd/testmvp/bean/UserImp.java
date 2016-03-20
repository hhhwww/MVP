package com.xd.testmvp.bean;

/**
 * Created by hhhhwei on 16/3/20.
 */
public class UserImp implements UserInterf {
    @Override
    public void toLogin(final String account, final String password, final OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (account.equals("hewei") && password.equals("hewei")) {
                    listener.onSuccess();
                } else {
                    listener.onError();
                }
            }
        }).start();
    }
}
