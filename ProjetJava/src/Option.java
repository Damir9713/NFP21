public class Option {
    private String letter;

    private String description;

    private boolean requiresValue;

    private String value;

    public Option(String letter, String description, boolean requiresValue, String value) {

        this.letter = letter;

        this.description = description;

        this.requiresValue = requiresValue;

        this.value = value;

    }

    public String getOptionAccess() {

        return letter;

    }

    public String getOptionDescription() {

        return description;

    }

    public boolean hasValue() {

        return requiresValue;

    }
    public String getValue() {

        return value;

    }

    public void setValue(String value) {

        this.value = value;

    }
}
