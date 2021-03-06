/*
 * Copyright 2017, OpenRemote Inc.
 *
 * See the CONTRIBUTORS.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.app.client.assets;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openremote.app.client.assets.asset.*;
import org.openremote.app.client.assets.browser.AssetBrowser;
import org.openremote.app.client.assets.browser.AssetBrowserImpl;
import org.openremote.app.client.assets.browser.AssetBrowserPresenter;
import org.openremote.app.client.assets.navigation.AssetNavigation;
import org.openremote.app.client.assets.navigation.AssetNavigationImpl;
import org.openremote.app.client.assets.tenant.AssetsTenant;
import org.openremote.app.client.assets.tenant.AssetsTenantActivity;
import org.openremote.app.client.assets.tenant.AssetsTenantImpl;
import org.openremote.model.asset.agent.AgentResource;
import org.openremote.model.asset.AssetResource;
import org.openremote.model.datapoint.AssetDatapointResource;

public class AssetsModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(AssetBrowser.class).to(AssetBrowserImpl.class).in(Singleton.class);
        bind(AssetBrowser.Presenter.class).to(AssetBrowserPresenter.class).in(Singleton.class);

        bind(AssetsDashboard.class).to(AssetsDashboardImpl.class).in(Singleton.class);
        bind(AssetsDashboardActivity.class);

        bind(AssetsTenant.class).to(AssetsTenantImpl.class).in(Singleton.class);
        bind(AssetsTenantActivity.class);

        bind(AssetNavigation.class).to(AssetNavigationImpl.class).in(Singleton.class);

        bind(AssetView.class).to(AssetViewImpl.class).in(Singleton.class);
        bind(AssetViewActivity.class);

        bind(AssetEdit.class).to(AssetEditImpl.class).in(Singleton.class);
        bind(AssetEditActivity.class);
    }

    @Provides
    @Singleton
    public native AssetResource getAssetResource() /*-{
        return $wnd.openremote.REST.AssetResource;
    }-*/;

    @Provides
    @Singleton
    public native AssetDatapointResource getAssetDatapointResource() /*-{
        return $wnd.openremote.REST.AssetDatapointResource;
    }-*/;

    @Provides
    @Singleton
    public native AgentResource getAgentResource() /*-{
        return $wnd.openremote.REST.AgentResource;
    }-*/;
}
