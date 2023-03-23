public class interCli {
    public static void main(String... args) {

        DefaultCli cli = new DefaultCli();

        // Définition des options pour la ligne de commande

        OptionInterface indexOption = new OptionInterface("-K","50" , true, "Valeur de l'indice à calculer");

        OptionInterface precisionOption = new OptionInterface("-E","0.5", true, "Valeur de la précision à atteindre");

        OptionInterface alphaOption = new OptionInterface("-A","0.6", true,"Valeur de alpha");

        OptionInterface CreuseModeOption = new OptionInterface("-C","null", true, "Mode matrice creuse");

        OptionInterface PleineModeOption = new OptionInterface("-P","PLEINE", true, "Mode matrice pleine");

        // Ajout des options à la ligne de commande

        cli.addOption(indexOption);

        cli.addOption(precisionOption);

        cli.addOption(alphaOption);

        cli.addOption(CreuseModeOption);

        cli.addOption(PleineModeOption);



        // Récupération des valeurs des options

        int index = Integer.parseInt(indexOption.getOptValue());

        double epsilon = Double.parseDouble(precisionOption.getOptValue());

        double alpha = Double.parseDouble(alphaOption.getOptValue());

        Mode mode = (CreuseModeOption.getOptValue() != "null") ? Mode.CREUSE : Mode.PLEINE;

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
