package org.openremote.manager.client.app;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

/**
 * Abstract activity that provides initialisation with Place passed in
 * Created by Richard on 11/02/2016.
 */
public abstract class AbstractActivity<T extends Place> extends com.google.gwt.activity.shared.AbstractActivity {
    protected abstract void init(T place);

    public Activity doInit(T place) {
        init(place);
        return this;
    }
}