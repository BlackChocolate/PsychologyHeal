package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;

/**
 * Created by sukurax on 2017/2/3.
 */

public class registerActivity extends AppCompatActivity {
    EditText nickName,Password,PasswordConfirm;
    String nickname,password,passwordconfirm;
    Button registerAndLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phoneNumber");
        nickName=(EditText)findViewById(R.id.nickname);
        Password=(EditText)findViewById(R.id.registerPassword);
        PasswordConfirm=(EditText)findViewById(R.id.registerPasswordConfirm);
        registerAndLogin=(Button)findViewById(R.id.registerAndLogin);
        registerAndLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nickname=nickName.getText().toString().trim();
                password=Password.getText().toString().trim();
                passwordconfirm=PasswordConfirm.getText().toString().trim();
                if(nickname.length()==0||password.length()==0||passwordconfirm.length()==0){
                    Toast.makeText(getApplicationContext(), "输入不能为空！",
                            Toast.LENGTH_SHORT).show();
                }else if(password.equals(passwordconfirm)){
                    AVUser.getCurrentUser().saveInBackground(new SaveCallback() {
                        @Override
                        public void done(AVException e) {
                            AVUser.getCurrentUser().put("password", password);
                            AVUser.getCurrentUser().put("nickName", nickname);
                            AVUser.getCurrentUser().saveInBackground();
                        }
                    });

                    Intent intent = new Intent();
                    intent.setClass(registerActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "输入密码不一致！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
