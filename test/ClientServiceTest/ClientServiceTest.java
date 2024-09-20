package ClientServiceTest;

import ClientServiceTest.mock.ClientRepoMock;
import br.com.renan.main.domain.Client;

import br.com.renan.main.repositories.generic.IGenericRepo;
import br.com.renan.main.services.client.ClientService;
import br.com.renan.main.services.client.IClientService;
import br.com.renan.main.services.client.dto.CreateClientDTO;
import br.com.renan.main.services.client.dto.DeleteClientDTO;
import br.com.renan.main.services.client.dto.GetClientDTO;
import br.com.renan.main.services.client.dto.UpdateClientDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClientServiceTest {

    private IClientService clientService;
    private Client client;

    public ClientServiceTest(){
        IGenericRepo<Client> clientRepoMock = new ClientRepoMock();
        clientService = new ClientService(clientRepoMock);
    }

    @Before
    public void init(){
        client = new Client();
        client.setUuid("8c5a5e25-9c7a-406e-b107-e36386c173da");
        client.setName("Renan");
        client.setCpf("35744431112");
        client.setTel("11912341234");
        client.setStreet("Rua Jorge Augusto");
        client.setState("SP");
        client.setCity("São Paulo");
        client.setNumber(449);
    }

    @Test
    public void getClientTest() {
        Client client = clientService.getClient(new GetClientDTO("8c5a5e25-9c7a-406e-b107-e36386c173da"));

        Assert.assertNotNull(client);
    }

    @Test
    public void createClientTest() {
        Client createdClient = clientService.createClient(new CreateClientDTO(
                client.getCpf(),
                client.getName(),
                client.getTel(),
                client.getStreet(),
                client.getCity(),
                client.getState(),
                client.getNumber()
        ));

        Assert.assertNotNull(createdClient);
    }

    @Test
    public void deleteClientTest() {
        Client createdClient = clientService.createClient(new CreateClientDTO(
                client.getCpf(),
                client.getName(),
                client.getTel(),
                client.getStreet(),
                client.getCity(),
                client.getState(),
                client.getNumber()
        ));

        Boolean delete = clientService.deleteClient(new DeleteClientDTO(createdClient.getUuid()));

        Assert.assertTrue(delete);
    }

    @Test
    public void listClientsTest() {
        List<Client> clients = clientService.listClients();

        Assert.assertFalse(clients.isEmpty());
    }

    @Test
    public void updateClientTest(){
        Client createdClient = clientService.createClient(new CreateClientDTO(
                client.getCpf(),
                client.getName(),
                client.getTel(),
                client.getStreet(),
                client.getCity(),
                client.getState(),
                client.getNumber()
        ));

        createdClient.setName("update test");

        Client updated = clientService.updateClient(new UpdateClientDTO(
                createdClient.getUuid(),
                createdClient.getCpf(),
                createdClient.getName(),
                createdClient.getTel(),
                createdClient.getStreet(),
                createdClient.getCity(),
                createdClient.getState(),
                createdClient.getNumber()
        ));

        Assert.assertEquals("update test", updated.getName());
    }
}
