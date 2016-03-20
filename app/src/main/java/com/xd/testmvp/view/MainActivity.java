package com.xd.testmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xd.testmvp.R;
import com.xd.testmvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginInterf, View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;

    private Button btLogin;
    private Button btClear;

    private ProgressBar pb;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //和Presenter绑定
        mLoginPresenter = new LoginPresenter(this);

        initViews();
        initListeners();
    }

    @Override
    public void initViews() {
        etAccount = (EditText) findViewById(R.id.etAccount);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btLogin = (Button) findViewById(R.id.btLogin);
        btClear = (Button) findViewById(R.id.btClear);

        pb = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void initListeners() {
        btLogin.setOnClickListener(this);
        btClear.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return etAccount.getText().toString().trim();
    }

    @Override
    public String getUserPasswd() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this, "To", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        etAccount.setText("");
        etPassword.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btLogin:
                Log.e("TAG", "1");
                mLoginPresenter.Login();
                break;

            case R.id.btClear:
                mLoginPresenter.clear();//仔细理这行代码就可以理解mvp的核心
                break;
        }
    }
}
