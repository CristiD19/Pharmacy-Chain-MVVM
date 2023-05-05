package viewmodel;


import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VMAngajat {


    private Property<DefaultTableModel> table;
    private Property<DefaultTableModel> table_1;
    private Property<String> numeMedicamentTextField;
    private Property<String> pretTextField;
    private Property<String> producatorTextField;
    private Property<String> stocTextField;
    private Property<String> selectedIdAngajat;
    private Property<String> selectedTable1;
    private Property<String> selectedTable2;

    public ICommand comandaActualizareMedicamentInFarmacie;
    public ICommand comandaCitireMedicamentInFarmacie;
    public ICommand comandaCreareMedicamentInFarmacie;
    public ICommand comandaFiltrareMedicamenteInFarmacieAngajat;
    public ICommand comandaListaMedicamenteInFarmacie;
    public ICommand comandaStergeMedicamentInFarmacie;
    public ICommand comandaListaMedicamente;
    public ICommand comandaGenerareFisiereAngajat;



    public VMAngajat(){
        table =  PropertyFactory.createProperty("table", this, new DefaultTableModel());
        table_1 = PropertyFactory.createProperty("table_1", this, new DefaultTableModel());
        numeMedicamentTextField = PropertyFactory.createProperty("nume", this, String.class);
        pretTextField = PropertyFactory.createProperty("pret", this, String.class);
        producatorTextField = PropertyFactory.createProperty("producator", this, String.class);
        stocTextField = PropertyFactory.createProperty("stoc", this, String.class);
        selectedIdAngajat = PropertyFactory.createProperty("selectedIdAngajat", this, String.class);
        selectedTable1 = PropertyFactory.createProperty("selectedTable1", this, String.class);
        selectedTable2 = PropertyFactory.createProperty("selectedTable2", this, String.class);

        this.comandaActualizareMedicamentInFarmacie = new ActualizareMedicamentInFarmacie(this);
        this.comandaCitireMedicamentInFarmacie = new CitireMedicamentInFarmacie(this);
        this.comandaCreareMedicamentInFarmacie = new CreareMedicamentInFarmacie(this);
        this.comandaFiltrareMedicamenteInFarmacieAngajat = new FiltrareMedicamenteInFarmacieAngajat(this);
        this.comandaListaMedicamenteInFarmacie = new ListaMedicamenteInFarmacie(this);
        this.comandaStergeMedicamentInFarmacie = new StergeMedicamentInFarmacie(this);
        this.comandaListaMedicamente = new ListaMedicamente(this);
        this.comandaGenerareFisiereAngajat = new GenerareFisiereAngajat(this);
    }

    public Property<DefaultTableModel> getTable() {
        return table;
    }

    public Property<DefaultTableModel> getTable_1() {
        return table_1;
    }

    public String getNumeMedicamentTextField() {
        return numeMedicamentTextField.get();
    }

    public String getPretTextField() {
        return pretTextField.get();
    }

    public String getProducatorTextField() {
        return producatorTextField.get();
    }


    public String getStocTextField() {
        return stocTextField.get();
    }

    public void setTable(DefaultTableModel defaultTableModel) {
        table.set(defaultTableModel);
    }

    public void setTable_1(DefaultTableModel defaultTableModel) {
        table_1.set(defaultTableModel);
    }

    public int getSelectedIdAngajat() {
        return Integer.parseInt(selectedIdAngajat.get());
    }

    public int getSelectedTable1() {
        return Integer.parseInt(selectedTable1.get());
    }

    public int getSelectedTable2() {
        return Integer.parseInt(selectedTable2.get());
    }
}
