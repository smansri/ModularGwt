package com.sma.modulargwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ModularGwt implements EntryPoint {

    public void onModuleLoad() {
        Viewport viewport = new Viewport();
        BasicTabExample tabs = new BasicTabExample();
        viewport.add(tabs);
        RootPanel.get().add(viewport);
    }
}
