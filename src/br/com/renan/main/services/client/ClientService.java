package br.com.renan.main.services.client;

import br.com.renan.main.domain.Client;
import br.com.renan.main.repositories.generic.IGenericRepo;
import br.com.renan.main.services.client.dto.CreateClientDTO;
import br.com.renan.main.services.client.dto.DeleteClientDTO;
import br.com.renan.main.services.client.dto.GetClientDTO;
import br.com.renan.main.services.client.dto.UpdateClientDTO;

import java.util.List;

public class ClientService implements IClientService{
    private IGenericRepo<Client> clientRepo;

    public ClientService(IGenericRepo<Client> repo) {
        clientRepo = repo;
    }

    @Override
    public Client createClient(CreateClientDTO data) {
        Client client = new Client();
        client.setCpf(data.cpf());
        client.setName(data.name());
        client.setTel(data.tel());
        client.setStreet(data.street());
        client.setCity(data.city());
        client.setState(data.state());
        client.setNumber(data.number());

        return clientRepo.create(client);
    }

    @Override
    public Boolean deleteClient(DeleteClientDTO data) {
        return clientRepo.delete(data.uuid());
    }

    @Override
    public Client getClient(GetClientDTO data) {
        return clientRepo.get(data.uuid());
    }

    @Override
    public List<Client> listClients() {
        return (List<Client>) clientRepo.list();
    }

    @Override
    public Client updateClient(UpdateClientDTO data) {
        Client client = new Client();
        client.setUuid(data.uuid());
        client.setCpf(data.cpf());
        client.setName(data.name());
        client.setTel(data.tel());
        client.setStreet(data.street());
        client.setCity(data.city());
        client.setState(data.state());
        client.setNumber(data.number());

        return clientRepo.update(data.uuid(), client);
    }
}
