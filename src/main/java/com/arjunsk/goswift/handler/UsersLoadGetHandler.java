package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.mongodb.MongoCommandException;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersLoadGetHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    // Static Content Loading
    List<User> users = new ArrayList<>();
    users.add(new User(UUID.randomUUID().toString(), "Arjun SK", "arjunsk15@gmail.com"));
    users.add(new User(UUID.randomUUID().toString(), "Admin", "admin@arjunsk.com"));

    // Create Collection only once
    try {
      MongoStartupHookProvider.db.createCollection("users");
    } catch (MongoCommandException ex) {
      log.warn("Collection already exist");
    }
    MongoStartupHookProvider.db.getCollection("users", User.class).insertMany(users);
    exchange.endExchange();
  }
}
