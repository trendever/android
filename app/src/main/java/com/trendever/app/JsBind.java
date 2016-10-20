package com.trendever.app;

import android.content.Context;
import android.os.Handler;

import com.google.firebase.iid.FirebaseInstanceId;

import org.xwalk.core.JavascriptInterface;
import org.xwalk.core.XWalkView;

public class JsBind{
        private Context context;
        private XWalkView xWalkWebView;

        public JsBind(Context c, XWalkView xWalkWebView) {
            context = c;
            this.xWalkWebView = xWalkWebView;
        }

        @JavascriptInterface
        public void sendToken() {
            final String token = FirebaseInstanceId.getInstance().getToken();
            Handler mainHandler = new Handler(context.getMainLooper());

            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    xWalkWebView.load(String.format("javascript:setUserToken('%s','android');",token),null);
                }
            };
            mainHandler.post(myRunnable);
        }



}
