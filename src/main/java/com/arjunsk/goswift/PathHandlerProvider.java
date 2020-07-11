package com.arjunsk.goswift;

import com.arjunsk.goswift.handler.UsersDeleteHandler;
import com.arjunsk.goswift.handler.UsersLoadGetHandler;
import com.arjunsk.goswift.handler.UsersPostHandler;
import com.arjunsk.goswift.handler.UsersUserIdDeleteHandler;
import com.arjunsk.goswift.handler.UsersUserIdGetHandler;
import com.arjunsk.goswift.handler.UsersUserIdPutHandler;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.util.Methods;

public class PathHandlerProvider implements HandlerProvider {
  @Override
  public HttpHandler getHandler() {
    return Handlers.routing()
        .add(Methods.GET, "/v1/load", new UsersLoadGetHandler())
        .add(Methods.GET, "/v1/users/{userId}", new UsersUserIdGetHandler())
        .add(Methods.POST, "/v1/users", new UsersPostHandler())
        .add(Methods.PUT, "/v1/users/{userId}", new UsersUserIdPutHandler())
        .add(Methods.DELETE, "/v1/users/{userId}", new UsersUserIdDeleteHandler())
        .add(Methods.DELETE, "/v1/users", new UsersDeleteHandler());
  }
}
