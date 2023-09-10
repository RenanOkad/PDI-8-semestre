package ATV05;

import java.io.*;

public class main5b {
    public static void main(String[] args) {

        String inputImagePath = "conteudos/EntradaEscalaCinza.pgm";
        String inputImagePathSaida = "conteudos/EntradaEscalaCinza_saida5b.pgm";
        StringWriter writer = new StringWriter();
        Double limiar = 128.00;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputImagePath))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                if(cont > 2){
                    if(Double.parseDouble(line) <= limiar){
                        line = "0";
                    } else{
                        line = "1";
                    }
                } else{
                    if(line.equalsIgnoreCase("P2")){
                        line = "P1";
                    } else if(line.equalsIgnoreCase("255")){
                        line = "1";
                    }
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
