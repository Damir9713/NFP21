import java.awt.*;

public class PDFconfig {
    public String inputPath;
    public String outputPath;
    public String fontName = "Arial";
    public int fontSize = 12;
    public Color textColor = Color.BLACK;

    @Override
    public String toString() {
        return "PDFconfig{" +
                "inputPath='" + inputPath + '\'' +
                ", outputPath='" + outputPath + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                ", textColor=" + textColor +
                '}';
    }
}
