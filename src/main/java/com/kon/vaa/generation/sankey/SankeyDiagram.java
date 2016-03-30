package com.kon.vaa.generation.sankey;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Created by kshevchuk on 3/25/2016.
 */
@StyleSheet({ "sankey-styles.css" })
@JavaScript({ "d3.min.js", "sankey.js", "diagram_connector_sankey.js", "jquery-1.11.3.min.js" })
public class SankeyDiagram extends AbstractJavaScriptComponent {


    @Override
    public SankeyDiagramState getState() {
        return (SankeyDiagramState) super.getState();
    }

    public void addSankeyData(String data) {
        getState().sankeyData = data;
    }

}
