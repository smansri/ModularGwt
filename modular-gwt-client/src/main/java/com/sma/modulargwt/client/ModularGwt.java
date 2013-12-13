package com.sma.modulargwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sma.modulargwt.shared.rpc.GreetingService;
import com.sma.modulargwt.shared.rpc.GreetingServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ModularGwt implements EntryPoint {

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
                    + "attempting to contact the server. Please check your network " + "connection and try again.";

    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    HTML serverResponseLabel;

    TextButton closeButton;

    public void onModuleLoad() {
        final Dialog dialogBox = createDialogBox();
        HorizontalPanel header = new HorizontalPanel();
        final TextField text = new TextField();
        TextButton button = new TextButton("<b>Send to server!</b>");
        button.addSelectHandler(new SelectHandler() {

            @Override
            public void onSelect(SelectEvent event) {
                greetingService.greetServer(text.getValue(), new AsyncCallback<String>() {
                    public void onFailure(Throwable caught) {
                        // Show the RPC error message to the user
                        dialogBox.setTitle("Remote Procedure Call - Failure");
                        serverResponseLabel.addStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML(SERVER_ERROR);
                        dialogBox.center();
                        dialogBox.center();
                        closeButton.focus();
                    }

                    public void onSuccess(String result) {
                        dialogBox.setTitle("Remote Procedure Call");
                        serverResponseLabel.removeStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML(result);
                        dialogBox.show();
                        dialogBox.center();
                        closeButton.focus();
                    }
                });

            }
        });

        header.add(text);
        header.add(button);

        BasicTabExample tabs = new BasicTabExample();

        Viewport viewport = new Viewport();

        viewport.add(header);
        viewport.add(tabs);
        RootPanel.get().add(viewport);
    }

    // Create the popup dialog box
    private Dialog createDialogBox() {
        Dialog dialogBox = new Dialog();
        dialogBox.setTitle("Remote Procedure Call");
        closeButton = new TextButton("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        Label textToServerLabel = new Label();
        serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);
        return dialogBox;
    }
}
