package src.interfaces;
import src.entities.Complaint;

public interface IComplaint {
    // Métodos da interface IComplaint que devem ser implementados pela classe ComplaintRepository
    public void addComplaint(Complaint complaint);
    public void removeComplaint(int id);
    public void updateComplaint(Complaint complaint, int id);
    public String getComplaint(int id);
}