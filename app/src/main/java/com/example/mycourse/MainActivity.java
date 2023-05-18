package com.example.mycourse;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import com.example.mycourse.fragment.CourseFragment;
import com.example.mycourse.fragment.ExercisesFragment;
import com.example.mycourse.fragment.MyinfoFragment;
import com.example.mycourse.fragment.HomeFragment;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private AppBarConfiguration mAppBarConfiguration;
    private TextView tv_main_title;//标题
    private TextView tv_back;//返回按钮
    private RelativeLayout title_bar;
    private TextView bottom_bar_text_main;
    private ImageView bottom_bar_image_main;
    private RelativeLayout main_body;
    private TextView bottom_bar_text_course;
    private ImageView bottom_bar_image_course;
    private RelativeLayout bottom_bar_course_btn;
    private TextView bottom_bar_text_exercises;
    private ImageView bottom_bar_image_exercises;
    private RelativeLayout bottom_bar_exercises_btn;
    private TextView bottom_bar_text_read;
    private ImageView bottom_bar_image_read;
    private RelativeLayout bottom_bar_read_btn;
    private LinearLayout main_bottom_bar;

    protected long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        initView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setMain();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        setSelectStatus(3);
        LinearLayout line=(LinearLayout) findViewById(R.id.line_all);
        line.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //菜单中控件的点击事件写在onSupportNavigateUp函数时会被调用
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        LinearLayout line=(LinearLayout) findViewById(R.id.line_all);
        line.setVisibility(View.INVISIBLE);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void setMain() {
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,new HomeFragment()).commit();
        setSelectStatus(2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            boolean isLogin=data.getBooleanExtra("isLogin",false);
            if (isLogin){
                setSelectStatus(0);
            }
            else {
                setSelectStatus(2);
            }
        }
        if (requestCode == 000) {
            setSelectStatus(1);
        }
    }
    private void setSelectStatus(int index) {
        LinearLayout line=(LinearLayout) findViewById(R.id.line_all);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);

        switch (index){
            case 0:
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon_selected);
                bottom_bar_text_course.setTextColor(Color.parseColor("#0097F7"));
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_read.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_main.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_image_read.setImageResource(R.drawable.main_read_icon);
                bottom_bar_image_main.setImageResource(R.drawable.main_my_icon);

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new CourseFragment()).commit();
                tv_main_title.setText("课程");
                line.setVisibility(View.VISIBLE);
                toolbar.setTitle("课程");
                break;
            case 1:
                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon_selected);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#0097F7"));
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_read.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_main.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_image_read.setImageResource(R.drawable.main_read_icon);
                bottom_bar_image_main.setImageResource(R.drawable.main_my_icon);

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new ExercisesFragment()).commit();
                tv_main_title.setText("在线测试");
                line.setVisibility(View.VISIBLE);
                toolbar.setTitle("在线测试");
                break;
            case 2:
                bottom_bar_image_read.setImageResource(R.drawable.main_read_icon_selected);
                bottom_bar_text_read.setTextColor(Color.parseColor("#0097F7"));
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_main.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_image_main.setImageResource(R.drawable.main_my_icon);

//                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new ChatFragment()).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new MyinfoFragment()).commit();

                tv_main_title.setText("经典阅读");
                line.setVisibility(View.VISIBLE);
                toolbar.setTitle("经典阅读");
                break;
            case 3:
                bottom_bar_image_main.setImageResource(R.drawable.main_my_icon_selected);
                bottom_bar_text_main.setTextColor(Color.parseColor("#0097F7"));
                bottom_bar_text_read.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_image_read.setImageResource(R.drawable.main_read_icon);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new HomeFragment()).commit();
                tv_main_title.setText("主页");
                line.setVisibility(View.VISIBLE);
                toolbar.setTitle("主页");
                break;
        }
    }
    private void initView() {
        tv_main_title=findViewById(R.id.tv_main_title);
        title_bar=findViewById(R.id.title_bar);
        main_body = findViewById(R.id.main_body);
        //底部导航栏
        bottom_bar_text_course = findViewById(R.id.bottom_bar_text_course);
        bottom_bar_image_course = findViewById(R.id.bottom_bar_image_course);
        bottom_bar_course_btn = findViewById(R.id.bottom_bar_course_btn);

        bottom_bar_text_exercises = findViewById(R.id.bottom_bar_text_exercises);
        bottom_bar_image_exercises = findViewById(R.id.bottom_bar_image_exercises);
        bottom_bar_exercises_btn = findViewById(R.id.bottom_bar_exercises_btn);

        bottom_bar_text_read = findViewById(R.id.bottom_bar_text_read);
        bottom_bar_image_read = findViewById(R.id.bottom_bar_image_read);
        bottom_bar_read_btn = findViewById(R.id.bottom_bar_read_btn);

        bottom_bar_text_main = findViewById(R.id.bottom_bar_text_main);
        bottom_bar_image_main = findViewById(R.id.bottom_bar_image_main);
        main_bottom_bar = findViewById(R.id.main_bottom_bar);

        bottom_bar_course_btn.setOnClickListener(this);
        bottom_bar_exercises_btn.setOnClickListener(this);
        bottom_bar_read_btn.setOnClickListener(this);
        main_bottom_bar.setOnClickListener(this);
        tv_main_title.setText("毛概课程");
        title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_bottom_bar:
                setSelectStatus(3);
                break;
            case R.id.bottom_bar_course_btn:
                //getSupportFragmentManager().beginTransaction().add(R.id.main_body,new CourseFragment()).commit();
                setSelectStatus(0);
                break;
            case R.id.bottom_bar_exercises_btn:
                //getSupportFragmentManager().beginTransaction().add(R.id.main_body,new ExercisesFragment()).commit();
                setSelectStatus(1);
                break;
            case R.id.bottom_bar_read_btn:
                //getSupportFragmentManager().beginTransaction().add(R.id.main_body,new MyinfoFragment()).commit();
                setSelectStatus(2);
                break;
        }
    }
}
