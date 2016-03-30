package com.kon.vaa.generation.sankey;

import com.kon.vaa.definition.systems.SystemsSelectionView;
import com.kon.vaa.generation.diagram.DiagramView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.json.simple.JSONObject;
import org.vaadin.maddon.button.MButton;
import org.vaadin.maddon.layouts.MHorizontalLayout;
import org.vaadin.maddon.layouts.MVerticalLayout;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringWriter;


/**
 * Created by kshevchuk on 3/25/2016.
 */

@UIScope
@SpringView(name = SankeyDiagramView.VIEW_NAME)
public class SankeyDiagramView extends MVerticalLayout implements View {

    public static final String VIEW_NAME = "sankey";

    @PostConstruct
    void init() {

        final Button backButton = new MButton("Back");
        backButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(SystemsSelectionView.VIEW_NAME);
            }
        });

        final Button nextButton = new MButton("Next");
        nextButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(DiagramView.VIEW_NAME);
            }
        });

        SankeyDiagram sankeyDiagram = new SankeyDiagram();

        sankeyDiagram.addSankeyData(sankeyDatata());
        //sankeyDiagram.displayMsg(sankeyDatata());
        //sankeyDiagram.setHeight(Page.getCurrent().getBrowserWindowHeight() + "px");
        //sankeyDiagram.setWidth(Page.getCurrent().getBrowserWindowWidth() + "px");
        //setSpacing(true);
        addComponents(sankeyDiagram, new MHorizontalLayout(backButton, nextButton));
        //setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    private String buildSankeyData() throws IOException {

        JSONObject obj = new JSONObject();

        obj.put("links", "[{'source':'Agricultural Energy Use','target':'Carbon Dioxide','value':'1.4'},\n" +
                "    {'source':'Agriculture','target':'Agriculture Soils','value':'5.2'},\n" +
                "    {'source':'Agriculture','target':'Livestock and Manure','value':'5.4'},\n" +
                "    {'source':'Agriculture','target':'Other Agriculture','value':'1.7'},\n" +
                "    {'source':'Agriculture','target':'Rice Cultivation','value':'1.5'},\n" +
                "    {'source':'Agriculture Soils','target':'Nitrous Oxide','value':'5.2'},\n" +
                "    {'source':'Air','target':'Carbon Dioxide','value':'1.7'},\n" +
                "    {'source':'Aluminium Non-Ferrous Metals','target':'Carbon Dioxide','value':'1.0'},\n" +
                "    {'source':'Aluminium Non-Ferrous Metals','target':'HFCs - PFCs','value':'0.2'},\n" +
                "    {'source':'Cement','target':'Carbon Dioxide','value':'5.0'},\n" +
                "    {'source':'Chemicals','target':'Carbon Dioxide','value':'3.4'},\n" +
                "    {'source':'Chemicals','target':'HFCs - PFCs','value':'0.5'},\n" +
                "    {'source':'Chemicals','target':'Nitrous Oxide','value':'0.2'},\n" +
                "    {'source':'Coal Mining','target':'Carbon Dioxide','value':'0.1'},\n" +
                "    {'source':'Coal Mining','target':'Methane','value':'1.2'},\n" +
                "    {'source':'Commercial Buildings','target':'Carbon Dioxide','value':'6.3'},\n" +
                "    {'source':'Deforestation','target':'Carbon Dioxide','value':'10.9'},\n" +
                "    {'source':'Electricity and heat','target':'Agricultural Energy Use','value':'0.4'},\n" +
                "    {'source':'Electricity and heat','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                "    {'source':'Electricity and heat','target':'Cement','value':'0.3'},\n" +
                "    {'source':'Electricity and heat','target':'Chemicals','value':'1.3'},\n" +
                "    {'source':'Electricity and heat','target':'Commercial Buildings','value':'5.0'},\n" +
                "    {'source':'Electricity and heat','target':'Food and Tobacco','value':'0.5'},\n" +
                "    {'source':'Electricity and heat','target':'Iron and Steel','value':'1.0'},\n" +
                "    {'source':'Electricity and heat','target':'Machinery','value':'1.0'},\n" +
                "    {'source':'Electricity and heat','target':'Oil and Gas Processing','value':'0.4'},\n" +
                "    {'source':'Electricity and heat','target':'Other Industry','value':'2.7'},\n" +
                "    {'source':'Electricity and heat','target':'Pulp - Paper and Printing','value':'0.6'},\n" +
                "    {'source':'Electricity and heat','target':'Residential Buildings','value':'5.2'},\n" +
                "    {'source':'Electricity and heat','target':'T and D Losses','value':'2.2'},\n" +
                "    {'source':'Electricity and heat','target':'Unallocated Fuel Combustion','value':'2.0'},\n" +
                "    {'source':'Energy','target':'Electricity and heat','value':'24.9'},\n" +
                "    {'source':'Energy','target':'Fugitive Emissions','value':'4.0'},\n" +
                "    {'source':'Energy','target':'Industry','value':'14.7'},\n" +
                "    {'source':'Energy','target':'Other Fuel Combustion','value':'8.6'},\n" +
                "    {'source':'Energy','target':'Transportation','value':'14.3'},\n" +
                "    {'source':'Food and Tobacco','target':'Carbon Dioxide','value':'1.0'},\n" +
                "    {'source':'Fugitive Emissions','target':'Coal Mining','value':'1.3'},\n" +
                "    {'source':'Fugitive Emissions','target':'Oil and Gas Processing','value':'3.2'},\n" +
                "    {'source':'Harvest \\/ Management','target':'Carbon Dioxide','value':'1.3'},\n" +
                "    {'source':'Industrial Processes','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                "    {'source':'Industrial Processes','target':'Cement','value':'2.8'},\n" +
                "    {'source':'Industrial Processes','target':'Chemicals','value':'1.4'},\n" +
                "    {'source':'Industrial Processes','target':'Other Industry','value':'0.5'},\n" +
                "    {'source':'Industry','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                "    {'source':'Industry','target':'Cement','value':'1.9'},\n" +
                "    {'source':'Industry','target':'Chemicals','value':'1.4'},\n" +
                "    {'source':'Industry','target':'Food and Tobacco','value':'0.5'},\n" +
                "    {'source':'Industry','target':'Iron and Steel','value':'3.0'},\n" +
                "    {'source':'Industry','target':'Oil and Gas Processing','value':'2.8'},\n" +
                "    {'source':'Industry','target':'Other Industry','value':'3.8'},\n" +
                "    {'source':'Industry','target':'Pulp - Paper and Printing','value':'0.5'},\n" +
                "    {'source':'Iron and Steel','target':'Carbon Dioxide','value':'4.0'},\n" +
                "    {'source':'Land Use Change','target':'Deforestation','value':'10.9'},\n" +
                "    {'source':'Land Use Change','target':'Harvest \\/ Management','value':'1.3'},\n" +
                "    {'source':'Landfills','target':'Methane','value':'1.7'},\n" +
                "    {'source':'Livestock and Manure','target':'Methane','value':'5.1'},\n" +
                "    {'source':'Livestock and Manure','target':'Nitrous Oxide','value':'0.3'},\n" +
                "    {'source':'Machinery','target':'Carbon Dioxide','value':'1.0'},\n" +
                "    {'source':'Oil and Gas Processing','target':'Carbon Dioxide','value':'3.6'},\n" +
                "    {'source':'Oil and Gas Processing','target':'Methane','value':'2.8'},\n" +
                "    {'source':'Other Agriculture','target':'Methane','value':'1.4'},\n" +
                "    {'source':'Other Agriculture','target':'Nitrous Oxide','value':'0.3'},\n" +
                "    {'source':'Other Fuel Combustion','target':'Agricultural Energy Use','value':'1.0'},\n" +
                "    {'source':'Other Fuel Combustion','target':'Commercial Buildings','value':'1.3'},\n" +
                "    {'source':'Other Fuel Combustion','target':'Residential Buildings','value':'5.0'},\n" +
                "    {'source':'Other Fuel Combustion','target':'Unallocated Fuel Combustion','value':'1.8'},\n" +
                "    {'source':'Other Industry','target':'Carbon Dioxide','value':'6.6'},\n" +
                "    {'source':'Other Industry','target':'HFCs - PFCs','value':'0.4'},\n" +
                "    {'source':'Pulp - Paper and Printing','target':'Carbon Dioxide','value':'1.1'},\n" +
                "    {'source':'Rail - Ship and Other Transport','target':'Carbon Dioxide','value':'2.5'},\n" +
                "    {'source':'Residential Buildings','target':'Carbon Dioxide','value':'10.2'},\n" +
                "    {'source':'Rice Cultivation','target':'Methane','value':'1.5'},\n" +
                "    {'source':'Road','target':'Carbon Dioxide','value':'10.5'},\n" +
                "    {'source':'T and D Losses','target':'Carbon Dioxide','value':'2.2'},\n" +
                "    {'source':'Transportation','target':'Air','value':'1.7'},\n" +
                "    {'source':'Transportation','target':'Rail - Ship and Other Transport','value':'2.5'},\n" +
                "    {'source':'Transportation','target':'Road','value':'10.5'},\n" +
                "    {'source':'Unallocated Fuel Combustion','target':'Carbon Dioxide','value':'3.0'},\n" +
                "    {'source':'Unallocated Fuel Combustion','target':'Methane','value':'0.4'},\n" +
                "    {'source':'Unallocated Fuel Combustion','target':'Nitrous Oxide','value':'0.4'},\n" +
                "    {'source':'Waste','target':'Landfills','value':'1.7'},\n" +
                "    {'source':'Waste','target':'Waste water - Other Waste','value':'1.5'},\n" +
                "    {'source':'Waste water - Other Waste','target':'Methane','value':'1.2'},\n" +
                "    {'source':'Waste water - Other Waste','target':'Nitrous Oxide','value':'0.3'}]");
        obj.put("nodes", "[{'name':'Energy'},\n" +
                "    {'name':'Industrial Processes'},\n" +
                "    {'name':'Electricity and heat'},\n" +
                "    {'name':'Industry'},\n" +
                "    {'name':'Land Use Change'},\n" +
                "    {'name':'Agriculture'},\n" +
                "    {'name':'Waste'},\n" +
                "    {'name':'Transportation'},\n" +
                "    {'name':'Other Fuel Combustion'},\n" +
                "    {'name':'Fugitive Emissions'},\n" +
                "    {'name':'Road'},\n" +
                "    {'name':'Air'},\n" +
                "    {'name':'Rail - Ship and Other Transport'},\n" +
                "    {'name':'Residential Buildings'},\n" +
                "    {'name':'Commercial Buildings'},\n" +
                "    {'name':'Unallocated Fuel Combustion'},\n" +
                "    {'name':'Iron and Steel'},\n" +
                "    {'name':'Aluminium Non-Ferrous Metals'},\n" +
                "    {'name':'Machinery'},\n" +
                "    {'name':'Pulp - Paper and Printing'},\n" +
                "    {'name':'Food and Tobacco'},\n" +
                "    {'name':'Chemicals'},\n" +
                "    {'name':'Cement'},\n" +
                "    {'name':'Other Industry'},\n" +
                "    {'name':'T and D Losses'},\n" +
                "    {'name':'Coal Mining'},\n" +
                "    {'name':'Oil and Gas Processing'},\n" +
                "    {'name':'Deforestation'},\n" +
                "    {'name':'Harvest \\/ Management'},\n" +
                "    {'name':'Agricultural Energy Use'},\n" +
                "    {'name':'Agriculture Soils'},\n" +
                "    {'name':'Livestock and Manure'},\n" +
                "    {'name':'Rice Cultivation'},\n" +
                "    {'name':'Other Agriculture'},\n" +
                "    {'name':'Landfills'},\n" +
                "    {'name':'Waste water - Other Waste'},\n" +
                "    {'name':'Carbon Dioxide'},\n" +
                "    {'name':'HFCs - PFCs'},\n" +
                "    {'name':'Methane'},\n" +
                "    {'name':'Nitrous Oxide'}]");

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();

        return jsonText;
    }

    private String getSankeyData() {

         String sankeyData = "{'links': [\n" +
                 "    {'source':'Agricultural Energy Use','target':'Carbon Dioxide','value':'1.4'},\n" +
                 "    {'source':'Agriculture','target':'Agriculture Soils','value':'5.2'},\n" +
                 "    {'source':'Agriculture','target':'Livestock and Manure','value':'5.4'},\n" +
                 "    {'source':'Agriculture','target':'Other Agriculture','value':'1.7'},\n" +
                 "    {'source':'Agriculture','target':'Rice Cultivation','value':'1.5'},\n" +
                 "    {'source':'Agriculture Soils','target':'Nitrous Oxide','value':'5.2'},\n" +
                 "    {'source':'Air','target':'Carbon Dioxide','value':'1.7'},\n" +
                 "    {'source':'Aluminium Non-Ferrous Metals','target':'Carbon Dioxide','value':'1.0'},\n" +
                 "    {'source':'Aluminium Non-Ferrous Metals','target':'HFCs - PFCs','value':'0.2'},\n" +
                 "    {'source':'Cement','target':'Carbon Dioxide','value':'5.0'},\n" +
                 "    {'source':'Chemicals','target':'Carbon Dioxide','value':'3.4'},\n" +
                 "    {'source':'Chemicals','target':'HFCs - PFCs','value':'0.5'},\n" +
                 "    {'source':'Chemicals','target':'Nitrous Oxide','value':'0.2'},\n" +
                 "    {'source':'Coal Mining','target':'Carbon Dioxide','value':'0.1'},\n" +
                 "    {'source':'Coal Mining','target':'Methane','value':'1.2'},\n" +
                 "    {'source':'Commercial Buildings','target':'Carbon Dioxide','value':'6.3'},\n" +
                 "    {'source':'Deforestation','target':'Carbon Dioxide','value':'10.9'},\n" +
                 "    {'source':'Electricity and heat','target':'Agricultural Energy Use','value':'0.4'},\n" +
                 "    {'source':'Electricity and heat','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                 "    {'source':'Electricity and heat','target':'Cement','value':'0.3'},\n" +
                 "    {'source':'Electricity and heat','target':'Chemicals','value':'1.3'},\n" +
                 "    {'source':'Electricity and heat','target':'Commercial Buildings','value':'5.0'},\n" +
                 "    {'source':'Electricity and heat','target':'Food and Tobacco','value':'0.5'},\n" +
                 "    {'source':'Electricity and heat','target':'Iron and Steel','value':'1.0'},\n" +
                 "    {'source':'Electricity and heat','target':'Machinery','value':'1.0'},\n" +
                 "    {'source':'Electricity and heat','target':'Oil and Gas Processing','value':'0.4'},\n" +
                 "    {'source':'Electricity and heat','target':'Other Industry','value':'2.7'},\n" +
                 "    {'source':'Electricity and heat','target':'Pulp - Paper and Printing','value':'0.6'},\n" +
                 "    {'source':'Electricity and heat','target':'Residential Buildings','value':'5.2'},\n" +
                 "    {'source':'Electricity and heat','target':'T and D Losses','value':'2.2'},\n" +
                 "    {'source':'Electricity and heat','target':'Unallocated Fuel Combustion','value':'2.0'},\n" +
                 "    {'source':'Energy','target':'Electricity and heat','value':'24.9'},\n" +
                 "    {'source':'Energy','target':'Fugitive Emissions','value':'4.0'},\n" +
                 "    {'source':'Energy','target':'Industry','value':'14.7'},\n" +
                 "    {'source':'Energy','target':'Other Fuel Combustion','value':'8.6'},\n" +
                 "    {'source':'Energy','target':'Transportation','value':'14.3'},\n" +
                 "    {'source':'Food and Tobacco','target':'Carbon Dioxide','value':'1.0'},\n" +
                 "    {'source':'Fugitive Emissions','target':'Coal Mining','value':'1.3'},\n" +
                 "    {'source':'Fugitive Emissions','target':'Oil and Gas Processing','value':'3.2'},\n" +
                 "    {'source':'Harvest \\/ Management','target':'Carbon Dioxide','value':'1.3'},\n" +
                 "    {'source':'Industrial Processes','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                 "    {'source':'Industrial Processes','target':'Cement','value':'2.8'},\n" +
                 "    {'source':'Industrial Processes','target':'Chemicals','value':'1.4'},\n" +
                 "    {'source':'Industrial Processes','target':'Other Industry','value':'0.5'},\n" +
                 "    {'source':'Industry','target':'Aluminium Non-Ferrous Metals','value':'0.4'},\n" +
                 "    {'source':'Industry','target':'Cement','value':'1.9'},\n" +
                 "    {'source':'Industry','target':'Chemicals','value':'1.4'},\n" +
                 "    {'source':'Industry','target':'Food and Tobacco','value':'0.5'},\n" +
                 "    {'source':'Industry','target':'Iron and Steel','value':'3.0'},\n" +
                 "    {'source':'Industry','target':'Oil and Gas Processing','value':'2.8'},\n" +
                 "    {'source':'Industry','target':'Other Industry','value':'3.8'},\n" +
                 "    {'source':'Industry','target':'Pulp - Paper and Printing','value':'0.5'},\n" +
                 "    {'source':'Iron and Steel','target':'Carbon Dioxide','value':'4.0'},\n" +
                 "    {'source':'Land Use Change','target':'Deforestation','value':'10.9'},\n" +
                 "    {'source':'Land Use Change','target':'Harvest \\/ Management','value':'1.3'},\n" +
                 "    {'source':'Landfills','target':'Methane','value':'1.7'},\n" +
                 "    {'source':'Livestock and Manure','target':'Methane','value':'5.1'},\n" +
                 "    {'source':'Livestock and Manure','target':'Nitrous Oxide','value':'0.3'},\n" +
                 "    {'source':'Machinery','target':'Carbon Dioxide','value':'1.0'},\n" +
                 "    {'source':'Oil and Gas Processing','target':'Carbon Dioxide','value':'3.6'},\n" +
                 "    {'source':'Oil and Gas Processing','target':'Methane','value':'2.8'},\n" +
                 "    {'source':'Other Agriculture','target':'Methane','value':'1.4'},\n" +
                 "    {'source':'Other Agriculture','target':'Nitrous Oxide','value':'0.3'},\n" +
                 "    {'source':'Other Fuel Combustion','target':'Agricultural Energy Use','value':'1.0'},\n" +
                 "    {'source':'Other Fuel Combustion','target':'Commercial Buildings','value':'1.3'},\n" +
                 "    {'source':'Other Fuel Combustion','target':'Residential Buildings','value':'5.0'},\n" +
                 "    {'source':'Other Fuel Combustion','target':'Unallocated Fuel Combustion','value':'1.8'},\n" +
                 "    {'source':'Other Industry','target':'Carbon Dioxide','value':'6.6'},\n" +
                 "    {'source':'Other Industry','target':'HFCs - PFCs','value':'0.4'},\n" +
                 "    {'source':'Pulp - Paper and Printing','target':'Carbon Dioxide','value':'1.1'},\n" +
                 "    {'source':'Rail - Ship and Other Transport','target':'Carbon Dioxide','value':'2.5'},\n" +
                 "    {'source':'Residential Buildings','target':'Carbon Dioxide','value':'10.2'},\n" +
                 "    {'source':'Rice Cultivation','target':'Methane','value':'1.5'},\n" +
                 "    {'source':'Road','target':'Carbon Dioxide','value':'10.5'},\n" +
                 "    {'source':'T and D Losses','target':'Carbon Dioxide','value':'2.2'},\n" +
                 "    {'source':'Transportation','target':'Air','value':'1.7'},\n" +
                 "    {'source':'Transportation','target':'Rail - Ship and Other Transport','value':'2.5'},\n" +
                 "    {'source':'Transportation','target':'Road','value':'10.5'},\n" +
                 "    {'source':'Unallocated Fuel Combustion','target':'Carbon Dioxide','value':'3.0'},\n" +
                 "    {'source':'Unallocated Fuel Combustion','target':'Methane','value':'0.4'},\n" +
                 "    {'source':'Unallocated Fuel Combustion','target':'Nitrous Oxide','value':'0.4'},\n" +
                 "    {'source':'Waste','target':'Landfills','value':'1.7'},\n" +
                 "    {'source':'Waste','target':'Waste water - Other Waste','value':'1.5'},\n" +
                 "    {'source':'Waste water - Other Waste','target':'Methane','value':'1.2'},\n" +
                 "    {'source':'Waste water - Other Waste','target':'Nitrous Oxide','value':'0.3'}\n" +
                 "  ],\n" +
                 "  'nodes': [\n" +
                 "    {'name':'Energy'},\n" +
                 "    {'name':'Industrial Processes'},\n" +
                 "    {'name':'Electricity and heat'},\n" +
                 "    {'name':'Industry'},\n" +
                 "    {'name':'Land Use Change'},\n" +
                 "    {'name':'Agriculture'},\n" +
                 "    {'name':'Waste'},\n" +
                 "    {'name':'Transportation'},\n" +
                 "    {'name':'Other Fuel Combustion'},\n" +
                 "    {'name':'Fugitive Emissions'},\n" +
                 "    {'name':'Road'},\n" +
                 "    {'name':'Air'},\n" +
                 "    {'name':'Rail - Ship and Other Transport'},\n" +
                 "    {'name':'Residential Buildings'},\n" +
                 "    {'name':'Commercial Buildings'},\n" +
                 "    {'name':'Unallocated Fuel Combustion'},\n" +
                 "    {'name':'Iron and Steel'},\n" +
                 "    {'name':'Aluminium Non-Ferrous Metals'},\n" +
                 "    {'name':'Machinery'},\n" +
                 "    {'name':'Pulp - Paper and Printing'},\n" +
                 "    {'name':'Food and Tobacco'},\n" +
                 "    {'name':'Chemicals'},\n" +
                 "    {'name':'Cement'},\n" +
                 "    {'name':'Other Industry'},\n" +
                 "    {'name':'T and D Losses'},\n" +
                 "    {'name':'Coal Mining'},\n" +
                 "    {'name':'Oil and Gas Processing'},\n" +
                 "    {'name':'Deforestation'},\n" +
                 "    {'name':'Harvest \\/ Management'},\n" +
                 "    {'name':'Agricultural Energy Use'},\n" +
                 "    {'name':'Agriculture Soils'},\n" +
                 "    {'name':'Livestock and Manure'},\n" +
                 "    {'name':'Rice Cultivation'},\n" +
                 "    {'name':'Other Agriculture'},\n" +
                 "    {'name':'Landfills'},\n" +
                 "    {'name':'Waste water - Other Waste'},\n" +
                 "    {'name':'Carbon Dioxide'},\n" +
                 "    {'name':'HFCs - PFCs'},\n" +
                 "    {'name':'Methane'},\n" +
                 "    {'name':'Nitrous Oxide'}\n" +
                 "  ]}";

        return sankeyData;
    }

    private String sankeyDatata() {

        String data = "{\"links\": [\n" +
                "    {\"source\":\"Agricultural Energy Use\",\"target\":\"Carbon Dioxide\",\"value\":\"1.4\"},\n" +
                "    {\"source\":\"Agriculture\",\"target\":\"Agriculture Soils\",\"value\":\"5.2\"},\n" +
                "    {\"source\":\"Agriculture\",\"target\":\"Livestock and Manure\",\"value\":\"5.4\"},\n" +
                "    {\"source\":\"Agriculture\",\"target\":\"Other Agriculture\",\"value\":\"1.7\"},\n" +
                "    {\"source\":\"Agriculture\",\"target\":\"Rice Cultivation\",\"value\":\"1.5\"},\n" +
                "    {\"source\":\"Agriculture Soils\",\"target\":\"Nitrous Oxide\",\"value\":\"5.2\"},\n" +
                "    {\"source\":\"Air\",\"target\":\"Carbon Dioxide\",\"value\":\"1.7\"},\n" +
                "    {\"source\":\"Aluminium Non-Ferrous Metals\",\"target\":\"Carbon Dioxide\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Aluminium Non-Ferrous Metals\",\"target\":\"HFCs - PFCs\",\"value\":\"0.2\"},\n" +
                "    {\"source\":\"Cement\",\"target\":\"Carbon Dioxide\",\"value\":\"5.0\"},\n" +
                "    {\"source\":\"Chemicals\",\"target\":\"Carbon Dioxide\",\"value\":\"3.4\"},\n" +
                "    {\"source\":\"Chemicals\",\"target\":\"HFCs - PFCs\",\"value\":\"0.5\"},\n" +
                "    {\"source\":\"Chemicals\",\"target\":\"Nitrous Oxide\",\"value\":\"0.2\"},\n" +
                "    {\"source\":\"Coal Mining\",\"target\":\"Carbon Dioxide\",\"value\":\"0.1\"},\n" +
                "    {\"source\":\"Coal Mining\",\"target\":\"Methane\",\"value\":\"1.2\"},\n" +
                "    {\"source\":\"Commercial Buildings\",\"target\":\"Carbon Dioxide\",\"value\":\"6.3\"},\n" +
                "    {\"source\":\"Deforestation\",\"target\":\"Carbon Dioxide\",\"value\":\"10.9\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Agricultural Energy Use\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Aluminium Non-Ferrous Metals\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Cement\",\"value\":\"0.3\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Chemicals\",\"value\":\"1.3\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Commercial Buildings\",\"value\":\"5.0\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Food and Tobacco\",\"value\":\"0.5\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Iron and Steel\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Machinery\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Oil and Gas Processing\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Other Industry\",\"value\":\"2.7\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Pulp - Paper and Printing\",\"value\":\"0.6\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Residential Buildings\",\"value\":\"5.2\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"T and D Losses\",\"value\":\"2.2\"},\n" +
                "    {\"source\":\"Electricity and heat\",\"target\":\"Unallocated Fuel Combustion\",\"value\":\"2.0\"},\n" +
                "    {\"source\":\"Energy\",\"target\":\"Electricity and heat\",\"value\":\"24.9\"},\n" +
                "    {\"source\":\"Energy\",\"target\":\"Fugitive Emissions\",\"value\":\"4.0\"},\n" +
                "    {\"source\":\"Energy\",\"target\":\"Industry\",\"value\":\"14.7\"},\n" +
                "    {\"source\":\"Energy\",\"target\":\"Other Fuel Combustion\",\"value\":\"8.6\"},\n" +
                "    {\"source\":\"Energy\",\"target\":\"Transportation\",\"value\":\"14.3\"},\n" +
                "    {\"source\":\"Food and Tobacco\",\"target\":\"Carbon Dioxide\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Fugitive Emissions\",\"target\":\"Coal Mining\",\"value\":\"1.3\"},\n" +
                "    {\"source\":\"Fugitive Emissions\",\"target\":\"Oil and Gas Processing\",\"value\":\"3.2\"},\n" +
                "    {\"source\":\"Harvest \\/ Management\",\"target\":\"Carbon Dioxide\",\"value\":\"1.3\"},\n" +
                "    {\"source\":\"Industrial Processes\",\"target\":\"Aluminium Non-Ferrous Metals\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Industrial Processes\",\"target\":\"Cement\",\"value\":\"2.8\"},\n" +
                "    {\"source\":\"Industrial Processes\",\"target\":\"Chemicals\",\"value\":\"1.4\"},\n" +
                "    {\"source\":\"Industrial Processes\",\"target\":\"Other Industry\",\"value\":\"0.5\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Aluminium Non-Ferrous Metals\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Cement\",\"value\":\"1.9\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Chemicals\",\"value\":\"1.4\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Food and Tobacco\",\"value\":\"0.5\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Iron and Steel\",\"value\":\"3.0\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Oil and Gas Processing\",\"value\":\"2.8\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Other Industry\",\"value\":\"3.8\"},\n" +
                "    {\"source\":\"Industry\",\"target\":\"Pulp - Paper and Printing\",\"value\":\"0.5\"},\n" +
                "    {\"source\":\"Iron and Steel\",\"target\":\"Carbon Dioxide\",\"value\":\"4.0\"},\n" +
                "    {\"source\":\"Land Use Change\",\"target\":\"Deforestation\",\"value\":\"10.9\"},\n" +
                "    {\"source\":\"Land Use Change\",\"target\":\"Harvest \\/ Management\",\"value\":\"1.3\"},\n" +
                "    {\"source\":\"Landfills\",\"target\":\"Methane\",\"value\":\"1.7\"},\n" +
                "    {\"source\":\"Livestock and Manure\",\"target\":\"Methane\",\"value\":\"5.1\"},\n" +
                "    {\"source\":\"Livestock and Manure\",\"target\":\"Nitrous Oxide\",\"value\":\"0.3\"},\n" +
                "    {\"source\":\"Machinery\",\"target\":\"Carbon Dioxide\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Oil and Gas Processing\",\"target\":\"Carbon Dioxide\",\"value\":\"3.6\"},\n" +
                "    {\"source\":\"Oil and Gas Processing\",\"target\":\"Methane\",\"value\":\"2.8\"},\n" +
                "    {\"source\":\"Other Agriculture\",\"target\":\"Methane\",\"value\":\"1.4\"},\n" +
                "    {\"source\":\"Other Agriculture\",\"target\":\"Nitrous Oxide\",\"value\":\"0.3\"},\n" +
                "    {\"source\":\"Other Fuel Combustion\",\"target\":\"Agricultural Energy Use\",\"value\":\"1.0\"},\n" +
                "    {\"source\":\"Other Fuel Combustion\",\"target\":\"Commercial Buildings\",\"value\":\"1.3\"},\n" +
                "    {\"source\":\"Other Fuel Combustion\",\"target\":\"Residential Buildings\",\"value\":\"5.0\"},\n" +
                "    {\"source\":\"Other Fuel Combustion\",\"target\":\"Unallocated Fuel Combustion\",\"value\":\"1.8\"},\n" +
                "    {\"source\":\"Other Industry\",\"target\":\"Carbon Dioxide\",\"value\":\"6.6\"},\n" +
                "    {\"source\":\"Other Industry\",\"target\":\"HFCs - PFCs\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Pulp - Paper and Printing\",\"target\":\"Carbon Dioxide\",\"value\":\"1.1\"},\n" +
                "    {\"source\":\"Rail - Ship and Other Transport\",\"target\":\"Carbon Dioxide\",\"value\":\"2.5\"},\n" +
                "    {\"source\":\"Residential Buildings\",\"target\":\"Carbon Dioxide\",\"value\":\"10.2\"},\n" +
                "    {\"source\":\"Rice Cultivation\",\"target\":\"Methane\",\"value\":\"1.5\"},\n" +
                "    {\"source\":\"Road\",\"target\":\"Carbon Dioxide\",\"value\":\"10.5\"},\n" +
                "    {\"source\":\"T and D Losses\",\"target\":\"Carbon Dioxide\",\"value\":\"2.2\"},\n" +
                "    {\"source\":\"Transportation\",\"target\":\"Air\",\"value\":\"1.7\"},\n" +
                "    {\"source\":\"Transportation\",\"target\":\"Rail - Ship and Other Transport\",\"value\":\"2.5\"},\n" +
                "    {\"source\":\"Transportation\",\"target\":\"Road\",\"value\":\"10.5\"},\n" +
                "    {\"source\":\"Unallocated Fuel Combustion\",\"target\":\"Carbon Dioxide\",\"value\":\"3.0\"},\n" +
                "    {\"source\":\"Unallocated Fuel Combustion\",\"target\":\"Methane\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Unallocated Fuel Combustion\",\"target\":\"Nitrous Oxide\",\"value\":\"0.4\"},\n" +
                "    {\"source\":\"Waste\",\"target\":\"Landfills\",\"value\":\"1.7\"},\n" +
                "    {\"source\":\"Waste\",\"target\":\"Waste water - Other Waste\",\"value\":\"1.5\"},\n" +
                "    {\"source\":\"Waste water - Other Waste\",\"target\":\"Methane\",\"value\":\"1.2\"},\n" +
                "    {\"source\":\"Waste water - Other Waste\",\"target\":\"Nitrous Oxide\",\"value\":\"0.3\"}\n" +
                "  ],\n" +
                "  \"nodes\": [\n" +
                "    {\"name\":\"Energy\"},\n" +
                "    {\"name\":\"Industrial Processes\"},\n" +
                "    {\"name\":\"Electricity and heat\"},\n" +
                "    {\"name\":\"Industry\"},\n" +
                "    {\"name\":\"Land Use Change\"},\n" +
                "    {\"name\":\"Agriculture\"},\n" +
                "    {\"name\":\"Waste\"},\n" +
                "    {\"name\":\"Transportation\"},\n" +
                "    {\"name\":\"Other Fuel Combustion\"},\n" +
                "    {\"name\":\"Fugitive Emissions\"},\n" +
                "    {\"name\":\"Road\"},\n" +
                "    {\"name\":\"Air\"},\n" +
                "    {\"name\":\"Rail - Ship and Other Transport\"},\n" +
                "    {\"name\":\"Residential Buildings\"},\n" +
                "    {\"name\":\"Commercial Buildings\"},\n" +
                "    {\"name\":\"Unallocated Fuel Combustion\"},\n" +
                "    {\"name\":\"Iron and Steel\"},\n" +
                "    {\"name\":\"Aluminium Non-Ferrous Metals\"},\n" +
                "    {\"name\":\"Machinery\"},\n" +
                "    {\"name\":\"Pulp - Paper and Printing\"},\n" +
                "    {\"name\":\"Food and Tobacco\"},\n" +
                "    {\"name\":\"Chemicals\"},\n" +
                "    {\"name\":\"Cement\"},\n" +
                "    {\"name\":\"Other Industry\"},\n" +
                "    {\"name\":\"T and D Losses\"},\n" +
                "    {\"name\":\"Coal Mining\"},\n" +
                "    {\"name\":\"Oil and Gas Processing\"},\n" +
                "    {\"name\":\"Deforestation\"},\n" +
                "    {\"name\":\"Harvest \\/ Management\"},\n" +
                "    {\"name\":\"Agricultural Energy Use\"},\n" +
                "    {\"name\":\"Agriculture Soils\"},\n" +
                "    {\"name\":\"Livestock and Manure\"},\n" +
                "    {\"name\":\"Rice Cultivation\"},\n" +
                "    {\"name\":\"Other Agriculture\"},\n" +
                "    {\"name\":\"Landfills\"},\n" +
                "    {\"name\":\"Waste water - Other Waste\"},\n" +
                "    {\"name\":\"Carbon Dioxide\"},\n" +
                "    {\"name\":\"HFCs - PFCs\"},\n" +
                "    {\"name\":\"Methane\"},\n" +
                "    {\"name\":\"Nitrous Oxide\"}\n" +
                "  ]}";

        return data;
    }

}
