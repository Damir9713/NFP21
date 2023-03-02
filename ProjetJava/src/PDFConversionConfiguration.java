import java.awt.*;

public class PDFConversionConfiguration {

    public static PDFconfig PDFconfig(String... args) {
        PDFconfig config = new PDFconfig();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-i":
                    config.inputPath = args[++i];
                    break;
                case "-o":
                    config.outputPath = args[++i];
                    break;
                case "-f":
                    config.fontName = args[++i];
                    break;
                case "-s":
                    config.fontSize = Integer.parseInt(args[++i]);
                    break;
                case "-c":
                    config.textColor = Color.decode(args[++i]);
                    break;
                default:
                    System.err.println("Unknown option: " + arg);
                    System.exit(1);
            }
        }
        // Check required options
        if (config.inputPath == null || config.outputPath == null) {
            System.err.println("Missing required options: -i and -o");
            System.exit(1);
        }
        return config;
    }

}
