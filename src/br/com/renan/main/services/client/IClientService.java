package br.com.renan.main.services.client;

import br.com.renan.main.domain.Client;
import br.com.renan.main.services.client.dto.CreateClientDTO;
import br.com.renan.main.services.client.dto.DeleteClientDTO;
import br.com.renan.main.services.client.dto.GetClientDTO;
import br.com.renan.main.services.client.dto.UpdateClientDTO;

import java.util.List;

public interface IClientService {
    Client createClient(CreateClientDTO data);
    Boolean deleteClient(DeleteClientDTO data);
    Client getClient(GetClientDTO data);
    List<Client> listClients();
    Client updateClient(UpdateClientDTO data);
}
