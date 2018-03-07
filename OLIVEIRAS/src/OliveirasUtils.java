import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class OliveirasUtils {


    public static BufferedImage createMask(BufferedImage image, int attenuation, boolean verbose) throws IOException {
        if (verbose)
            System.out.println("\nCreating Mask from image " + image + " ...");
        int height = image.getHeight();
        int width = image.getWidth();
        int count = 0;
        Color myWhite = new Color(255, 255, 255);
        int rgb = myWhite.getRGB();
        for (int h = 1; h < height - 1; h++) {
            for (int w = 1; w < width - 1; w++) {
                if ((image.getRGB(h, w) & 0xFF) <= attenuation) {

                    image.setRGB(h, w, rgb);
                    image.setRGB(h - 1, w, rgb);
                    image.setRGB(h + 1, w, rgb);
                    count++;
                }
            }
        }
        if (verbose){
            System.out.println("Mask Image created.");
            System.out.println("Total Gaps found : " + count);
        }
        return image;
    }

    public static BufferedImage OpenImage(String Name, boolean verbose) throws IOException {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(Name));
            if (verbose) {
                System.out.println("\nOpen image " + Name + "...");
                System.out.println(image);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return image;
    }

    public static void SaveImage(String Name, BufferedImage image, boolean verbose) throws IOException {
        if (verbose)
            System.out.println("\nSaving the new Image " + Name + " ...");

        File outputfile = new File(Name);
        ImageIO.write(image, "jpg", outputfile);
    }

    static BufferedImage copyImage(BufferedImage bi, boolean verbose) {
        if (verbose)
            System.out.println("\nCloning the Image " + bi.toString()  + " ...");

        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage GreyScale(BufferedImage ColorImage, boolean verbose) throws IOException {
        BufferedImage image = null;
        int height = ColorImage.getHeight();
        int width = ColorImage.getWidth();
        image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = image.getGraphics();
        g.drawImage(ColorImage, 0, 0, null);
        g.dispose();
        if (verbose){
            System.out.println("\nConverting the image " + ColorImage + " to a Greyscale...");
            System.out.println("Size of the Image to convert, height: " + height + ", width:"+ width);

        }
        return image;
    }
}
