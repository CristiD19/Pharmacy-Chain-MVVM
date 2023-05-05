package viewmodel;

import model.*;
import view.AdministratorView;
import view.AngajatView;
import view.ManagerView;

import javax.swing.*;

public class CreareUtilizator implements ICommand {

    private VMAdministrator vmAdministrator;

    public CreareUtilizator() {
    }

    public CreareUtilizator(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    public VMAdministrator getVmAdmin() {
        return vmAdministrator;
    }

    public void setVmAdmin(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    @Override
    public void execute() {
        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
        Utilizator utilizator ;
        DefaultComboBoxModel<String> comboBox = vmAdministrator.getRolComboBox();
        String rol = comboBox.getSelectedItem().toString();
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        if (rol.equals("ADMINISTRATOR")) {
            utilizator = new Administrator(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField());
            utilizatorPersistent.creareUtilizator(utilizator);
        }
        if (rol.equals("ANGAJAT")) {
            Farmacie farmacie = farmaciePersistent.cautareFarmacieDupaId(vmAdministrator.getFarmacieIdField());
            utilizator = new Angajat(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField(), farmacie);
            utilizatorPersistent.creareUtilizator(utilizator);
        }
        if (rol.equals("MANAGER")) {
            utilizator = new Manager(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField());
            utilizatorPersistent.creareUtilizator(utilizator);
        }

        System.out.println(rol.toString());
    }


}
