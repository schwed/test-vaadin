package com.kon.vaa.definition.systems;

import com.kon.vaa.definition.creation.NewLineageView;
import com.kon.vaa.generation.sankey.SankeyDiagramView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.vaadin.maddon.button.MButton;
import org.vaadin.maddon.layouts.MHorizontalLayout;
import org.vaadin.maddon.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Created by kshevchuk on 3/25/2016.
 */

@UIScope
@SpringView(name = SystemsSelectionView.VIEW_NAME)
public class SystemsSelectionView extends MVerticalLayout implements View {

    public static final String VIEW_NAME = "systems";

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);

        HorizontalLayout horizontalLayout = new MHorizontalLayout();

        final ListSelect availableSystems = new ListSelect("Available Systems");
        availableSystems.setMultiSelect(Boolean.TRUE);
        availableSystems.setHeight(3, Unit.INCH);
        availableSystems.setWidth(3, Unit.INCH);
        // Add some items (here by the item ID as the caption)
        availableSystems.addItems("System A", "System B", "System C", "System D", "System E", "System F", "System G", "System H", "System I", "System J",  "System K", "System L", "System M", "System N", "System O");
        availableSystems.setNullSelectionAllowed(false);
        // Show 5 items and a scrollbar if there are more
        availableSystems.setRows(5);

        final ListSelect selectedSystems = new ListSelect("Selected Systems");
        selectedSystems.setMultiSelect(Boolean.TRUE);
        selectedSystems.setHeight(3, Unit.INCH);
        selectedSystems.setWidth(3, Unit.INCH);

        VerticalLayout moveButtonsLayout = new MVerticalLayout();
        moveButtonsLayout.setMargin(true);
        moveButtonsLayout.setSpacing(true);

        Button rightButton = new MButton(FontAwesome.ANGLE_RIGHT);
        rightButton.addClickListener( new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Set<String> values =(Set<String>) availableSystems.getValue();

                for (String item : values) {

                    selectedSystems.addItem(item);
                    availableSystems.removeItem(item);
                }


            }
        });

        Button leftButton = new MButton(FontAwesome.ANGLE_LEFT);
        leftButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Set<String> values =(Set<String>) selectedSystems .getValue();
                for (String item : values) {
                    availableSystems.addItem(item);
                    selectedSystems.removeItem(item);

                }
            }
        });

        moveButtonsLayout.addComponents(rightButton, leftButton);
        moveButtonsLayout.setComponentAlignment(rightButton, Alignment.MIDDLE_CENTER);
        moveButtonsLayout.setComponentAlignment(leftButton, Alignment.MIDDLE_CENTER);

        horizontalLayout.addComponents(availableSystems, moveButtonsLayout, selectedSystems);

        HorizontalLayout navigationButtonsLayout = new MHorizontalLayout();
        navigationButtonsLayout.setMargin(true);
        navigationButtonsLayout.setSpacing(true);

        Button backButton  = new MButton("Back");
        backButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(NewLineageView.VIEW_NAME);
            }
        });
        Button clearButton  = new MButton("Clear");
        Button nextButton  = new MButton("Next");
        nextButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(SankeyDiagramView.VIEW_NAME);
            }
        });


        navigationButtonsLayout.addComponents(backButton, clearButton, nextButton);

        addComponents(horizontalLayout, navigationButtonsLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
