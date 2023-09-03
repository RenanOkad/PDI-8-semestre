package ATV03;

import java.io.*;
import java.util.Scanner;

public class RedimensionarTipoP2 {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Entrada_RGB.ppm";
        String imagemDeSaidaPath = "conteudos/Entrada_RGBsaida.txt";

        int novaLargura = 1920;
        int novaAltura = 1080;

        try {
            PGMImage imagemDeEntrada = lerImagemPGM(inputImagePath);
            PGMImage imagemRedimensionada = redimensionarImagemPGM(imagemDeEntrada, novaLargura, novaAltura);
            escreverImagemPGM(imagemRedimensionada, imagemDeSaidaPath);

            System.out.println("Imagem PGM redimensionada e salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PGMImage lerImagemPGM(String imagePath) throws IOException {
        Scanner scanner = new Scanner(new File(imagePath));
        scanner.nextLine(); // Ignorar a primeira linha "P2"
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int maxValue = scanner.nextInt();

        int[][] pixels = new int[altura][largura];
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                pixels[y][x] = scanner.nextInt();
            }
        }

        return new PGMImage(largura, altura, maxValue, pixels);
    }

    private static void escreverImagemPGM(PGMImage image, String imagePath) throws IOException {
        FileWriter writer = new FileWriter(imagePath);
        writer.write("P2\n");
        writer.write(image.getLargura() + " " + image.getAltura() + "\n");
        writer.write(image.getValorMax() + "\n");

        int[][] pixels = image.getPixels();
        for (int y = 0; y < image.getAltura(); y++) {
            for (int x = 0; x < image.getLargura(); x++) {
                writer.write(pixels[y][x] + " ");
            }
            writer.write("\n");
        }

        writer.close();
    }

    private static PGMImage redimensionarImagemPGM(PGMImage originalImage, int newlargura, int newaltura) {
        int[][] originalPixels = originalImage.getPixels();
        int[][] resizedPixels = new int[newaltura][newlargura];
        double xRatio = (double) originalImage.getLargura() / newlargura;
        double yRatio = (double) originalImage.getAltura() / newaltura;

        for (int y = 0; y < newaltura; y++) {
            for (int x = 0; x < newlargura; x++) {
                int px = (int) (x * xRatio);
                int py = (int) (y * yRatio);
                resizedPixels[y][x] = originalPixels[py][px];
            }
        }

        return new PGMImage(newlargura, newaltura, originalImage.getValorMax(), resizedPixels);
    }

    private static class PGMImage {
        private int largura;
        private int altura;
        private int valorMax;
        private int[][] pixels;

        public PGMImage(int largura, int altura, int maxValue, int[][] pixels) {
            this.largura = largura;
            this.altura = altura;
            this.valorMax = maxValue;
            this.pixels = pixels;
        }

        public int getLargura() {
            return largura;
        }

        public int getAltura() {
            return altura;
        }

        public int getValorMax() {
            return valorMax;
        }

        public int[][] getPixels() {
            return pixels;
        }
    }
}
