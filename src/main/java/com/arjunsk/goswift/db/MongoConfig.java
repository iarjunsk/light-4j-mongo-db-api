package com.arjunsk.goswift.db;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MongoConfig {
  String description;
  String host;
  String name;
}
