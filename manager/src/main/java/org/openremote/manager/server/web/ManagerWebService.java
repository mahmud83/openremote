package org.openremote.manager.server.web;

import org.openremote.container.Container;
import org.openremote.container.web.WebService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static org.openremote.manager.server.Constants.MASTER_REALM;

public class ManagerWebService extends WebService {

    private static final Logger LOG = Logger.getLogger(ManagerWebService.class.getName());

    public static final String WEBSERVER_DOCROOT = "WEBSERVER_DOCROOT";
    public static final String WEBSERVER_DOCROOT_DEFAULT = "src/main/webapp";

    @Override
    protected String getDefaultRealm() {
        return MASTER_REALM;
    }

    @Override
    protected Path getStaticResourceDocRoot(Container container) {
        return Paths.get(container.getConfig(WEBSERVER_DOCROOT, WEBSERVER_DOCROOT_DEFAULT));
    }
}
