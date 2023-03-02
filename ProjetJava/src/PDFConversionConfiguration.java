import java.awt.*;

public class PDFConversionConfiguration {

    public static PDFConversionConfiguration PDFconfig(String... args) {
        PDFConversionConfiguration config = new PDFConversionConfiguration();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-i":
                    config.inputPath = args[++i] ;
                    break;
                case "-o":
                    config.setOutputPath(args[++i]);
                    break;
                case "-f":
                    config.setFontName(args[++i]);
                    break;
                case "-s":
                    config.setFontSize(Integer.parseInt(args[++i]));
                    break;
                case "-c":
                    config.setTextColor(Color.decode(args[++i]));
                    break;
                default:
                    System.err.println("Unknown option: " + arg);
                    System.exit(1);
            }
        }
        // Check required options
        if (config.getInputPath() == null || config.getOutputPath() == null) {
            System.err.println("Missing required options: -i and -o");
            System.exit(1);
        }
        return config;
    }

}
