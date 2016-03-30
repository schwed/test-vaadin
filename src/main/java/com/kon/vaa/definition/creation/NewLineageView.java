package com.kon.vaa.definition.creation;

import com.kon.vaa.definition.systems.SystemsSelectionView;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.maddon.button.MButton;
import org.vaadin.maddon.layouts.MFormLayout;
import org.vaadin.maddon.layouts.MHorizontalLayout;
import org.vaadin.maddon.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kshevchuk on 3/25/2016.
 *
 * View is responsible only for construction,
 * Presenter is responsible for View UI logic
 * Model is responsible for data
 */

@UIScope
@SpringView(name = NewLineageView.VIEW_NAME)
public class NewLineageView extends MVerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        final FormLayout formLayout = new MFormLayout();

        final TextField lineageName = new TextField("Enter the name of the Lineage to Create:");
        lineageName.addStyleName(ValoTheme.TEXTFIELD_TINY);
        lineageName.setRequired(true);

        final ComboBox combobox = new ComboBox("The environment for lineage inference:");
        combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(true);
        combobox.setTextInputAllowed(false);
        combobox.setRequired(true);
        combobox.addItem("DEV");
        combobox.addItem("UAT");
        combobox.addItem("PROD");
        combobox.setInputPrompt("Select environment");
        combobox.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                if (combobox.isEmpty()) {
                    combobox.select(null);
                }
            }
        });

        final DateField dateField = new DateField("Date of Lineage inference:");

        dateField.setValue(new Date());
        dateField.setLocale(new Locale("en", "US"));
        dateField.setDateFormat("yyyy-MM-dd");

        HorizontalLayout buttonsLayout = new MHorizontalLayout();
        buttonsLayout.setMargin(true);
        buttonsLayout.setSpacing(true);

        Button clearButton = new MButton("Clear");
        clearButton.addStyleName(ValoTheme.BUTTON_SMALL);
        clearButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                lineageName.clear();
                //lineageEnvironment.clear();
                combobox.select(null);

                dateField.setValue(new Date());

            }
        });

        Button nextButton = new MButton("Next");
        nextButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                if (lineageName.isEmpty() || combobox.isEmpty() || dateField.isEmpty()) {
                    Notification.show("Please Enter values for all fields.");
                    return;
                }
                getUI().getNavigator().navigateTo(SystemsSelectionView.VIEW_NAME);

            }
        });

        buttonsLayout.addComponents(clearButton, nextButton);

        formLayout.addComponents(lineageName, combobox, dateField, buttonsLayout);
        formLayout.setMargin(true);
        formLayout.setSpacing(true);
        addComponent(formLayout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // the view is constructed in the init() method()
    }

}
