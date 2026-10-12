import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GrayFilter {

    public static void main(String[] args) throws Exception {

        String option = args[0];
        String inputPath = args[1];

        if(option.equals("gray")) {

            BufferedImage img = ImageIO.read(new File(inputPath));

            for(int y = 0; y < img.getHeight(); y++) {
                for(int x = 0; x < img.getWidth(); x++) {

                    int rgb = img.getRGB(x, y);

                    int r = (rgb >> 16) & 0xff;
                    int g = (rgb >> 8) & 0xff;
                    int b = rgb & 0xff;

                    int gray = (r + g + b) / 3;

                    int newPixel = (gray << 16) | (gray << 8) | gray;

                    img.setRGB(x, y, newPixel);
                }
            }

            ImageIO.write(img, "jpg", new File("Result.jpg"));
        }
    }
}