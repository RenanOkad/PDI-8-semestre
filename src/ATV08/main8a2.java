package ATV08;

import java.io.*;

public class main8a2 {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/Fig4.ppm";
        String inputImagePathSaida = "conteudos/Fig4-B)imagem2.ppm";
        StringWriter writer = new StringWriter();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                StringBuilder newLine = new StringBuilder();
                if (cont > 5  && !line.equalsIgnoreCase(" ")){
                    String[] s = line.split(" ");
                    for(int i = 0; i <= s.length - 1; i +=3){
                        String r = " 0 ";
                        String g = (s[i +1]);
                        String b = " 0 ";
                        String i1 = (r + g + b);
                        newLine.append(i1).append(" ");
                    }
                    line = newLine.toString();
                }
                writer.write(line);
                writer.write("\n");
                cont++;
            }

        } catch (IOException  e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(inputImagePathSaida)) {
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
