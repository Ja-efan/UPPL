package com.example.subwayexit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView exitView2;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitView2 = (WebView)findViewById(R.id.exitView2);
        url = getIntent().getStringExtra("url");

        exitView2.getSettings().setJavaScriptEnabled(true);
        exitView2.setWebViewClient(new WebViewClientClass());
        if(url.startsWith("http://")){
            exitView2.loadUrl(url);
        } else if(url.startsWith("https://")) {
            exitView2.loadUrl(url);
        } else{
            exitView2.loadUrl("http://" + url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&exitView2.canGoBack()){
            exitView2.goBack();
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
