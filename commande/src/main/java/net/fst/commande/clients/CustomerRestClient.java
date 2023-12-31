package net.fst.commande.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.fst.commande.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService" , fallbackMethod = "getDefaultCustomer")
    Client findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name="customerService" , fallbackMethod = "getAllCustomers")
    List<Client> allCustomers();

    default Client getDefaultCustomer(Long id ,Exception exception ){
        Client client = new Client();
        client.setId(id);
        client.setNom("Not Available");
        client.setPrénom("Not Available");
        client.setEmail("Not Available");
        client.setAdresse("Not Available");
        return  client;
    }

    default List<Client> getAllCustomers(Exception exception){
        return List.of();
    }

}
