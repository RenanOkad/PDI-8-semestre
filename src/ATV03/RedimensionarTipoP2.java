package ATV03;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RedimensionarTipoP2 {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Entrada_EscalaCinza.jpg";
        String outputImagePath = "conteudos/Entrada_EscalaCinza2.jpg";

        int newWidth = 7680;
        int newHeight = 4320;

        try {
            BufferedImage inputImage = ImageIO.read(new File(inputImagePath));
            BufferedImage resizedImage = resizeImage(inputImage, newWidth, newHeight);
            ImageIO.write(resizedImage, "jpg", new File(outputImagePath));

            System.out.println("Imagem redimensionada e salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        double xRatio = (double) originalImage.getWidth() / newWidth;
        double yRatio = (double) originalImage.getHeight() / newHeight;

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                int px = (int) (x * xRatio);
                int py = (int) (y * yRatio);
                int pixel = originalImage.getRGB(px, py);
                resizedImage.setRGB(x, y, pixel);
            }
        }

        return resizedImage;
    }
}
