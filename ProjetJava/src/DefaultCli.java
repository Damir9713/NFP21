import java.util.ArrayList;
import java.util.List;
public class DefaultCli implements InterfaceCLI {
    private final List<OptionInterface> options = new ArrayList<>();

    public void addOption(OptionInterface option) {

        options.add(option);

    }

    public List<OptionInterface> getArguments() {
        return options;
    }

    public boolean hasOption(String opt) {

        for (OptionInterface option : options) {

            if (option.getOpt().equals(opt)) {

                return option.hasValue();
            }
        }
        return false;
    }
}
