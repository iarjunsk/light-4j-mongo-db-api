package com.arjunsk.goswift.handler;

import com.networknt.handler.LightHttpHandler;
import io.undertow.server.HttpServerExchange;

public class UsersLoadGetHandler implements LightHttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    exchange.endExchange();
  }
}
