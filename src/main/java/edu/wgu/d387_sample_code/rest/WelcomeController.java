package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.Welcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    private Welcome welcome;

    public WelcomeController(Welcome welcome) {
        this.welcome = welcome;
    }

    @GetMapping("/welcome")
    public String[] getWelcome() {
        return welcome.loadWelcome("welcome");
    }
}
