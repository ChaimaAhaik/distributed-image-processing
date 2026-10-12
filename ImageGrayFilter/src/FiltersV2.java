import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FiltersV2 {

    public static void main(String[] args) throws Exception {

        String option = args[0];
        String fileName = args[1];

        BufferedImage image = ImageIO.read(new File(fileName));

        if (option.equals("gray")) {

            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {

                    int rgb = image.getRGB(x, y);

                    int r = (rgb >> 16) & 0xff;
                    int g = (rgb >> 8) & 0xff;
                    int b = rgb & 0xff;

                    int gray = (r + g + b) / 3;

                    int newPixel = (gray << 16) | (gray << 8) | gray;

                    image.setRGB(x, y, newPixel);
                }
            }

            ImageIO.write(image, "jpg", new File("Result.jpg"));
        }
    }
}