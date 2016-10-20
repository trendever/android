package com.trendever.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.webkit.ValueCallback;

import com.google.firebase.iid.FirebaseInstanceId;

import org.xwalk.core.JavascriptInterface;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class MainActivity extends Activity {
    private XWalkView mXWalkView;
    private View logo;
    private static final String TAG = "MyFirebaseMsgService";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mXWalkView.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mXWalkView = (XWalkView) findViewById(R.id.activity_main);
        logo = findViewById(R.id.logo);

        mXWalkView.getSettings().setUserAgentString("androidapp");
        mXWalkView.setResourceClient(new ResourceClient(mXWalkView));
        mXWalkView.addJavascriptInterface(new JsBind(this, mXWalkView),"Android");
        mXWalkView.setUIClient(new UiClient(mXWalkView));
        mXWalkView.load("http://192.168.0.2", null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mXWalkView != null) {
            mXWalkView.pauseTimers();
            mXWalkView.onHide();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mXWalkView != null) {
            mXWalkView.resumeTimers();
            mXWalkView.onShow();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mXWalkView != null) {
            mXWalkView.onDestroy();
        }
    }
}
