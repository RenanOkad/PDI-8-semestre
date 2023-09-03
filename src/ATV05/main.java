package ATV05;

import java.io.*;

public class main {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/EntradaEscalaCinza.pgm";
        String inputImagePathSaida = "conteudos/EntradaEscalaCinza_saida.pgm";
        StringWriter writer = new StringWriter();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("255") && cont == 2){
                    line = "31";
                }
                if(cont >2){
                    line = String.valueOf(Double.parseDouble(line) * 31 /255 *1.2);
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
