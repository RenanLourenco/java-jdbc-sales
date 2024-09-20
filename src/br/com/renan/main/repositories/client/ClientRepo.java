package br.com.renan.main.repositories.client;

import br.com.renan.main.domain.Client;
import br.com.renan.main.repositories.generic.GenericRepo;
import java.sql.Connection;

public class ClientRepo extends GenericRepo<Client>{
    public ClientRepo(Connection c) {
        super(c, "clients", Client.class);
    }
}
