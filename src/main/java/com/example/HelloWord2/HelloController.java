package com.example.HelloWord2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*") // Autoriser toutes les requêtes CORS
@RestController
@RequestMapping("/api")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController() {
        logger.info("🚀 [LOG] - HelloController initialisé !");
    }

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("✅ [LOG] - Endpoint /hello appelé !");
        return "Hello niama!";
    }

    // Nouveau endpoint avec un paramètre
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "visiteur") String name) {
        logger.info("✅ [LOG] - Endpoint /greet appelé avec name={}", name);
        return "Hello, " + name + "!";
    }

    // Endpoint pour éviter l'erreur Whitelabel
    @GetMapping("/")
    public String home() {
        logger.info("✅ [LOG] - Endpoint / appelé !");
        return "Bienvenue sur l'API HelloWorld2 !";
    }
}
