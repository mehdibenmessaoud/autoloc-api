package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client saveClient(Client client);

    Client updateClient(Long id, Client client);

    List<Client> getAllClients();

    Optional<Client> getClientById(Long id);

    Optional<Client> getClientByEmail(String email);

    Optional<Client> getClientByNumPermis(String numPermis);

    void deleteClient(Long id);
}
