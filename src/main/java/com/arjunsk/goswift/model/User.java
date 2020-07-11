package com.arjunsk.goswift.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  @JsonProperty private String id;

  @JsonProperty private String name;

  @JsonProperty private String email;
}
