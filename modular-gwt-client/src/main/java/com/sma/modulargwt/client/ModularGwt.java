package com.sma.modulargwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ModularGwt implements EntryPoint {

    public void onModuleLoad() {
        final TextBox textBox = new TextBox();
        Button button = new Button("Click me!");
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                textBox.setText("Help me with clicking on the button!");

            }
        });

        RootPanel.get("textField").add(textBox);
        RootPanel.get("buttonField").add(button);
    }
}
