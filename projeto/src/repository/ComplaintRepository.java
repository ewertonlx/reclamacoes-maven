package src.repository;
import src.connection.Conexao;
import src.entities.Complaint;
import src.interfaces.IComplaint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintRepository implements IComplaint {
    @Override
    public void addComplaint(Complaint c) {
        String sql = "INSERT INTO reclamacoesdb.reclamacao (idCliente, idEmpresa, titulo, descricao, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 1);
            ps.setString(3, c.getTitle());
            ps.setString(4, c.getDescription());
            ps.setString(5, c.getStatus());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeComplaint(int id) {
        String sql = "DELETE FROM reclamacoesdb.reclamacao WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateComplaint(Complaint client, int id) {
        String sql = "UPDATE reclamacoesdb.reclamacao SET titulo = ?, descricao = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, client.getTitle());
            ps.setString(2, client.getDescription());
            ps.setString(3, client.getStatus());
            ps.setInt(4, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getComplaint(int id) {
        // Retorna os dados do cliente
        String sql = "SELECT * FROM reclamacoesdb.reclamacao WHERE idCliente = ?";
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