package org.ovirt.engine.api.resource;

import org.ovirt.engine.api.model.WatchDog;

import javax.ws.rs.DELETE;
import javax.ws.rs.core.Response;

public interface WatchdogResource extends DeviceResource<WatchDog> {
    @DELETE
    Response remove();
}
