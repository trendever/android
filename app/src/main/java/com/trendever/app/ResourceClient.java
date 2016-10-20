package com.trendever.app;

import android.view.View;

import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkView;

/**
 * Created by lopan on 10/20/16.
 */

public class ResourceClient extends XWalkResourceClient {
    private XWalkView mXWalkView;
    public ResourceClient(XWalkView view) {
        super(view);
        mXWalkView = view;
    }

    @Override
    public void onLoadStarted(XWalkView view, String url) {
        super.onLoadStarted(view, url);
    }

    @Override
    public void onLoadFinished(XWalkView view, String url) {
        super.onLoadFinished(view, url);
        mXWalkView.setVisibility(View.VISIBLE);
    }

}