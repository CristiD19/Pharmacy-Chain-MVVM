package viewmodel;

import model.*;

public class CreareMedicamentInFarmacie implements ICommand{
    private VMAngajat vmAngajat;

    public CreareMedicamentInFarmacie() {
    }

    public CreareMedicamentInFarmacie(VMAngajat vmAngajat) {
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

        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        MedicamentPersistent medicamentPersistent = new MedicamentPersistent();
        Angajat angajat = (Angajat) utilizatorPersistent.cautareUtilizatorDupaId(vmAngajat.getSelectedIdAngajat());
        Farmacie farmacie = angajat.getFarmacie();
        Medicament medicament = medicamentPersistent.cautareMedicamentDupaId(vmAngajat.getSelectedTable1());
        MedicamentInFarmacie medicamentInFarmacie = farmacie.adaugareMedicament(medicament, Integer.parseInt(vmAngajat.getStocTextField()));
        farmaciePersistent.creareMedicamentInFarmacie(medicamentInFarmacie);
    }
}
