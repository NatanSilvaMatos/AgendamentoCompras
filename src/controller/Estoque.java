package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Produto;

public class Estoque {

	public void abasteceEstoque() {
		String arquivo = "Estoque.txt";

		String texto = "Banana 1.50, 20 \nLeite, 2.00, 20 \nDesodorante, 9.90, 20 \nRefrigerante, 5.50, 20 \nMargarina, 7.00, 20 \nAmaciante, 15.00, 20 \nMelancia, 8.00, 20"
				+ "\nBolo, 4.50, 20 \nCarne, 7.90, 20 \nSuco, 3.90, 20";


		File arq = new File(arquivo);
		FileWriter fileWriter = null;
		PrintWriter print = null;
		if(arq.exists() && arq.isFile()) {
			System.out.println("Arquivo já criado");
		}
		else {
			try {
				fileWriter = new FileWriter(arq, true);
				print = new PrintWriter(fileWriter);
				print.write(texto);
				print.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					print.close();
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
