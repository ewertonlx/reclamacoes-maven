package src.interfaces;
import src.entities.Enterprise;

public interface IEnterprise {
    // Métodos da interface IEnterprise que devem ser implementados pela classe EnterpriseRepository
    public void addEnterprise(Enterprise enterprise);
    public void removeEnterprise(int id);
    public void updateEnterprise(Enterprise enterprise, int id);
    public String getEnterprise(String cnpj);
}