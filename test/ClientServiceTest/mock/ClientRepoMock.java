package ClientServiceTest.mock;

import br.com.renan.main.domain.Client;
import br.com.renan.main.repositories.generic.GenericRepo;
import br.com.renan.main.repositories.generic.IGenericRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientRepoMock implements IGenericRepo<Client> {
    @Override
    public Client create(Client model) {
        Client client = new Client();
        client.setUuid("8c5a5e25-9c7a-406e-b107-e36386c173da");
        client.setName("Renan");
        client.setCpf("35744431112");
        client.setTel("11912341234");
        client.setStreet("Rua Jorge Augusto");
        client.setState("SP");
        client.setCity("São Paulo");
        client.setNumber(449);

        return client;
    }

    @Override
    public Boolean delete(String key) {
        return true;
    }

    @Override
    public Client get(String key) {
        Client client = new Client();
        client.setUuid("8c5a5e25-9c7a-406e-b107-e36386c173da");
        client.setName("Renan");
        client.setCpf("35744431112");
        client.setTel("11912341234");
        client.setStreet("Rua Jorge Augusto");
        client.setState("SP");
        client.setCity("São Paulo");
        client.setNumber(449);
        return client;
    }

    @Override
    public Collection<Client> list() {
        Client client = new Client();
        client.setUuid("8c5a5e25-9c7a-406e-b107-e36386c173da");
        client.setName("Renan");
        client.setCpf("35744431112");
        client.setTel("11912341234");
        client.setStreet("Rua Jorge Augusto");
        client.setState("SP");
        client.setCity("São Paulo");
        client.setNumber(449);

        List<Client> clientList = new ArrayList<>();

        clientList.add(client);


        return clientList;
    }

    @Override
    public Client update(String key, Client model) {
        return model;
    }
}
