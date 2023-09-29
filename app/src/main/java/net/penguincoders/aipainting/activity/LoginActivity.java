package net.penguincoders.aipainting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dou361.dialogui.DialogUIUtils;

import net.penguincoders.aipainting.R;
import net.penguincoders.aipainting.util.StatusBarUtil;

public class LoginActivity extends AppCompatActivity {

    //    private ImageView settingLoginExitBtn;
    private EditText LoginAccount;
    private EditText LoginPassword;
    private Boolean accountFlag = false;
    private Boolean passwordFlag = false;
    private Button LoginGoBtn;
    private TextView LoginPhoneBtn;

    private LinearLayout LoginQQBtn;
    private LinearLayout LoginWeChatBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.setStatusBarMode(this, true, R.color.colorBack);
        //隐藏系统状态栏
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        init();
        initListener();
        DialogUIUtils.init(this);
    }

    private void init() {
        //获取页面中的组件
        LoginAccount= findViewById(R.id.LoginAccount);
        LoginPassword= findViewById(R.id.LoginPassword);
        LoginGoBtn= findViewById(R.id.LoginGoBtn);
        LoginGoBtn.setEnabled(false);
        LoginPhoneBtn = findViewById(R.id.LoginPhoneBtn);
        LoginQQBtn= findViewById(R.id.LoginQQBtn);
        LoginWeChatBtn= findViewById(R.id.LoginWeChatBtn);
    }

    private void initListener() {

        LoginGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO login






                //如果登陆成功，跳转到主页
                Intent HomeIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(HomeIntent);

            }
        });
        LoginPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到手机免密登录页面
                Intent loginPhoneIntent = new Intent(LoginActivity.this, PhoneActivity.class);
                startActivity(loginPhoneIntent);
            }
        });
        LoginAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                accountFlag = s.length() > 0;
                if (accountFlag && passwordFlag) {
                    //LoginGoBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_theme_circle));
                    LoginGoBtn.setEnabled(true);
                } else {
                    //LoginGoBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_theme_pale_circle));
                    LoginGoBtn.setEnabled(false);
                }
            }
        });

        LoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordFlag = s.length() > 0;
                if (accountFlag && passwordFlag) {
                    //LoginGoBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_theme_circle));
                    LoginGoBtn.setEnabled(true);
                } else {
                    //LoginGoBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_theme_pale_circle));
                    LoginGoBtn.setEnabled(false);
                }
            }
        });
        LoginQQBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUIUtils.showToastCenter("请使用手机免登录进行登录");
            }
        });
        LoginWeChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUIUtils.showToastCenter("请使用手机免登录进行登录");
            }
        });

    }
}