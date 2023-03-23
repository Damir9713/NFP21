import java.io.FileWriter;
import java.io.IOException;
public class generateXML {
    public static void main(String[] args) {

        // Création d'un objet CLI
        DefaultCli cli = new DefaultCli();


        OptionInterface indexOption = new OptionInterface("-K","50" , true, "Valeur de l'indice à calculer");

        OptionInterface precisionOption = new OptionInterface("-E","0.5", true, "Valeur de la précision à atteindre");

        OptionInterface alphaOption = new OptionInterface("-A","0.6", true,"Valeur de alpha");

        OptionInterface sparseModeOption = new OptionInterface("-C","null", true, "Mode matrice creuse");

        OptionInterface denseModeOption = new OptionInterface("-P","PLEINE", true, "Mode matrice pleine");

        cli.addOption(indexOption);

        cli.addOption(precisionOption);

        cli.addOption(alphaOption);

        cli.addOption(sparseModeOption);

        cli.addOption(denseModeOption);



        // Génération du fichier XML

        try {

            FileWriter xmlFile = new FileWriter("cli.xml");

            xmlFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

            xmlFile.write("<!DOCTYPE cli SYSTEM \"cli.dtd\">\n");

            xmlFile.write("<cli>\n");


            for (OptionInterface arg : cli.getArguments()) {
                xmlFile.write("<argument acces=\"" + arg.getOpt() + "\" nb=\"" + arg.getOptValue() + "\">" + arg.getDescription() + "</argument>\n");
            }

            xmlFile.write("</cli>");
            xmlFile.close();

            System.out.println("Le fichier XML a été généré avec succès.");

        } catch (IOException e) {

            System.out.println("Erreur : Impossible de générer le fichier XML.");

            e.printStackTrace();

        }

    }
}
