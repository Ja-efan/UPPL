package com.example.proxytest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.net.ProxySelector;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CloseableHttpClient httpClient = HttpClients.creatDefault();
        try {
            HttpHost target = new HttpHost("httpbin.org",443,"https");
            HttpHost proxy = new HttpHost("172.20.10.2",8888,"http");

            RequestConfig config = REquestConfig.custom().setProxy(proxy).build();

        }



    }
}
