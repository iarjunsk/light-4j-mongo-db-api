package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.mongodb.client.model.Filters;
import com.networknt.config.Config;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersUserIdGetHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    // NOTE: Getting Path Param
    String userId = exchange.getQueryParameters().get("userId").getFirst();

    exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
    User user =
        MongoStartupHookProvider.db
            .getCollection("users", User.class)
            .find(Filters.eq("_id", userId))
            .first();

    // NOTE: Sending JSON String
    String result = Config.getInstance().getMapper().writeValueAsString(user);
    exchange.getResponseSender().send(result);
  }
}
