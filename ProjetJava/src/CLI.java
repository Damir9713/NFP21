import java.util.ArrayList;
import java.util.List;

public class CLI {

    private List<Option> options;

    public CLI() {
        options = new ArrayList<>();
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public void parse(String[] args, Configuration configuration) {
        boolean endOfOptions = false;
        int i = 0;
        while (i < args.length && !endOfOptions) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                String opt = arg.substring(1);
                Option option = getOption(opt);
                if (option != null) {
                    if (option.hasValue()) {
                        if (i + 1 < args.length) {
                            String value = args[++i];
                        } else {
                            System.out.println("L'option " + arg + " nécessite une valeur.");
                            endOfOptions = true;
                        }
                    }
                } else {
                    System.out.println("Option inconnue : " + arg);
                    endOfOptions = true;
                }
            } else {
                endOfOptions = true;
            }
            i++;
        }
    }

    private Option getOption(String opt) {
        for (Option option : options) {
            if (option.getOptionAccess().equals(opt)) {
                return option;
            }
        }
        return null;
    }

    public boolean hasOption(String letter) {
        for (Option option : options) {
            if (option.getOptionAccess().equals(letter)) {
                return option.hasValue();
            }
        }
        return false;
    }

}

