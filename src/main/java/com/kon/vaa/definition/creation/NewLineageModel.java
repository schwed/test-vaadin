package com.kon.vaa.definition.creation;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * Created by kshevchuk on 3/29/2016.
 *
 * includes a data model and some model logic operations
 */
@SpringComponent
@UIScope
public class NewLineageModel {
    private String lineageName;
    private String environment;
    private String date;

    public String getLineageName() {
        return lineageName;
    }

    public void setLineageName(String lineageName) {
        this.lineageName = lineageName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
