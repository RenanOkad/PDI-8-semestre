package ATV11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main11a {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Entrada_RGB11a.ppm";
        String inputImagePathSaida90 = "conteudos/Entrada_RGBsaida11a90.ppm";
        String inputImagePathSaida180 = "conteudos/Entrada_RGBsaida11a180.ppm";
        String line;
        int lineNumber = 0;
        int width = 0;
        int height = 0;
        List<String> header = new ArrayList<>();
        List<String> pixels = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath));
             BufferedWriter writer90 = new BufferedWriter(new FileWriter(inputImagePathSaida90));
             BufferedWriter writer180 = new BufferedWriter(new FileWriter(inputImagePathSaida180))) {

            while ((line = reader.readLine()) != null) {
                if (lineNumber > 5 && !line.equalsIgnoreCase("")) {
                    pixels.add(line);
                } else if (!line.equalsIgnoreCase("")) {
                    header.add(line);
                }
                lineNumber++;
            }

            for (String headerLine : header) {
                writer90.write(headerLine);
                writer90.newLine();
                writer180.write(headerLine);
                writer180.newLine();
            }

            writer90.write(height + " " + width);
            writer90.newLine();
            for (int i = width - 1; i >= 0; i--) {
                for (int j = 0; j < height; j++) {
                    int index = i * height + j;
                    writer90.write(pixels.get(index));
                    writer90.newLine();
                }
            }

            for (int i = pixels.size() - 1; i >= 0; i--) {
                writer180.write(pixels.get(i));
                writer180.newLine();
            }

            System.out.println("Imagem 90 graus gerada");
            writer90.close();

            System.out.println("Imagem 180 graus gerada");
            writer180.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
