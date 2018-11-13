package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    String message;



    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message) {
        this.message = message;
    }

    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }

   /* public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/
}
