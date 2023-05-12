package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;

public class ModificacaoCadastroController {
    private static final String CAMINHO_PASTA = "C:\\TEMP\\cadastro.csv";
   

    private void novoArquivo(List<Cliente> listaClientes, String nomeArquivo) throws IOException {
    	
    	   FileWriter writer = new FileWriter(new File("C:\\TEMP\\" + nomeArquivo));
        int contador = 0;
        StringBuffer stringBuffer = new StringBuffer();

        for (Cliente cliente : listaClientes) {
        	 String linha = cliente.getClass() + ";" + cliente.getIdade() + ";" + cliente.getIdade() + ";" + cliente.getLimiteCredito() + "\n";
        	 stringBuffer.append(linha);
	            contador++;
	        }
	        writer.write(stringBuffer.toString());
	        writer.close();
	    }

    public List<Cliente> novoCadastro() throws IOException {
        List<Cliente> listaClientes = new ArrayList<>();

        Scanner scanner = new Scanner(new File(CAMINHO_PASTA));
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            	String[] campos = linha.split(";");
                String cpf = campos[0];
                String nome = campos[1];
                int idade = Integer.parseInt(campos[2]);
                double limiteCredito = Double.parseDouble(campos[3].replace(",", "."));
                    Cliente cliente = new Cliente(cpf, nome, idade, limiteCredito);
                    listaClientes.add(cliente);
                }
  

        scanner.close();
		return listaClientes;
        
  
        
    }
    public void novoArquivoClientes(int idadeMin, int idadeMax, Double limiteCredito) throws IOException {
    
    	List<Cliente> listaClientes = novoCadastro();
    	List<Cliente> clientesNovo = new ArrayList<>();
    	
    	for (Cliente cliente : listaClientes) {
    		  if (cliente.getIdade() >= idadeMin && cliente.getIdade() <= idadeMax && cliente.getLimiteCredito() >= limiteCredito) {
    			  clientesNovo.add(cliente);
    	}
    		  
        String nomeArquivo = "Idade " + idadeMin + "-" + idadeMax + " limite" + limiteCredito + ".csv";
        novoArquivo(listaClientes, nomeArquivo);
        
    }
    }
}