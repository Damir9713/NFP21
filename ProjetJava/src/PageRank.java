public class PageRank {
    public static void main(String... args) {

        CLI cli = new CLI();

        // Définition des options pour la ligne de commande

        Option indexOption = new Option("-K", "Valeur de l'indice à calculer", true, "50");

        Option precisionOption = new Option("-E", "Valeur de la précision à atteindre", true, "0.7");

        Option alphaOption = new Option("-A", "Valeur de alpha", true, "0.5");

        Option CreuseModeOption = new Option("-C", "Mode matrice creuse", true, "null");

        Option PleineModeOption = new Option("-P", "Mode matrice pleine", true, "PLEINE");

        // Ajout des options à la ligne de commande

        cli.addOption(indexOption);

        cli.addOption(precisionOption);

        cli.addOption(alphaOption);

        cli.addOption(CreuseModeOption);

        cli.addOption(PleineModeOption);

        // Récupération des valeurs des options

        int index = Integer.parseInt(indexOption.getValue());

        double epsilon = Double.parseDouble(precisionOption.getValue());

        double alpha = Double.parseDouble(alphaOption.getValue());

        Mode mode = (CreuseModeOption.getValue() != "null") ? Mode.CREUSE : Mode.PLEINE;

        // Création de la configuration

        Configuration configuration = new Configuration();



        if (cli.hasOption("-K")) {

            configuration.indice = index;

        }

        if (cli.hasOption("-E")) {

            configuration.epsilon = epsilon;

        }

        if (cli.hasOption("-A")) {

            configuration.alpha = alpha;

        }

        if (cli.hasOption("-P")) {

            configuration.mode = mode;
        }

        System.out.println(configuration);

    }
}