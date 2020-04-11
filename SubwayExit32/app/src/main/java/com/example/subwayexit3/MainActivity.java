package com.example.subwayexit3;
import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView exitView3;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitView3 = (WebView)findViewById(R.id.exitView3);
        url = getIntent().getStringExtra("url");

        exitView3.getSettings().setJavaScriptEnabled(true);
        exitView3.setWebChromeClient(new WebChromeClient());
        exitView3.setWebViewClient(new WebViewClientClass());


        if(url.startsWith("http://")){
            exitView3.loadUrl(url);
        } else if(url.startsWith("https://")) {
            exitView3.loadUrl(url);
        } else{
            exitView3.loadUrl("http://" + url);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&exitView3.canGoBack()){
            exitView3.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

}