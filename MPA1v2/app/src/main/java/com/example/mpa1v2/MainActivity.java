package com.example.mpa1v2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends AppCompatActivity {

    String url;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = getIntent().getStringExtra("url");

        webview = (WebView)findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClientClass());
        webview.setWebChromeClient(new WebChromeClient());


        if (url.startsWith("https://")){
            webview.loadUrl(url);
        }
        else if (url.startsWith("http://")) {
            webview.loadUrl(url);
        }
        else {
            webview.loadUrl("http://"+url);
        }




    }
    @Override
    // 안드로이드S의 다양한 키사용에 대한 설정
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) { // 뒤로가기 버튼 클릭시
            webview.goBack(); // webView 뒤로가기
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
