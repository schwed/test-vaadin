package com.kon.vaa.definition.systems;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;
import org.vaadin.spring.mvp.Presenter;


/**
 * Created by kshevchuk on 3/25/2016.
 */

@UIScope
@SpringComponent
public class SystemsSelectionPresenter extends Presenter<SystemsSelectionView> implements InitializingBean {

    @Autowired
    private EventBus eventBus;

    public SystemsSelectionPresenter(SystemsSelectionView view, EventBus eventBus) {
        super(view, eventBus);
    }

    @EventBusListenerMethod
    public void onNewCaption(String caption) {
        getView().setCaption(caption);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        eventBus.subscribe(this);
    }
}
