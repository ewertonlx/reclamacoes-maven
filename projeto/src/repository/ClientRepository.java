package src.repository;
import src.connection.Conexao;
import src.entities.Client;
import src.interfaces.IClient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository implements IClient {
    // Implementação dos métodos da interface IClient
    @Override
    public void addClient(Client client) {
        String sql = "INSERT INTO reclamacoesdb.cliente (nome, email, cpf, telefone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getCpf());
            ps.setString(4, client.getPhone());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeClient(int idCliente) {
        String sql = "DELETE FROM reclamacoesdb.cliente WHERE idCliente = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client client, int id) {
        // Atualiza os dados do cliente
        String sql = "UPDATE reclamacoesdb.cliente SET nome = ?, email = ?, cpf = ?, telefone = ? WHERE idCliente = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getCpf());
            ps.setString(4, client.getPhone());
            ps.setInt(5, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getClient(int id) {
        // Retorna os dados do cliente
        String sql = "SELECT * FROM reclamacoesdb.cliente WHERE idCliente = ?";
        String result = "";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = "ID: " + rs.getInt("idcliente") + "\n" +
                        "Nome: " + rs.getString("nome") + "\n" +
                        "Email: " + rs.getString("email") + "\n" +
                        "CPF: " + rs.getString("cpf") + "\n" +
                        "Telefone: " + rs.getString("telefone");
            } else {
                result = "Cliente não encontrado!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}