package net.fst.client.web;


import net.fst.client.entities.Client;
import net.fst.client.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRestController {
    private ClientRepository clientRepository;

    public ClientRestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("/customers")
    public List<Client> listClients(){
        return clientRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Client customerById(@PathVariable Long id)
    {
        return clientRepository.findById(id).get();
    }
    @PostMapping("/customers")
    public Client saveClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @PutMapping("/customers/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id){
        client.setId(id);
        return clientRepository.save(client);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
    }

}
