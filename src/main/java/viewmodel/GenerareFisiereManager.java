package viewmodel;

import com.google.gson.Gson;
import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class GenerareFisiereManager implements ICommand {
    private VMManager vmManager;

    public GenerareFisiereManager() {
    }

    public GenerareFisiereManager(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    public VMManager vmManager() { return  vmManager;}

    public void setVmAngajat(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    @Override
    public void execute() {
        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();


        FileWriter fileWriterTxt;
        FileWriter fileWriterCsv;
        FileWriter fileWriterJson;

        try {
            fileWriterTxt = new FileWriter("MedicamenteInFarmacieManager.txt");
            fileWriterCsv = new FileWriter("MedicamenteInFarmacieManager.csv");
            fileWriterJson = new FileWriter("MedicamenteInFarmacieManager.json");

            Gson gson = new Gson();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("Farmacie");
            document.appendChild(root);


            fileWriterCsv.append("Id, Disponibilitate, Nume, Pret, Producator, Valabilitate,Stoc" + "\n");

            List<Farmacie> listaFarmacii = farmaciePersistent.listaFarmacii();
            for (Farmacie farmacie : listaFarmacii){

                List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.listaMedicamente(farmacie.getId());

            for (MedicamentInFarmacie medicamentInFarmacie : medicamentInFarmacieList) {

                fileWriterCsv.append(medicamentInFarmacie.getId() + ",");
                fileWriterCsv.append(medicamentInFarmacie.getMedicament().isDisponibil().toString() + ",");
                fileWriterCsv.append(medicamentInFarmacie.getMedicament().getNume() + ",");
                fileWriterCsv.append(Integer.toString(medicamentInFarmacie.getMedicament().getPret()) + ",");
                fileWriterCsv.append(medicamentInFarmacie.getMedicament().getProducator() + ",");
                fileWriterCsv.append(medicamentInFarmacie.getMedicament().isValabil() + ",");
                fileWriterCsv.append(medicamentInFarmacie.getStoc() + "\n");

                fileWriterTxt.write(medicamentInFarmacie.toString() + "\n");


                Element c = document.createElement("MedicamentInFarmacie");
                root.appendChild(c);

                Element id = document.createElement("Id");
                id.appendChild(document.createTextNode(medicamentInFarmacie.getId() + ""));
                c.appendChild(id);

                Element disponibilitate = document.createElement("Disponibilitate");
                disponibilitate.appendChild(document.createTextNode(medicamentInFarmacie.getMedicament().isDisponibil().toString()));
                c.appendChild(disponibilitate);

                Element nume = document.createElement("Nume");
                nume.appendChild(document.createTextNode(medicamentInFarmacie.getMedicament().getNume()));
                c.appendChild(nume);

                Element pret = document.createElement("Pret");
                pret.appendChild(document.createTextNode(Integer.toString(medicamentInFarmacie.getMedicament().getPret())));
                c.appendChild(pret);

                Element producator = document.createElement("Producator");
                producator.appendChild(document.createTextNode(medicamentInFarmacie.getMedicament().getProducator() + ""));
                c.appendChild(producator);

                Element valabilitate = document.createElement("Valabilitate");
                valabilitate.appendChild(document.createTextNode(medicamentInFarmacie.getMedicament().isValabil() + ""));
                c.appendChild(valabilitate);

                Element stoc = document.createElement("Stoc");
                stoc.appendChild(document.createTextNode(medicamentInFarmacie.getStoc() + ""));
                c.appendChild(stoc);


                fileWriterJson.append(medicamentInFarmacie.toString() + "\n");

            }
        }

            File xmlFile = new File("MedicamenteInFarmacieManager.xml");
            javax.xml.transform.TransformerFactory transformerFactory= javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);

            fileWriterTxt.close();
            fileWriterCsv.close();


            fileWriterJson.close();

        }catch (Exception exp) {
            System.out.println("Error while files for angajat");
            exp.printStackTrace();
        }
    }

}
