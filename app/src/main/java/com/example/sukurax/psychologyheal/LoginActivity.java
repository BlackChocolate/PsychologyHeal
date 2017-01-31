package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

public class LoginActivity extends AppCompatActivity {
    EditText loginUsername;
    EditText loginPassword;
    TextView resetPassword;
    String loginusername;
    String loginpassword;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("登录");
        spec.setContent(R.id.login);
        spec.setIndicator("登录");
        host.addTab(spec);

        spec = host.newTabSpec("注册");
        spec.setContent(R.id.register);
        spec.setIndicator("注册");
        host.addTab(spec);

        loginUsername=(EditText)findViewById(R.id.loginUsername);
        loginPassword=(EditText)findViewById(R.id.loginPassword);
        loginBtn=(Button)findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginusername=loginUsername.getText().toString().trim();
                loginpassword=loginPassword.getText().toString().trim();
                if(loginusername.length()==0||loginpassword.length()==0){
                    Toast.makeText(getApplicationContext(), "输入不能为空！",
                            Toast.LENGTH_SHORT).show();
                }else{
                    AVUser.logInInBackground(loginusername, loginpassword, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if(e==null){
                                Intent intent=new Intent();
                                intent.setClass(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                String temp[] = e.toString().split("\"");
                                Toast.makeText(getApplicationContext(), temp[temp.length-2],
                                        Toast.LENGTH_SHORT).show();
                                if(temp[temp.length-2]=="登录成功"){
                                    Intent intent=new Intent();
                                    intent.setClass(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        });

        resetPassword=(TextView)findViewById(R.id.resetPassword);
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击了忘记密码",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
