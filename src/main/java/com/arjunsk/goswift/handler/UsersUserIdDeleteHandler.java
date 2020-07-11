package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.mongodb.client.model.Filters;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class UsersUserIdDeleteHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    String userId = exchange.getQueryParameters().get("userId").getFirst();

    MongoStartupHookProvider.db
        .getCollection("users", User.class)
        .findOneAndDelete(Filters.eq("_id", userId));

    // TODO: Fix with the latest method.
    exchange.setResponseCode(204);
    exchange.endExchange();
  }
}
