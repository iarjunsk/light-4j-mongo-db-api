package com.arjunsk.goswift;

import com.arjunsk.goswift.handler.UsersLoadGetHandler;
import com.arjunsk.goswift.handler.UsersUserIdGetHandler;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.util.Methods;

public class PathHandlerProvider implements HandlerProvider {
  @Override
  public HttpHandler getHandler() {
    return Handlers.routing()
        .add(Methods.GET, "/v1/load", new UsersLoadGetHandler())
        .add(Methods.GET, "/v1/users/{userId}", new UsersUserIdGetHandler());
  }
}
