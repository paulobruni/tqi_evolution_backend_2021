package com.tqi_evolution_avaliacao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    private PasswordEncoder encoder;

    @Autowired
    ClientService clientService;

    public ClientResource(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client newClient)
    {
        newClient.setPassword(encoder.encode(newClient.getPassword()));
        Client client = clientService.create(newClient);

        if (client == null)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
