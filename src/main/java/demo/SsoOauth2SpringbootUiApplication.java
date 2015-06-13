package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@EnableZuulProxy
@EnableRedisHttpSession
public class SsoOauth2SpringbootUiApplication {

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session){
        return Collections.singletonMap("token", session.getId());
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoOauth2SpringbootUiApplication.class, args);
    }
}
