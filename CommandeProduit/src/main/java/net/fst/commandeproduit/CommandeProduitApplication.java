package net.fst.commandeproduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommandeProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeProduitApplication.class, args);
    }

}
