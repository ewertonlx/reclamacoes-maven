package src.entities;

@Entity
@Table(name = "empresas")
public class Enterprise extends Client {
    // Atributos
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false)
    private String corporateName;

    // Construtor padrão
    public Enterprise() {
    }

    // Construtor com parâmetros
    public Enterprise(String name, String email, String cpf, String phone, String cnpj, String corporateName) {
        super(name, email, cpf, phone);
        this.cnpj = cnpj;
        this.corporateName = corporateName;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}