package ATV03;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class RedimensionarTipoP2 {
    public static void main(String[] args) {
        // Caminho da imagem de entrada e saída
        String inputFilePath = "conteudos\\Entrada_EscalaCinza.pgm";
        String outputFilePath = "conteudos\\Entrada_EscalaCinzaAtualizada.pgm";

        // Fator de escala para redimensionar
        double scale = 0.5; // Altere o valor conforme necessário

        try {
            // Carregar a imagem de entrada
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.out.println("Arquivo de entrada não encontrado.");
                return;
            }
            BufferedImage inputImage = ImageIO.read(inputFile);
            if (inputImage == null) {
                System.out.println("Não foi possível carregar a imagem de entrada.");
                return;
            }
            int inputWidth = inputImage.getWidth();
            int inputHeight = inputImage.getHeight();

            // Calcular a nova largura e altura
            int outputWidth = (int) (inputWidth * scale);
            int outputHeight = (int) (inputHeight * scale);

            // Criar uma nova imagem para saída
            BufferedImage outputImage = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_BYTE_GRAY);

            // Redimensionar a imagem manualmente
            for (int y = 0; y < outputHeight; y++) {
                for (int x = 0; x < outputWidth; x++) {
                    int inputX = (int) (x / scale);
                    int inputY = (int) (y / scale);
                    int grayValue = inputImage.getRGB(inputX, inputY) & 0xFF;
                    int newPixelValue = (grayValue << 16) | (grayValue << 8) | grayValue;
                    outputImage.setRGB(x, y, newPixelValue);
                }
            }

            // Salvar a imagem redimensionada
            ImageIO.write(outputImage, "PGM", new File(outputFilePath));

            System.out.println("Imagem redimensionada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}