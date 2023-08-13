package ATV02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PBMTipoP3_b {

	public static void main(String[] args) {

		String txtInicial = "P3\n#feep.pgm\n1000 1000 255\n";

		String caminhoArquivopbm = "conteudos\\desenhoP3b.pbm";

		Random random = new Random();

		for (int x = 0; x <= 1000; x++) {
			for (int y = 0; y <= 1000; y++) {
				txtInicial += random.nextInt(256) + " " + random.nextInt(256) + " " + random.nextInt(256) + " ";
			}
			txtInicial += "\n";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivopbm))) {
				System.out.print(txtInicial);
				writer.flush();
				writer.write(txtInicial);
				txtInicial = "";
			} catch (IOException e) {
				System.err.println("Erro ao gravar o arquivo .txt: " + e.getMessage());
			}
			
		}
		System.out.println("Arquivo .txt gravado com sucesso.");
	}

}
