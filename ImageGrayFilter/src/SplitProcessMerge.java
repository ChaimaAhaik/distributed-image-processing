import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class SplitProcessMerge {

    public static void main(String[] args) throws Exception {

        int parts = Integer.parseInt(args[0]);
        String fileName = args[1];

        BufferedImage image = ImageIO.read(new File(fileName));

        int width = image.getWidth();
        int height = image.getHeight();

        int subHeight = height / parts;

        for (int i = 0; i < parts; i++) {

            int y = i * subHeight;
            int h = (i == parts - 1) ? height - y : subHeight;

            BufferedImage subImage = image.getSubimage(0, y, width, h);

            ImageIO.write(subImage, "jpg", new File("sub" + i + ".jpg"));

            System.out.println("Created sub" + i + ".jpg");
        }
    }
}