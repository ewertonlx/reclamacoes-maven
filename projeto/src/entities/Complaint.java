package src.entities;
import java.util.Random;
@Entity
@Table(name = "reclamacoes")
public class Complaint {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String status;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Enterprise enterprise;
    
    // Construtor padrão
    public Complaint() {
    }

    // Construtor com parâmetros
    public Complaint(String title, String description, String status, Client client, Enterprise enterprise) {
        this.title = title;
        this.description = description;
        this.id = generateRandomId();
        this.status = status;
        this.client = client;
        this.enterprise = enterprise;
    }

    // Método para gerar um id aleatório
    private static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}