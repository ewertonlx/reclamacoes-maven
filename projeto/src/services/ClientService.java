package src.services;
import java.util.ArrayList;

import src.entities.Client;
public class ClientService {
    public void addClientService(Client client, ArrayList<Client> clients) {
        if(client.getName().equals("") || client.getEmail().equals("") || client.getCpf().equals("") || client.getPhone().equals("")) {
            System.out.println("Preencha todos os campos!");
        } else {
            clients.add(client);
        }
    }

    public void removeClientService(Client client, ArrayList<Client> clients) {
        for(Client c : clients) {
            if(c.getCpf().equals(client.getCpf())) {
                clients.remove(c);
                break;
            }
        }
    }

    public void updateClientService(Client client, ArrayList<Client> clients) {
        for (Client c : clients) {
            if (c.getCpf().equals(client.getCpf())) {
                c.setName(client.getName());
                c.setEmail(client.getEmail());
                c.setCpf(client.getCpf());
                c.setPhone(client.getPhone());
            }
        }
    }

    public Client getClientService(String cpf, ArrayList<Client> clients) {
        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}
