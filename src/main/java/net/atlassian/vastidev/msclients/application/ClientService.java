package net.atlassian.vastidev.msclients.application;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.atlassian.vastidev.msclients.domain.Client;
import net.atlassian.vastidev.msclients.infra.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCPF (String cpf){
        return repository.findByCpf(cpf);
    }

}

