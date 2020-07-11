package com.arjunsk.goswift.handler;

import com.arjunsk.goswift.db.MongoStartupHookProvider;
import com.arjunsk.goswift.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.networknt.body.BodyHandler;
import com.networknt.config.Config;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import java.util.Map;

public class UsersUserIdPutHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {

    String userId = exchange.getQueryParameters().get("userId").getFirst();

    Map<String, String> body =
        (Map<String, String>) exchange.getAttachment(BodyHandler.REQUEST_BODY);

    User user = new User();
    user.setId(userId);
    user.setName(body.get("name"));
    user.setEmail(body.get("email"));

    MongoStartupHookProvider.db
        .getCollection("users", User.class)
        .updateOne(Filters.eq("_id", userId), new BasicDBObject("$set", user));

    exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
    String result = Config.getInstance().getMapper().writeValueAsString(user);
    exchange.getResponseSender().send(result);
  }
}
