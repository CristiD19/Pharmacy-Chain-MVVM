package viewmodel;

import model.*;

import javax.swing.*;

public class ActualizareUtilizator implements ICommand{
    private VMAdministrator vmAdministrator;

    public ActualizareUtilizator() {
    }

    public ActualizareUtilizator(VMAdministrator vmAdministrator) {
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
            utilizatorPersistent.actualizareUtilizator(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField(), vmAdministrator.getIdSelectedRow());
        }
        if (rol.equals("ANGAJAT")) {
            Farmacie farmacie = farmaciePersistent.cautareFarmacieDupaId(vmAdministrator.getFarmacieIdField());
            utilizator = new Angajat(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField(), farmacie);
            utilizatorPersistent.actualizareUtilizator(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField(), vmAdministrator.getIdSelectedRow());
        }
        if (rol.equals("MANAGER")) {
            utilizator = new Manager(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField());
            utilizatorPersistent.actualizareUtilizator(vmAdministrator.getNameTextField(), vmAdministrator.getUsernameTextField(), vmAdministrator.getPasswordTextField(), vmAdministrator.getIdSelectedRow());
        }
    }
}
