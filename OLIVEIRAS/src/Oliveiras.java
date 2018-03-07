import java.awt.image.BufferedImage;
import java.io.IOException;
public class Oliveiras {

    public static void OLIVEIRAS_BASIC_BW(int Iteraciones, String inputPath, String outputPath, String sourceFilename, boolean verbose ) throws IOException {
        long startTime = System.currentTimeMillis();
        String imageName =  startTime+".jpg";

        //Open Source Image
        BufferedImage originalImage = OliveirasUtils.OpenImage(inputPath+ sourceFilename, verbose);

        //Create GreyScale Image.
        BufferedImage greyImage = OliveirasUtils.GreyScale(originalImage, verbose);
        OliveirasUtils.SaveImage(outputPath+"Grey_" +imageName, greyImage, verbose);

        //Create Mask image.
        BufferedImage maskImage = OliveirasUtils.copyImage(originalImage ,verbose);
        maskImage = OliveirasUtils.createMask(originalImage, 40, verbose);
        maskImage = OliveirasUtils.GreyScale(maskImage, verbose);
        OliveirasUtils.SaveImage(outputPath+"Mask_"+ imageName, maskImage, verbose);

        //Create Out image.
        BufferedImage outImage = OliveirasUtils.copyImage(originalImage ,verbose);
        int height = outImage.getHeight();
        int width = outImage.getWidth();
        double[][] tempBand = new double[height][width];


        //tempBand = OliveirasUtils.oliveira_array_BW(originalImage, maskImage, tempBand, Iteraciones, verbose );



        long stopTime = System.currentTimeMillis();
        long elapsedTime = (stopTime - startTime)/1000;
        System.out.println("Tiempo de ejecucion: "+ elapsedTime+ " segundos.");

    }

}
