package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            // remove this
            try {
                try (Statement st = conn.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Clients");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            ClientDAOImpl2 dao = new ClientDAOImpl2(conn, "Clients");
            dao.createTable(Client.class);

            Client c = new Client("test", 1);
            dao.add(c);

            //получение ID клиента в БД
            int id = dao.getID(c.getName());
            System.out.println(id);

            //метод рандомного создания списка для тестирования ДЗ
            List<Client> testList = Client.randomBDClients();
            for (Client cl : testList) {
                dao.add(cl);
            }

            //List<Client> list = dao.getAll(Client.class, "name");
            List<Client> listOne = dao.getAll(Client.class, "name");
            for (Client cli : listOne) {
                System.out.println(cli);
            }

            System.out.println();
            System.out.println();
            System.out.println();

            //List<Client> list = dao.getAll(Client.class, "name", "age");
            List<Client> listTwo = dao.getAll(Client.class, "name", "age");
            for (Client cli : listTwo) {
                System.out.println(dao.getID(cli.getName()));
                System.out.println(cli);
            }

            System.out.println();
            System.out.println();
            System.out.println();

            List<Client> list = dao.getAll(Client.class);
            for (Client cli : list) {
                System.out.println(cli);
            }
            list.get(0).setAge(55);
            dao.update(list.get(0));
            dao.delete(list.get(0));
        }
    }
}
