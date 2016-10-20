package com.trendever.app;

import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import org.xwalk.core.JavascriptInterface;
import org.xwalk.core.XWalkView;

public class JsBind{
        private static final String TAG = "JS_Bind";
        private Context context;
        private XWalkView xWalkWebView;

        public JsBind(Context c, XWalkView xWalkWebView) {
            context = c;
            this.xWalkWebView = xWalkWebView;
        }

        @JavascriptInterface
        public void sendToken() {
            String token = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG, "function call");
        }
}
