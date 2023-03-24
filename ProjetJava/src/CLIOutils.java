import java.lang.reflect.Field;

    public class CLIOutils {

        public static DefaultCli fromClass(String className) throws ClassNotFoundException {

            Class<?> configClass = Class.forName(className);

            DefaultCli cli = new DefaultCli();

            for (Field field : configClass.getDeclaredFields()) {

                field.setAccessible(true);

                String opt = field.getName().substring(0, 1);

                String desc = "Valeur de " + field.getName();


                if (field.getType() == boolean.class || field.getType() == Boolean.class) {

                    String trueOpt = opt.toLowerCase();

                    String falseOpt = opt.toUpperCase();

                    String trueDesc = "Positionner " + field.getName() + " à vrai";

                    String falseDesc = "Positionner " + field.getName() + " à faux";


                    cli.addOption(new OptionInterface(trueOpt, "50", true,trueDesc));

                    cli.addOption(new OptionInterface(falseOpt, "0.5", true, falseDesc));

                } else {

                    cli.addOption(new OptionInterface(opt, "6", true, desc));

                }

            }
            return cli;

        }
    }

