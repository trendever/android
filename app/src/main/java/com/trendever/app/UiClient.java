package com.trendever.app;

import android.net.Uri;
import android.webkit.ValueCallback;

import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

/**
 * Created by lopan on 10/20/16.
 */

public class UiClient extends XWalkUIClient {

    public UiClient(XWalkView view) {
        super(view);
    }

    @Override
    public void openFileChooser(XWalkView view, ValueCallback<Uri> uploadFile, String acceptType, String capture) {
        uploadFile.onReceiveValue(null);
    }
}