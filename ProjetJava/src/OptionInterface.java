public class OptionInterface implements DefaultOption {
    private final String opt;

    private final String OptValue;

    private final boolean hasValue;

    private final String description;

    public OptionInterface(String opt, String OptValue, boolean hasValue, String description) {

        this.opt = opt;

        this.OptValue = OptValue;

        this.hasValue = hasValue;

        this.description = description;

    }

    @Override

    public String getOpt() {

        return opt;

    }

    @Override

    public String getOptValue() {

        return OptValue;

    }

    @Override

    public boolean hasValue() {

        return hasValue;

    }

    @Override

    public String getDescription() {

        return description;

    }

}

