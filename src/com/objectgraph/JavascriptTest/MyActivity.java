package com.objectgraph.JavascriptTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MyActivity extends Activity{
    WebView myWebView;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myWebView = (WebView)this.findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("file:///android_asset/index.html");

        myWebView.addJavascriptInterface(new JavaScriptHandler(this), "MyHandler");

        Button btnSimple = (Button)this.findViewById(R.id.btnSimple);
        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("King Johnson!");
            }
        });
    }

    public void addText(String someText){
        myWebView.loadUrl("javascript:addText('"+ someText + "')");
    }
}
