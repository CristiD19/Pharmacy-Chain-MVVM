package viewmodel;

import model.*;
import view.AdministratorView;
import view.AngajatView;
import view.ManagerView;

public class ComandaLogin implements ICommand {

    private VMLogin vmLogin;

    public ComandaLogin() {
    }

    public ComandaLogin(VMLogin vmLogin) {
        this.vmLogin = vmLogin;
    }

    public VMLogin getVmLogin() {
        return vmLogin;
    }

    public void setVmLogin(VMLogin vmLogin) {
        this.vmLogin = vmLogin;
    }

    @Override
    public void execute() {

        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();


        Utilizator utilizator = utilizatorPersistent.cautareUtilizatorDupaCont(vmLogin.getUserTextField(), vmLogin.getPasswordTextField());

        if (utilizator instanceof Angajat) {
            AngajatView angajatView = new AngajatView((Angajat) utilizator);
            angajatView.setVisible(true);
        }
        if (utilizator instanceof Administrator) {
            AdministratorView administratorView = new AdministratorView((Administrator) utilizator);
            administratorView.setVisible(true);
        }
        if (utilizator instanceof Manager) {
            ManagerView managerView = new ManagerView((Manager) utilizator);
            managerView.setVisible(true);
        }
    }

}
