package com.example.sukurax.psychologyheal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by sukurax on 2017/1/27.
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioButton[] rb;
    //Fragment Object
    HomeFragment fg1;
    CircleFragment fg2;
    HeartFragment fg3;
    ManFragment fg5;
    private MyFragment fg4;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        RadioGroup rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);

        //定义RadioButton数组用来装RadioButton，改变drawableTop大小
        rb = new RadioButton[5];
        //将RadioButton装进数组中
        rb[0] = (RadioButton) findViewById(R.id.rb_home);
        rb[1] = (RadioButton) findViewById(R.id.rb_circle);
        rb[2] = (RadioButton) findViewById(R.id.rb_heart);
        rb[3] = (RadioButton) findViewById(R.id.rb_camera);
        rb[4] = (RadioButton) findViewById(R.id.rb_man);
        //for循环对每一个RadioButton图片进行缩放
        for (RadioButton aRb : rb) {
            //挨着给每个RadioButton加入drawable限制边距以控制显示大小
            Drawable[] drawables = aRb.getCompoundDrawables();
            //获取drawables，2/5表示图片要缩小的比例
            Rect r = new Rect(0, 0, drawables[1].getMinimumWidth() * 2 / 5, drawables[1].getMinimumHeight() * 2 / 5);
            //定义一个Rect边界
            drawables[1].setBounds(r);
            //给每一个RadioButton设置图片大小
            aRb.setCompoundDrawables(null, drawables[1], null, null);
        }

        //获取第一个单选按钮，并设置其为选中状态
        RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_home.setChecked(true);
        
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.rb_home:
                if(fg1 == null){
                    fg1 = new HomeFragment();
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rb_circle:
                if(fg2 == null){
                    fg2 = new CircleFragment();
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_heart:
                if(fg3 == null){
                    fg3 = new HeartFragment();
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;
            case R.id.rb_camera:
                if(fg4 == null){
                    fg4 = new MyFragment("直播界面完善中");
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;
            case R.id.rb_man:
                if(fg5 == null){
                    fg5 = new ManFragment();
                    fTransaction.add(R.id.ly_content,fg5);
                }else{
                    fTransaction.show(fg5);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
        if(fg5 != null)fragmentTransaction.hide(fg5);
    }

    public void toDoctorIfo(View view) {
        Intent intent = new Intent();
        intent.setClass(this, DoctorIfoActivity.class);
        startActivity(intent);
    }


}
