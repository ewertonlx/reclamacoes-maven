package src.services;

import src.entities.Complaint;
import java.util.ArrayList;

public class ComplaintService {
    public void addComplaintService(Complaint complaint, ArrayList<Complaint> complaints) {
        if(complaint.getTitle().equals("") || complaint.getDescription().equals("")) {
            System.out.println("Preencha todos os campos!");
        } else {
            complaints.add(complaint);
        }
    }

    public void removeComplaintService(Complaint complaint, ArrayList<Complaint> complaints) {
        for(Complaint c : complaints) {
            if(c.getId() == complaint.getId()) {
                complaints.remove(c);
                break;
            }
        }
    }

    public void updateComplaintService(Complaint complaint, ArrayList<Complaint> complaints) {
        for (Complaint c : complaints) {
            if (c.getId() == complaint.getId()) {
                c.setTitle(complaint.getTitle());
                c.setDescription(complaint.getDescription());
                c.setStatus(complaint.getStatus());
            }
        }
    }

    public Complaint getComplaintService(int id, ArrayList<Complaint> complaints) {
        for (Complaint c : complaints) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void changeStatusService(Complaint complaint, String status) {
        if(status.equals("Aberto") || status.equals("Fechado")) {
            complaint.setStatus(status);
        } else {
            System.out.println("Status inválido!");
        }
    }

}
