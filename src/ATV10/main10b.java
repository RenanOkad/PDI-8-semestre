package ATV10;

import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

import java.io.*;

public class main10b {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Fig4.ppm";
        String inputImagePathSaida = "conteudos/Fig4-10b.ppm";
        StringWriter writer = new StringWriter();
        int xMaxR = 0;
        int xMaxG = 0;
        int xMaxB = 0;
        int xMinR = 9999;
        int xMinG = 9999;
        int xMinB = 9999;
        int aR;
        int aG;
        int aB;
        int bR;
        int bG;
        int bB;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                if (cont > 5 && !line.equalsIgnoreCase(" ")) {
                    String[] s = line.split(" ");
                    for (int i = 0; i <= s.length - 1; i += 3) {

                        if (Integer.parseInt(s[i]) > xMaxR) {
                            xMaxR = Integer.parseInt(s[i]);
                        }
                        if (Integer.parseInt(s[i + 1]) > xMaxG) {
                            xMaxG = Integer.parseInt(s[i + 1]);
                        }
                        if (Integer.parseInt(s[i + 2]) > xMaxB) {
                            xMaxB = Integer.parseInt(s[i + 2]);
                        }

                        if (Integer.parseInt(s[i]) < xMinR) {
                            xMinR = Integer.parseInt(s[i]);
                        }
                        if (Integer.parseInt(s[i + 1]) < xMinG) {
                            xMinG = Integer.parseInt(s[i + 1]);
                        }
                        if (Integer.parseInt(s[i + 2]) < xMinB) {
                            xMinB = Integer.parseInt(s[i + 2]);
                        }
                    }
                }
                cont++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        aR = 255 / (xMaxR - xMinR);
        bR = -aR * xMinR;

        aG = 255 / (xMaxG - xMinG);
        bG = -aG * xMinG;

        aB = 255 / (xMaxB - xMinB);
        bB = -aB * xMinB;


        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                StringBuilder newLine = new StringBuilder();
                if (cont > 5 && !line.equalsIgnoreCase(" ")) {
                    String[] s = line.split(" ");
                    for (int i = 0; i <= s.length - 1; i += 3) {
                        String i1 = (aR * Integer.parseInt(s[i]) + bR) + " " + (aG * Integer.parseInt(s[i + 1]) + bG) + " "+ (aB * Integer.parseInt(s[i + 2]) + bB);
                        newLine.append(i1).append(" ");
                    }
                    line = newLine.toString();
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
