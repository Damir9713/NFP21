public class CLIClassique {

	public static Configuration configuration(String... args) {
		Configuration config = new Configuration();
		boolean finOptions = false;
		int i = 0;
		while (i < args.length && !finOptions) {
			String arg = args[i];
			switch (arg) {
				case "-K": // Valeur de l'indice à calculer
					try {
						config.indice = Integer.parseInt(args[++i]);
					} catch (NumberFormatException e) {
						System.out.println("Valeur d'indice invalide : " + args[i]);
					}
					break;
				case "-E": // Valeur de la précision à atteindre
					try {
						config.epsilon = Double.parseDouble(args[++i]);
					} catch (NumberFormatException e) {
						System.out.println("Valeur de précision invalide : " + args[i]);
					}
					break;
				case "-A": // Valeur de alpha
					try {
						config.alpha = Double.parseDouble(args[++i]);
					} catch (NumberFormatException e) {
						System.out.println("Valeur de alpha invalide : " + args[i]);
					}
					break;
				case "-C": // Mode matrice creuse
					config.mode = Mode.CREUSE;
					break;
				case "-P": // Mode matrice pleine
					config.mode = Mode.PLEINE;
					break;
				default:
					finOptions = arg.length() == 0 || arg.charAt(0) != '-';
					if (!finOptions) {
						System.out.println("Option inconnue : " + arg);
					}
			}
			i++;
		}
		return config;
	}
}
