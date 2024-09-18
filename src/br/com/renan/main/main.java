import br.com.renan.main.domain.Client;
import br.com.renan.main.infra.Database;
import br.com.renan.main.repositories.GenericRepo;
import br.com.renan.main.repositories.IGenericRepo;

import java.sql.Connection;
import java.sql.SQLException;

void main() {
    Database dbConnection = new Database();
    Connection connection = dbConnection.getConnection();
    try {
        if (connection != null && !connection.isClosed()) {
            IGenericRepo<Client> generic = new GenericRepo<>(connection);
            Client client = new Client();
            client.setName("Renan");
            client.setCpf("123");
            client.setName("123");
            client.setStreet("rua jorge augusto");
            client.setCity("são paulo");
            client.setState("SP");
            client.setNumber(1);
            generic.create(client);
            connection.close();
            System.out.println("Database connection closed.");

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}