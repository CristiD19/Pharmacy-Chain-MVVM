package view;

import model.Angajat;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import viewmodel.VMAdministrator;
import viewmodel.VMAngajat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AngajatView extends JFrame  {

    private JPanel contentPane;
    @Bind(value = "model", target = "table.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table;

    @Bind(value = "text", target = "numeMedicamentTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField numeMedicamentTextField ;
    @Bind(value = "text", target = "pretTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField pretTextField ;
    private JButton btnAdaugaMedicament;
    private JButton btnAcutalizareMedicament;
    private JButton btnListaMedicamente;
    private JButton btnStergeMedicament;
    private JButton btnFiltrareMedicamente;
    private JLabel producatorLabel_1;
    @Bind(value = "text", target = "producatorTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField producatorTextField;
    private JLabel clientNameLabel;
    private JCheckBox disponibilCheckBox;
    private JCheckBox valabilCheckBox;
    @Bind(value = "model", target = "table_1.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table_1;
    @Bind(value = "text", target = "stocTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField stocTextField;
    private JButton btnCautareMedicament;
    @Bind(value = "text", target = "selectedIdAngajat.value", type = BindingType.BI_DIRECTIONAL)
    private JLabel selectedIdAngajat;
    @Bind(value = "text", target = "selectedTable1.value", type = BindingType.BI_DIRECTIONAL)
    private JLabel selectedTable1;
    @Bind(value = "text", target = "selectedTable2.value", type = BindingType.BI_DIRECTIONAL)
    private JLabel selectedTable2;
    private JButton btnFisiere;
    private JButton btnCautareDupaNume;




    public AngajatView(Angajat angajat) {

        selectedIdAngajat = new JLabel();
        selectedTable1 = new JLabel();
        selectedTable2 = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1250, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tabel Angajat");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(324, 10, 239, 54);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate"
                }
        ));
        table.setBounds(24, 74, 345, 291);
        contentPane.add(table);

        btnAdaugaMedicament = new JButton("Adauga Medicament");
        btnAdaugaMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnAdaugaMedicament.setBounds(10, 397, 170, 35);
        contentPane.add(btnAdaugaMedicament);

        btnAcutalizareMedicament = new JButton("Acutalizare Medicament");
        btnAcutalizareMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnAcutalizareMedicament.setBounds(190, 397, 179, 35);
        contentPane.add(btnAcutalizareMedicament);

        btnListaMedicamente = new JButton("Lista Medicamente");
        btnListaMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnListaMedicamente.setBounds(550, 397, 147, 35);
        contentPane.add(btnListaMedicamente);

        btnStergeMedicament = new JButton("Sterge Medicament");
        btnStergeMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnStergeMedicament.setBounds(379, 397, 161, 35);
        contentPane.add(btnStergeMedicament);

        clientNameLabel = new JLabel("Nume:");
        clientNameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientNameLabel.setBounds(853, 69, 83, 28);
        contentPane.add(clientNameLabel);

        JLabel clientAddressLabel = new JLabel("Disponibil:");
        clientAddressLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAddressLabel.setBounds(853, 118, 83, 28);
        contentPane.add(clientAddressLabel);

        JLabel clientEmailLabel = new JLabel("Valabil:");
        clientEmailLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientEmailLabel.setBounds(853, 172, 83, 28);
        contentPane.add(clientEmailLabel);

        JLabel clientAgeLabel = new JLabel("Pret:");
        clientAgeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAgeLabel.setBounds(853, 224, 83, 28);
        contentPane.add(clientAgeLabel);

        numeMedicamentTextField = new JTextField();
        numeMedicamentTextField .setBounds(977, 66, 125, 31);
        contentPane.add(numeMedicamentTextField );
        numeMedicamentTextField .setColumns(10);

        pretTextField = new JTextField();
        pretTextField.setBounds(977, 221, 125, 31);
        contentPane.add(pretTextField);
        pretTextField.setColumns(10);

        btnFiltrareMedicamente = new JButton("Filtrare Medicament");
        btnFiltrareMedicamente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnFiltrareMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnFiltrareMedicamente.setBounds(725, 397, 161, 35);
        contentPane.add(btnFiltrareMedicamente);

        disponibilCheckBox = new JCheckBox("");
        disponibilCheckBox.setBounds(974, 118, 93, 35);
        contentPane.add(disponibilCheckBox);

        valabilCheckBox = new JCheckBox("");
        valabilCheckBox.setBounds(974, 172, 93, 21);
        contentPane.add(valabilCheckBox);

        producatorLabel_1 = new JLabel("Producator:");
        producatorLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
        producatorLabel_1.setBounds(853, 280, 83, 28);
        contentPane.add(producatorLabel_1);

        producatorTextField = new JTextField();
        producatorTextField.setColumns(10);
        producatorTextField.setBounds(977, 277, 125, 31);
        contentPane.add(producatorTextField);

        JLabel stocLabel = new JLabel("Stoc:");
        stocLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        stocLabel.setBounds(853, 337, 83, 28);
        contentPane.add(stocLabel);

        stocTextField = new JTextField();
        stocTextField.setColumns(10);
        stocTextField.setBounds(977, 334, 125, 31);
        contentPane.add(stocTextField);

        btnCautareDupaNume = new JButton("CautareNume");
        btnCautareDupaNume.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCautareDupaNume.setBounds(1090, 397, 136, 35);
        contentPane.add(btnCautareDupaNume);

        btnFisiere = new JButton("Fisiere");
        btnFisiere.setFont(new Font("Calibri", Font.BOLD, 14));
        btnFisiere.setBounds(1133, 297, 93, 68);
        contentPane.add(btnFisiere);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"
                }
        ));
        table_1.setBounds(379, 74, 420, 291);
        contentPane.add(table_1);

        btnCautareMedicament = new JButton("Cautare Medicament");
        btnCautareMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCautareMedicament.setBounds(906, 397, 161, 35);
        contentPane.add(btnCautareMedicament);

        VMAngajat viewModelAngajat = new VMAngajat();
        try{
            Binder.bind(this, viewModelAngajat);
        } catch(Exception ex) {
            System.out.println("\nError with binding at Angajat\n");
            ex.printStackTrace();
        }


        this.btnFiltrareMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaFiltrareMedicamenteInFarmacieAngajat.execute();

            }
        });

        this.btnAcutalizareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value1 = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
                selectedTable2.setText(value1);
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaActualizareMedicamentInFarmacie.execute();
            }
        });

        this.btnAdaugaMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) table.getValueAt(table.getSelectedRow(), 0);
                selectedTable1.setText(value);
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaCreareMedicamentInFarmacie.execute();
            }
        });

        this.btnCautareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaCitireMedicamentInFarmacie.execute();
            }
        });

        viewModelAngajat.comandaListaMedicamente.execute();

        this.btnListaMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                System.out.println(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaListaMedicamenteInFarmacie.execute();
            }
        });

        this.btnStergeMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value1 = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
                selectedTable2.setText(value1);
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaStergeMedicamentInFarmacie.execute();

            }
        });

        this.btnCautareDupaNumeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaCitireMedicamentInFarmacie.execute();
            }
        });


        this.btnFisiereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIdAngajat.setText(Integer.toString(angajat.getId()));
                viewModelAngajat.comandaGenerareFisiereAngajat.execute();
            }
        });



    }


    public void btnCautareDupaNumeListener(ActionListener actionListener){
        this.btnCautareDupaNume.addActionListener(actionListener);
    }

    public void btnFisiereListener(ActionListener actionListener){
        this.btnFisiere.addActionListener(actionListener);
    }

    public void btnAdaugaMedicamentListener(ActionListener actionListener) {
        this.btnAdaugaMedicament.addActionListener(actionListener);
    }

    public void btnFiltrareMedicamenteListener(ActionListener actionListener){
        this.btnFiltrareMedicamente.addActionListener(actionListener);
    }

    public void btnCautareMedicamentListener(ActionListener actionListener) {
        this.btnCautareMedicament.addActionListener(actionListener);
    }

    public void btnAcutalizareMedicamentListener(ActionListener actionListener){
        this.btnAcutalizareMedicament.addActionListener(actionListener);
    }

    public void btnListaMedicamenteListener(ActionListener actionListener){
        this.btnListaMedicamente.addActionListener(actionListener);
    }

    public void btnStergeMedicamentListener(ActionListener actionListener){
        this.btnStergeMedicament.addActionListener(actionListener);
    }





}

