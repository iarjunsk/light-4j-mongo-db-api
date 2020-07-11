package com.arjunsk.goswift.model;

import lombok.Data;

@Data
public class Error {
  private String message;
  private Integer code;
}
