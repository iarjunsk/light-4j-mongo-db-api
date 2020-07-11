package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.networknt.body.BodyHandler;
import com.networknt.config.Config;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersPostHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    Map<String, String> body =
        (Map<String, String>) exchange.getAttachment(BodyHandler.REQUEST_BODY);

    User user = new User();
    if (body.get("id") != null) {
      throw new Exception("Id not required");
    } else {
      user.setId(UUID.randomUUID().toString());
    }
    user.setName(body.get("name"));
    user.setEmail(body.get("email"));

    MongoStartupHookProvider.db.getCollection("users", User.class).insertOne(user);

    exchange.setResponseCode(201);
    exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
    String result = Config.getInstance().getMapper().writeValueAsString(user);
    exchange.getResponseSender().send(result);
  }
}
