package src.repository;
import src.connection.Conexao;
import src.entities.Enterprise;
import src.interfaces.IEnterprise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnterpriseRepository implements IEnterprise {
    @Override
    public void addEnterprise(Enterprise c) {
        String sql = "INSERT INTO reclamacoesdb.empresa (cnpj, nomeEmpresa) VALUES (?, ?)";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, c.getCnpj());
            ps.setString(2, c.getCorporateName());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEnterprise(int id) {
        String sql = "DELETE FROM reclamacoesdb.empresa WHERE idEmpresa = ?";
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
    public void updateEnterprise(Enterprise et, int id) {
        String sql = "UPDATE reclamacoesdb.empresa SET cnpj = ?, nomeEmpresa = ? WHERE idEmpresa = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, et.getCnpj());
            ps.setString(2, et.getCorporateName());
            ps.setInt(3, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getEnterprise(String cnpj) {
        String sql = "SELECT * FROM reclamacoesdb.empresa WHERE idEmpresa = ?";
        String result = "";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = "ID: " + rs.getInt("idEmpresa") + "\n" +
                        "Nome: " + rs.getString("nomeEmpresa") + "\n" +
                        "CNPJ: " + rs.getString("cnpj") + "\n";
            } else {
                result = "Empresa não encontrada!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}