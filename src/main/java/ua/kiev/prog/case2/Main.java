package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;
import ua.kiev.prog.shared.Orders;
import ua.kiev.prog.shared.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws SQLException {


        List<Integer> idClients = new ArrayList<>();
        List<Integer> idProducts = new ArrayList<>();

        try (Connection connOne = ConnectionFactory.getConnection()) {
            // remove this

            //тестовый клиент
            Client test = new Client("Sveta", "11111111111", "111@222");
            //таблица клиентов
            try {
                try (Statement st = connOne.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Clients");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            ClientDAOImpl2 daoCl = new ClientDAOImpl2(connOne, "Clients");
            daoCl.createTable(Client.class);

            //метод рандомного создания списка для тестирования ДЗ
            List<Client> testListCl = Client.randomBDClients();
            for (Client cl : testListCl) {
                daoCl.add(cl);
            }
            daoCl.add(test);

            List<Client> resultCl = daoCl.getAll(Client.class);
            for (Client c : resultCl) {
                System.out.println(c);
                int n = daoCl.getID(c.getName());
                idClients.add(n);
            }

            //таблица товаров
            try {
                try (Statement st = connOne.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Products");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            ProductDAOImpl2 daoPr = new ProductDAOImpl2(connOne, "Products");
            daoPr.createTable(Product.class);

            //метод рандомного создания списка для тестирования ДЗ
            List<Product> testListPr = Product.randomBDProducts();
            for (Product pr : testListPr) {
                daoPr.add(pr);
            }
            List<Product> resultPr = daoPr.getAll(Product.class);
            for (Product p : resultPr) {
                System.out.println(p);
                int n = daoPr.getID(p.getName());
                idProducts.add(n);
            }
            //таблицо заказов
            try {
                try (Statement st = connOne.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Orders");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            OrdersDAOImpl2 daoOr = new OrdersDAOImpl2(connOne, "Orders");
            daoOr.createTable(Orders.class);
            int mark = 0;
            List<Integer> listTest = new ArrayList<>();
            for (Product p : resultPr) {
                mark += 1;
                listTest.add(daoPr.getID(p.getName()));
                if (mark == 5) {
                    break;
                }
            }
            daoOr.add(new Orders(daoCl.getID(test.getName()), listTest));
            List<Orders> res = daoOr.getAll(Orders.class);
            for (Orders o : res) {
                System.out.println(o);
            }
        }

    }
}
