package com.rekai.comp367lab2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

   @GetMapping("/")
   public String index() {
      LocalTime currentTime = LocalTime.now();
      LocalTime noon = LocalTime.NOON;
      boolean afternoon = currentTime.isAfter(noon);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
      
      String dayTime = afternoon ? "afternoon" : "morning";
      String greeting = String.format("Good %s, Natalie. Welcome to COMP367. \n\n", dayTime);
      String currenTimetDisplay = String.format("Current time is: %s", currentTime.format(formatter));

      return greeting + currenTimetDisplay;
   }
}

