package com.example.subwayexit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView exitView1;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitView1 = (WebView)findViewById(R.id.exitView1);
        url = getIntent().getStringExtra("url");

        exitView1.getSettings().setJavaScriptEnabled(true);
        exitView1.setWebChromeClient(new WebChromeClient());
        exitView1.setWebViewClient(new WebViewClientClass());

        if(url.startsWith("http://")){
            exitView1.loadUrl(url);
        } else if(url.startsWith("https://")) {
            exitView1.loadUrl(url);
        } else{
            exitView1.loadUrl("http://" + url);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&exitView1.canGoBack()){
            exitView1.goBack();
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
    }
}
