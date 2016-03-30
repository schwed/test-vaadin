package com.kon.vaa.definition.creation;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.mvp.Presenter;

/**
 * Created by kshevchuk on 3/29/2016.
 *
 * handles the user interface logic
 */

@UIScope
@SpringComponent
class NewLineagePresenter extends Presenter<NewLineageView> implements InitializingBean {


    @Autowired
    private EventBus.ViewEventBus eventBus; // specific to the current view instance

    public NewLineagePresenter(NewLineageView view, EventBus eventBus) {
        super(view, eventBus);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        eventBus.subscribe(this);
    }

    @Override
    public NewLineageView getView() {
        return super.getView();
    }

    @Override
    public EventBus getEventBus() {
        return super.getEventBus();
    }

}
