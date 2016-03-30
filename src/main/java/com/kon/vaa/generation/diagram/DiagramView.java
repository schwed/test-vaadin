package com.kon.vaa.generation.diagram;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.vaadin.maddon.layouts.MVerticalLayout;

import org.json.simple.JSONObject;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by kshevchuk on 3/25/2016.
 */

@UIScope
@SpringView(name = DiagramView.VIEW_NAME)
public class DiagramView extends MVerticalLayout implements View {

    public static final String VIEW_NAME = "diagram";

    String s = "{\"name\": \"flare\",\"size\": 3812}";


    @PostConstruct
    void init() {
        LinkedHashMap childrenObj = new LinkedHashMap();
        childrenObj.put("name", "The Hamburget Postulate");
        childrenObj.put("type", "document");
        childrenObj.put("nodeId", new Integer(3534));

        LinkedHashMap childrenObj1 = new LinkedHashMap();
        childrenObj1.put("name", "Mendeleev");
        childrenObj1.put("type", "author");
        childrenObj1.put("nodeId", new Integer(7734));

        LinkedList listChildNodes = new LinkedList();
        listChildNodes.add(childrenObj);
        listChildNodes.add(childrenObj1);

        JSONObject obj = new JSONObject();
        obj.put("name", "Science");
        obj.put("type", "topic");
        childrenObj.put("nodeId", new Integer(534));
        obj.put("children", listChildNodes);
        obj.put("children", listChildNodes);
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String jsonText = out.toString();

        Diagram diagram = new Diagram();
        diagram.addTreeData(jsonText);
        diagram.setHeight(Page.getCurrent().getBrowserWindowHeight() + "px");
        diagram.setWidth(Page.getCurrent().getBrowserWindowWidth() + "px");
        setSpacing(true);
        addComponent(diagram);
        setSizeFull();
        //setContent(layout);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
