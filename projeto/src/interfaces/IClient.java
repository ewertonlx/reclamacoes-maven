package src.interfaces;
import src.entities.Client;

public interface IClient {
    // Métodos da interface IClient que devem ser implementados pela classe ClientRepository
    public void addClient(Client client);
    public void removeClient(int idCliente);
    public void updateClient(Client client, int id);
    public String getClient(int id);
}
