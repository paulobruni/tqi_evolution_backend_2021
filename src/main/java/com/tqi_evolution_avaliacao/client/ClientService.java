package com.tqi_evolution_avaliacao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client newClient)
    {
        Client client = new Client();
        client.setNome(newClient.getNome());
        client.setEmail(newClient.getEmail());
        client.setCpf(newClient.getCpf());
        client.setRg(newClient.getRg());
        client.setAddress(newClient.getAddress());
        client.setIncome(newClient.getIncome());
        client.setPassword(newClient.getPassword());

        return clientRepository.save(client);
    }
}
