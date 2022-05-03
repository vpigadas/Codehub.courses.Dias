package com.dias.course.application.ui.webview;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dias.course.R;

public class WebViewActivity extends AppCompatActivity {
    public static final String ARG_URL = "WebViewActivity.ARG_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        String url = getIntent().getStringExtra(ARG_URL);

        WebView webView = findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

//        webView.setWebViewClient(new WebViewClient(){
//
//        });

        webView.setWebChromeClient(new WebChromeClient(){

        });

        webView.loadUrl(url);
    }
}