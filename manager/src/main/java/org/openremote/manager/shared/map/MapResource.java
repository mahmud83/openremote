package org.openremote.manager.shared.map;

import elemental.json.JsonObject;
import jsinterop.annotations.JsType;
import org.jboss.resteasy.annotations.Form;
import org.openremote.manager.shared.http.RequestParams;
import org.openremote.manager.shared.http.SuccessStatusCode;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("map")
@JsType(isNative = true)
public interface MapResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @SuccessStatusCode(200)
    @RolesAllowed({"read:map"})
    JsonObject getSettings(@Form RequestParams requestParams);

    @GET
    @Produces("application/vnd.mapbox-vector-tile")
    @Path("tile/{zoom}/{column}/{row}")
    byte[] getTile(@PathParam("zoom")int zoom, @PathParam("column")int column, @PathParam("row")int row);
}
