package viewmodel;

import model.FarmaciePersistent;

public class ActualizareMedicamentInFarmacie implements ICommand{
    private VMAngajat vmAngajat;

    public ActualizareMedicamentInFarmacie() {
    }

    public ActualizareMedicamentInFarmacie(VMAngajat vmAngajat) {
        this.vmAngajat = vmAngajat;
    }

    public VMAngajat getVmAngajat() {
        return vmAngajat;
    }

    public void setVmAngajat(VMAngajat vmAngajat) {
        this.vmAngajat = vmAngajat;
    }

    @Override
    public void execute() {

        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        Boolean disponibil = false;
        Boolean valabil = false;
        if (Integer.parseInt(vmAngajat.getStocTextField()) > 0) {
            disponibil = true;
            valabil = true;
        }
        String nume = vmAngajat.getNumeMedicamentTextField();
        int pret = Integer.parseInt(vmAngajat.getPretTextField());
        String producator = vmAngajat.getProducatorTextField();
        int id = vmAngajat.getSelectedTable2();
        int stoc = Integer.parseInt(vmAngajat.getStocTextField());
        farmaciePersistent.actualizareMedicamentInFarmacie(disponibil, nume, pret, producator, valabil, stoc, id);


    }
}
