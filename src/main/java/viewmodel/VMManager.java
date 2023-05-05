package viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VMManager {

    private Property<String> numeMedicamentTextField;
    private Property<DefaultTableModel> table;
    private Property<DefaultTableModel> table_1;
    private Property<String> idTabelFarmacie;

    public ICommand comandaAfisareFarmaci;
    public ICommand comandaAfisareMedicamenteInFarmacie;
    public ICommand comandaCautareMedicamentInFarmacie;
    public ICommand comandaFiltrareMedicamenteInFarmacieManager;
    public ICommand comandaGenerareFisiereManager;

    public VMManager() {

        numeMedicamentTextField = PropertyFactory.createProperty("nume", this, String.class);
        idTabelFarmacie = PropertyFactory.createProperty("idTabelFarmacie", this, String.class);
        table = PropertyFactory.createProperty("table", this, new DefaultTableModel());
        table_1 = PropertyFactory.createProperty("table_1", this, new DefaultTableModel());

        comandaAfisareFarmaci = new AfisareFarmaci(this);
        comandaAfisareMedicamenteInFarmacie = new AfisareMedicamenteInFarmacie(this);
        comandaCautareMedicamentInFarmacie = new CautareMedicamentDupaNume(this);
        comandaFiltrareMedicamenteInFarmacieManager = new FiltrareMedicamenteInFarmacieManager(this);
        comandaGenerareFisiereManager = new GenerareFisiereManager(this);
    }

    public String getNumeMedicamentTextField() {
        return numeMedicamentTextField.get();
    }

    public int getIdTabelFarmacie(){
        return Integer.parseInt(idTabelFarmacie.get());
    }

    public Property<DefaultTableModel> getTable() {
        return table;
    }

    public Property<DefaultTableModel> getTable_1() {
        return table_1;
    }

    public void setTable(DefaultTableModel defaultTableModel) {
        table.set(defaultTableModel);
    }

    public void setTable_1(DefaultTableModel defaultTableModel) {
        table_1.set(defaultTableModel);
    }
}
