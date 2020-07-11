package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersLoadGetHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    List<User> users = new ArrayList<>();
    users.add(new User(UUID.randomUUID().toString(), "Arjun SK", "arjunsk15@gmail.com"));
    users.add(new User(UUID.randomUUID().toString(), "Admin", "admin@arjunsk.com"));

    MongoStartupHookProvider.db.createCollection("users");
    MongoStartupHookProvider.db.getCollection("users", User.class).insertMany(users);

    exchange.endExchange();
  }
}
