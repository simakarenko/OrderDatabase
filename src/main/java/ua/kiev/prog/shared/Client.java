package ua.kiev.prog.shared;

import java.util.ArrayList;
import java.util.List;

public class Client {
    @Id
    private int id;

    private String name;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Client> randomBDClients() {
        List<Client> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Client c = new Client("test" + i, "38092637274" + i, "aaaa@" + i);
            list.add(c);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
