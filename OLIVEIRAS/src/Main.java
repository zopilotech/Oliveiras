import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Variables
        int iteraciones = 1000;
        int attenuation = 40;
        String inputPath = "inputImage/";
        String outputPath ="outputImage/";
        //String sourceFilename = "R326X326.jpg";
        String sourceFilename= "Lenna1.jpg";
        boolean verbose = true;
        //OLIVEIRAS
        //OLIVEIRAS_IMAGENES_CONTORNO(iteraciones, inputPath,outputPath ,sourceFilename,verbose );
        Oliveiras.OLIVEIRAS_BASIC_BW(iteraciones, inputPath,outputPath ,sourceFilename,verbose );
        //

    }




}
