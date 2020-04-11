package com.example.mpa3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

public class webActivity extends AppCompatActivity {

    String url;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        url = getIntent().getStringExtra("url");

        final URL website;

        try {
            if (url.startsWith("https://")) {}
            else if (url.startsWith("http://")) {}
            else {
                url = "http://" + url;
            }

            website  = new URL(url);
            // Proxy proxy  = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.20.10.2",8888));
            System.setProperty("http.proxyHost","172.20.10.2"); // 불확실
            System.setProperty("http.proxyPort","8888"); // 불확실
            HttpURLConnection httpURLConnection = (HttpURLConnection)website.openConnection();
            httpURLConnection.connect();

            Authenticator authenticator = new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication("user",
                            "password".toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        webview.loadUrl(url);
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClientClass());
    }

    @Override
    // 안드로이드의 다양한 키사용에 대한 설정
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) { // 뒤로가기 버튼 클릭시
            webview.goBack(); // webview 뒤로가기
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
