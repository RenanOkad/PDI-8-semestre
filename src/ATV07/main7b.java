package ATV07;

import java.io.*;

public class main7b {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Fig4.ppm";
        String inputImagePathSaida = "conteudos/Fig4-7b.ppm";
        StringWriter writer = new StringWriter();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                StringBuilder newLine = new StringBuilder();

                if (cont > 5  && !line.equalsIgnoreCase(" ")){
                    String[] s = line.split(" ");
                    for(int i = 0; i <= s.length - 1; i +=3){
                        int i1 = (Integer.parseInt(s[i]) + Integer.parseInt(s[i + 1]) + Integer.parseInt(s[i + 2]))/3;
                        newLine.append(i1).append(" ");
                    }
                    line = newLine.toString();
                }
                System.out.println(line);
                Thread.sleep(1500);
                writer.write(line);
                writer.write("\n");
                cont++;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(inputImagePathSaida)) {
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
