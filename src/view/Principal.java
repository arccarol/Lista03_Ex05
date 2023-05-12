package view;

import java.io.IOException;

import controller.ModificacaoCadastroController;

public class Principal {
	 public static void main(String[] args) {
	        ModificacaoCadastroController controller = new ModificacaoCadastroController();

	        try {
				controller.novoArquivoClientes(41, 60, 8000.00);
				controller.novoArquivoClientes(31, 40, 5000.00);
		        controller.novoArquivoClientes(21, 30, 3000.00);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}