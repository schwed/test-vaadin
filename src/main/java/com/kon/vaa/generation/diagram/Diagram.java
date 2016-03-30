package com.kon.vaa.generation.diagram;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.*;
import elemental.json.JsonArray;

/**
 * Created by kshevchuk on 3/25/2016.
 */
@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js", "document.png", "topic.png", "author.png" })
public class Diagram extends AbstractJavaScriptComponent {

    public Diagram() {
        // callback that will be called from the client-side
        addFunction("onPlotClick",

                new JavaScriptFunction() {
                    @Override
                    public void call(JsonArray arguments) {
                        String nodeName = (String) returnNodeName(arguments.getString(0));
                        String nodeType = (String) returnNodeName(arguments.getString(1));
                        // String nodeId = (String)
                        // returnNodeName(arguments.getString(2));
                        displayPopUp(nodeName, nodeType);
                    }
                });
    }

    public void displayPopUp(String name, String type) {

        Window subWindow = new Window("Node Name:" + name);
        VerticalLayout subContent = new VerticalLayout();
        subContent.setMargin(true);
        subWindow.setWidth(500, Unit.PIXELS);
        subWindow.setContent(subContent);

        // Put some components in it
        subContent.addComponent(new Label("Name: " + name));
        subContent.addComponent(new Label("Type: " + type));
        // subContent.addComponent(new Label("Id: " + id));
        // subContent.addComponent(new Button("Awlright"));

        // Center it in the browser window
        subWindow.center();

        // Open it in the UI
        UI.getCurrent().addWindow(subWindow);

    }

    public String returnNodeName(String name) {

        return name;
    }

    public void displayMsg(String newName) {
        callFunction("displayMsg", newName);
    }

    @Override
    public DiagramState getState() {
        return (DiagramState) super.getState();
    }

    public void addTreeData(String data) {
        getState().treeData = data;
    }

}
