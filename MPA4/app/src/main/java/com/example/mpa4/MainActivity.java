package com.example.mpa4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webview4);
        url = getIntent().getStringExtra("url");

        final URL website;

        try {
            if(url.startsWith("http://")) {}
            else if(url.startsWith("https://")) {}
            else{
                url = "http://" +  url;
            }
            website = new URL(url);


            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress("192.168.35.118",8888)); // 1
            //  Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8118));

            //System.setProperty("http.proxyHost","172.20.10.2"); // 2
            // System.setProperty("http.proxyHost","172.0.0.1");
            //System.setProperty("http.proxyPort","8888"); // 2
            // System.setProperty("http.proxyPort","8118");

            HttpURLConnection httpURLConnection = (HttpURLConnection)website.openConnection(proxy);
            httpURLConnection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());
        webView.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
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
