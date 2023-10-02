package ATV10;

import java.io.*;

public class main10a {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/EntradaEscalaCinza.pgm";
        String inputImagePathSaida = "conteudos/EntradaEscalaCinza_saida10.pgm";
        StringWriter writer = new StringWriter();
        int xMax = 0;
        int xMin = 9999;
        int a;
        int b;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                if (cont > 2) {
                    if (Double.parseDouble(line) > xMax) {
                        xMax = Integer.parseInt(line);
                    }
                    if (Double.parseDouble(line) < xMin) {
                        xMin = Integer.parseInt(line);
                    }
                } else {
                    if (line.equalsIgnoreCase("P2")) {
                    }
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        a = 255 / (xMax - xMin);
        b = -a * xMin;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                if (cont > 2) {
                    line = String.valueOf(a * Integer.parseInt(line) + b);
                }
                writer.write(line);
                writer.write("\n");
                cont++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(inputImagePathSaida)) {
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
