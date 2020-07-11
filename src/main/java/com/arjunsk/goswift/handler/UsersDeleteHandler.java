package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.mongodb.BasicDBObject;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class UsersDeleteHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    // NOTE: Delete *
    BasicDBObject blank = new BasicDBObject();
    MongoStartupHookProvider.db.getCollection("users", User.class).deleteMany(blank);

    // TODO: Fix with the latest method.
    exchange.setResponseCode(204);
    exchange.endExchange();
  }
}
