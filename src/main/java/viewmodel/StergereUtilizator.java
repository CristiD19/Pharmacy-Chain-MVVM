package viewmodel;

import model.Utilizator;
import model.UtilizatorPersistent;

public class StergereUtilizator implements ICommand{

    private VMAdministrator vmAdministrator;

    public StergereUtilizator() {
    }

    public StergereUtilizator(VMAdministrator vmAdministrator) {
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
        utilizatorPersistent.stergeUtilizator(vmAdministrator.getIdSelectedRow());
    }
}
