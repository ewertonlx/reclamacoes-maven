package src.services;

import src.entities.Enterprise;
import java.util.ArrayList;

public class EnterpriseService {
    
    public void addEnterpriseService(Enterprise enterprise, ArrayList<Enterprise> enterprises) {
        if(enterprise.getName().equals("") || enterprise.getCnpj().equals("") || enterprise.getPhone().equals("")) {
            System.out.println("Preencha todos os campos!");
        } else {
            enterprises.add(enterprise);
        }
    }

    public void removeEnterpriseService(Enterprise enterprise, ArrayList<Enterprise> enterprises) {
        for(Enterprise e : enterprises) {
            if(e.getCnpj().equals(enterprise.getCnpj())) {
                enterprises.remove(e);
                break;
            }
        }
    }

    public void updateEnterpriseService(Enterprise enterprise, ArrayList<Enterprise> enterprises) {
        for (Enterprise e : enterprises) {
            if (e.getCnpj().equals(enterprise.getCnpj())) {
                e.setName(enterprise.getName());
                e.setCnpj(enterprise.getCnpj());
                e.setPhone(enterprise.getPhone());
            }
        }
    }

    public Enterprise getEnterpriseService(String cnpj, ArrayList<Enterprise> enterprises) {
        for (Enterprise e : enterprises) {
            if (e.getCnpj().equals(cnpj)) {
                return e;
            }
        }
        return null;
    }
}
