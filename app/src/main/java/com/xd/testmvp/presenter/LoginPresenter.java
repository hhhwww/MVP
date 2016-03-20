package com.xd.testmvp.presenter;

import android.os.Handler;

import com.xd.testmvp.bean.OnLoginListener;
import com.xd.testmvp.bean.UserImp;
import com.xd.testmvp.bean.UserInterf;
import com.xd.testmvp.view.LoginInterf;

/**
 * Created by hhhhwei on 16/3/20.
 */
public class LoginPresenter {

    private UserInterf mUserInterf;
    private LoginInterf mLoginInterf;

    private Handler handler = new Handler();

    public LoginPresenter(LoginInterf loginInterf) {
        this.mLoginInterf = loginInterf;
        mUserInterf = new UserImp();
    }

    public void Login() {
        mLoginInterf.showLoading();
        mUserInterf.toLogin(mLoginInterf.getUserName(), mLoginInterf.getUserPasswd(), new OnLoginListener() {
            @Override
            public void onSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginInterf.toMainActivity();
                        mLoginInterf.hideLoading();
                    }
                });
            }

            @Override
            public void onError() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginInterf.showErrorMessage();
                        mLoginInterf.hideLoading();
                    }
                });
            }
        });
    }


    public void clear() {
        mLoginInterf.clear();
    }
}
