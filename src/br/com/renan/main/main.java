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
            IGenericRepo<Client> generic = new GenericRepo<>(connection, "clients", Client.class);
//            Client client = new Client();
//            generic.create(client);
            var list = generic.list();
            System.out.println(list);
            connection.close();
            System.out.println("Database connection closed.");

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}