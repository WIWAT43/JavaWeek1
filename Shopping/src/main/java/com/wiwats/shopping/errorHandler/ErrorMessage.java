package com.wiwats.shopping.errorHandler;

import lombok.Data;

@Data
public class ErrorMessage {
    private String message;

    public void setMessage(String errorMessage) {
      switch (errorMessage) {
          case "101":   this.message ="Data incorrect"; break;
          case "102":   this.message ="Username not available"; break;
          case "103":   this.message ="Can not save to database"; break;
          default:   this.message =errorMessage;
      }

    }
}
