package com.example.mycourse.activity;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycourse.R;


public class ReadBookActivity extends Activity {
    private TextView tv_back;
    private TextView tv_main_title;
    private TextView tv_save;
    private RelativeLayout title_bar;
    private WebView webView;
    private String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        initView();
    }

    private void initView() {
        tv_back = findViewById(R.id.tv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_save = findViewById(R.id.tv_save);
        title_bar = findViewById(R.id.title_bar);
  //      tv_main_title.setText("经典阅读");
        title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));

        webView=findViewById(R.id.wv_list);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent=getIntent();

        switch (intent.getStringExtra("st")){
            case "2131230911":
                tv_main_title.setText("共产党宣言");//1.txt
                webView.loadUrl("http://192.168.137.1/andriodData/readBook/1.txt");
            break;
            case "2131230912":
                tv_main_title.setText("在延安座谈会上的讲话");//2.txt
                webView.loadUrl("http://192.168.137.1/andriodData/readBook/2.txt");
                break;
            case "2131230913":
                tv_main_title.setText("邓小平文选");//3.txt
                webView.loadUrl("http://192.168.137.1/andriodData/readBook/3.txt");
                break;
            case "2131230914":
                tv_main_title.setText("论共产党员的修养");//4.txt
                webView.loadUrl("http://192.168.137.1/andriodData/readBook/4.txt");
                break;
        }
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.mycourse.activity.ReadBookActivity.this.finish();
            }
        });
    }

}