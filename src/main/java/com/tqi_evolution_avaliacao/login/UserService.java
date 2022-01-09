package com.tqi_evolution_avaliacao.login;

import com.tqi_evolution_avaliacao.client.Client;
import com.tqi_evolution_avaliacao.client.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    private final ClientRepository clientRepository;

    public UserService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Client> client = clientRepository.findByEmail(username);

        if(client.isEmpty())
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");

        return new UserDetailData(client);
    }
}
