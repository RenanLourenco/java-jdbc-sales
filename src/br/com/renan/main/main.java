import br.com.renan.main.domain.Client;
import br.com.renan.main.infra.Database;
import br.com.renan.main.repositories.generic.GenericRepo;
import br.com.renan.main.repositories.generic.IGenericRepo;

import java.sql.Connection;
import java.sql.SQLException;

void main() {
    Database dbConnection = new Database();
    Connection connection = dbConnection.getConnection();
    try {
        if (connection != null && !connection.isClosed()) {
            IGenericRepo<Client> generic = new GenericRepo<>(connection, "clients", Client.class);
//            Client client = new Client();
//            generic.create(client);
            var list = generic.get("8c5a5e25-9c7a-406e-b107-e36386c173da");
            System.out.println(list);
            Client client = new Client();
            client.setName("Update");
            var update = generic.update("8c5a5e25-9c7a-406e-b107-e36386c173da", client);
            System.out.println(update);
            connection.close();
            System.out.println("Database connection closed.");

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}