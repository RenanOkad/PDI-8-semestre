package ATV01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PBMTipoP2 {

    public static void main(String[] args) {

        String txtInicial = "P2\n#feep.pgm\n100 100\n16\n";

        String caminhoTXT = "conteudos\\desenhoP2.txt";
        String caminhoArquivopbm = "C:conteudos\\desenhoP2.pbm";

        Random random = new Random();

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                txtInicial += random.nextInt(17) + " ";
            }
            txtInicial += "\n";
        }

        System.out.println(txtInicial);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivopbm))) {
            writer.flush();
            writer.write(txtInicial);
            System.out.println("Arquivo .txt gravado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo .txt: " + e.getMessage());
        }

        String caminhoArquivoCsv = "desenhos\\desenhoP2.pbm";
        File arquivoTxt = new File(caminhoTXT);
        File arquivoCsv = new File(caminhoArquivoCsv);
    }

}
