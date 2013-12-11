package com.sma.modulargwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ModularGwt implements EntryPoint {

    public void onModuleLoad() {
        BasicTabExample tabs = new BasicTabExample();
        RootPanel.get().add(tabs);
    }
}
