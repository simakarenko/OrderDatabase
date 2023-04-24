package ua.kiev.prog.shared;

import java.util.ArrayList;
import java.util.List;

public class Client {
    @Id
    private int id;

    private String name;
    private int age;

    public Client() {
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Client> randomBDClients() {
        List<Client> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Client c = new Client("test" + i, 20 + i);
            list.add(c);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
