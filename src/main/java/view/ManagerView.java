package view;

import model.Manager;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import viewmodel.VMAdministrator;
import viewmodel.VMManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ManagerView extends JFrame{

    private JPanel contentPane;
    @Bind(value = "model", target = "table.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table;
    @Bind(value = "text", target = "numeMedicamentTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField numeMedicamentTextField ;
    private JTextField pretTextField ;
    private JButton btnListaMedicamente;
    private JButton btnFiltrareMedicamente;
    private JLabel producatorLabel_1;
    private JTextField producatorTextField;
    private JLabel clientNameLabel;
    private JCheckBox disponibilCheckBox;
    private JCheckBox valabilCheckBox;
    private JButton btnCautareMedicament;
    @Bind(value = "model", target = "table_1.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table_1;
    @Bind(value = "text", target = "idTabelFarmacie.value", type = BindingType.BI_DIRECTIONAL)
    private JLabel idTabelFarmacie;
    private JButton btnCreareFisiere;


    public ManagerView(Manager manager) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tabel Manager");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(324, 10, 239, 54);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate", "Stoc"},
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
                        "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate", "Stoc"
                }
        ));
        table.setBounds(24, 74, 400, 234);
        contentPane.add(table);

        idTabelFarmacie = new JLabel();

        btnListaMedicamente = new JButton("Lista Medicamente");
        btnListaMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnListaMedicamente.setBounds(434, 418, 147, 35);
        contentPane.add(btnListaMedicamente);

        clientNameLabel = new JLabel("Nume:");
        clientNameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientNameLabel.setBounds(520, 74, 83, 28);
        contentPane.add(clientNameLabel);

        JLabel clientAddressLabel = new JLabel("Disponibil:");
        clientAddressLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAddressLabel.setBounds(520, 132, 83, 28);
        contentPane.add(clientAddressLabel);

        JLabel clientEmailLabel = new JLabel("Valabil:");
        clientEmailLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientEmailLabel.setBounds(520, 188, 83, 28);
        contentPane.add(clientEmailLabel);

        JLabel clientAgeLabel = new JLabel("Pret:");
        clientAgeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAgeLabel.setBounds(520, 250, 83, 28);
        contentPane.add(clientAgeLabel);

        numeMedicamentTextField = new JTextField();
        numeMedicamentTextField .setBounds(613, 71, 125, 31);
        contentPane.add(numeMedicamentTextField );
        numeMedicamentTextField .setColumns(10);

        pretTextField = new JTextField();
        pretTextField.setBounds(613, 247, 125, 31);
        contentPane.add(pretTextField);
        pretTextField.setColumns(10);

        btnFiltrareMedicamente = new JButton("Filtrare Medicament");
        btnFiltrareMedicamente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnFiltrareMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnFiltrareMedicamente.setBounds(591, 418, 161, 35);
        contentPane.add(btnFiltrareMedicamente);

        disponibilCheckBox = new JCheckBox("");
        disponibilCheckBox.setBounds(609, 125, 93, 35);
        contentPane.add(disponibilCheckBox);

        valabilCheckBox = new JCheckBox("");
        valabilCheckBox.setBounds(609, 188, 93, 21);
        contentPane.add(valabilCheckBox);

        producatorLabel_1 = new JLabel("Producator:");
        producatorLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
        producatorLabel_1.setBounds(520, 318, 83, 28);
        contentPane.add(producatorLabel_1);

        producatorTextField = new JTextField();
        producatorTextField.setColumns(10);
        producatorTextField.setBounds(613, 315, 125, 31);
        contentPane.add(producatorTextField);

        btnCautareMedicament = new JButton("Cautare Medicament");
        btnCautareMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCautareMedicament.setBounds(765, 418, 161, 35);
        contentPane.add(btnCautareMedicament);

        btnCreareFisiere = new JButton("Creare Fisiere");
        btnCreareFisiere.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCreareFisiere.setBounds(765, 287, 161, 97);
        contentPane.add(btnCreareFisiere);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Nume"},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "Id", "Nume"
                }
        ));
        table_1.setBounds(24, 323, 400, 112);
        contentPane.add(table_1);

        VMManager viewModelManager = new VMManager();
        try{
            Binder.bind(this, viewModelManager);
        } catch(Exception ex) {
            System.out.println("\nError with binding at Admin\n");
            ex.printStackTrace();
        }

        this.btnCautareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
                idTabelFarmacie.setText(value);
                viewModelManager.comandaCautareMedicamentInFarmacie.execute();
            }
        });

        this.btnFiltrareMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
                idTabelFarmacie.setText(value);
                viewModelManager.comandaFiltrareMedicamenteInFarmacieManager.execute();
            }
        });

        viewModelManager.comandaAfisareFarmaci.execute();

        this.btnListaMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
                idTabelFarmacie.setText(value);
                viewModelManager.comandaAfisareMedicamenteInFarmacie.execute();
            }
        });

        this.setBtnCreareFisiereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModelManager.comandaGenerareFisiereManager.execute();
            }
        });

    }


    public void setBtnCreareFisiereListener(ActionListener actionListener){
        this.btnCreareFisiere.addActionListener(actionListener);
    }

    public void btnListaMedicamenteListener(ActionListener actionListener){
        this.btnListaMedicamente.addActionListener(actionListener);
    }

    public void btnCautareMedicamentListener(ActionListener actionListener){
        this.btnCautareMedicament.addActionListener(actionListener);
    }

    public void btnFiltrareMedicamenteListener(ActionListener actionListener){
        this.btnFiltrareMedicamente.addActionListener(actionListener);
    }

}

