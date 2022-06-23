package auxiliar;

import entieties.Automato;
import entieties.Transicao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Auxiliar {

	public void leArquivo(String path, Automato automato) {

		int cont = 0;
		ArrayList<Transicao> auxTransicao = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path)); //criação do arquivo
			String line = br.readLine(); // leitura da primeira linha do arquivo
			while (line != null) { // percorre as linhas do arquivo
				if (cont == 0) {// identificar estados
					ArrayList<String> aux = new ArrayList<String>();
					String[] vet = line.split(","); // separando os estados por vírgula
					for (int i = 0; i < vet.length; i++) { // percorre a linha e preenche o vetor
						aux.add(vet[i]);
					}
					automato.setEstado(aux); // adiciona os estdos na classe automato
					cont++; // para pular de item
				} else if (cont == 1) {// identificar alfabeto
					ArrayList<String> aux = new ArrayList<String>();
					String[] vet = line.split(","); // separando o alfabeto por vírgula
					for (int i = 0; i < vet.length; i++) { // percorre a linha e preenche o vetor
						aux.add(vet[i]);
					}
					automato.setAlfabeto(aux); // adiciona o alfabeto na classe automato
					cont++; // para pular de item
				} else if (cont >= 2 && line.charAt(0) != '>' && line.charAt(0) != '*') {// identificar transices
					String[] vet = line.split(","); // separando as transicoes por vírgula
					Transicao t = new Transicao(vet[0], vet[2], vet[1]); // instanciando uma nova transicao com (origem, simbolo , destino)
					int controle = 0; 
					for (Transicao x : auxTransicao) { // controla se a origem e o simbolo eh igual, se for, controle = 1 para não deixar repeticao
						if (x.getOrigem().equals(t.getOrigem()) && x.getSimbolo().equals(t.getSimbolo())) {
							x.setDestino(x.getDestino() + t.getDestino());
							controle = 1;
						}
					}
					if (controle == 0) {
						auxTransicao.add(t); // adiciona as transicoes num auxiliar
					}

					cont++; // para pular de item

					automato.setTransicoes(auxTransicao); // adiciona as transicoes na classe automato
				} else if (cont >= 2 && line.charAt(0) != '*') { // identifica Estado Inicial
                                    
					String aux = "";

					if (line.charAt(0) == '>') { // identifica se o primeiro caracter do estado eh o do inicial 

						for (int i = 1; i < line.length(); i++) { // percorre o vetor e escreve tudo que for diferente de >
							aux += line.charAt(i);
						}
					}
					automato.setqInicial(aux); // adiciona os estados inicias na classe automato
					cont++;  // para pular de item

				} else {
					String aux = "";
					List<String> finais = new ArrayList<>(); 

					for (int i = 1; i < line.length(); i++) { // percorre a lista de estados finais
						aux += line.charAt(i);
					}
					String[] vet = aux.split(","); // separa os estados finais por virgula

					for (int i = 0; i < vet.length; i++) { // percorre e adiciona os finais na lista de finais
						finais.add(vet[i]);
					}

					automato.setFinais(finais); // adiciona os estados finais na classe automato

				}
				line = br.readLine(); // pula de linha a linha
			}
			br.close(); // encerra a leitura do arquivo
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE); // mensagem de erro na leitura do arquivo caso houver
		}
		List<Transicao> tabela = new ArrayList<Transicao>();
		tabela.addAll(automato.getTransicoes()); // adiciona todas as transicoes em uma tabela
		int controle = 1;
		int cont1 = 0;
		while (controle != 0) {
			controle = 0;
			for (int i = 0; i < tabela.size(); i++) { // percorre os destinos da tabela
				cont1 = 0;
				for (int j = 0; j < tabela.size(); j++) { // percorre as origens da tabela
					if (tabela.get(i).getDestino().equals(tabela.get(j).getOrigem())) { // compara se sao iguais
						cont1++; // se forem iguais muda de elemeto 
					}
				}
				if (cont1 == 0) { // destino nao esta na origem e deve ser adicionado
					controle = 0;
					String aux0 = "";
					String aux1 = "";
					List<String> quebraTexto = new ArrayList<String>();
					for (int l = 0; l < tabela.get(i).getDestino().length(); l = l + 2) { // separa o destino de dois em dois estados
						quebraTexto.add(tabela.get(i).getDestino().substring(l,
								Math.min(l + 2, tabela.get(i).getDestino().length())));
					}

					Transicao zero = new Transicao();
					Transicao um = new Transicao();
					Set<String> organiza0 = new TreeSet<String>(); // instanciando uma arvore para orenacao crescente e nao repeticao
					Set<String> organiza1 = new TreeSet<String>(); // instanciando uma arvore para orenacao crescente e nao repeticao
					for (int l = 0; l < quebraTexto.size(); l++) { 
                                            /* Dentro deste for pegamos o destino quebrado em dois caracteres, verificamos os destinos de cada elemento
                                                 e adicionamos eles as respectivas transicoes.*/
						for (Transicao adiciona : tabela) {
							if (quebraTexto.get(l).equals(adiciona.getOrigem()) && adiciona.getSimbolo().equals("0")) {
								for (int k = 0; k < adiciona.getDestino().length(); k = k + 2) {
									organiza0.add(adiciona.getDestino().substring(k,
											Math.min(k + 2, adiciona.getDestino().length())));
								}

							} else if (quebraTexto.get(l).equals(adiciona.getOrigem())
									&& adiciona.getSimbolo().equals("1")) {
								for (int k = 0; k < adiciona.getDestino().length(); k = k + 2) {
									organiza1.add(adiciona.getDestino().substring(k,
											Math.min(k + 2, adiciona.getDestino().length())));
								}
							}
						}
					}
					for (String x : organiza0) { // percorre a organizacao do simbolo zero e add no aux
						aux0 += x;
					}
					for (String x : organiza1) { // percorre a organizacao do simbolo um e add no aux
						aux1 += x;
					}
					zero.setOrigem(tabela.get(i).getDestino());
					zero.setSimbolo("0");
					zero.setDestino(aux0);

					um.setOrigem(tabela.get(i).getDestino());
					um.setSimbolo("1");
					um.setDestino(aux1);
					tabela.add(zero); // adicao de nova transicao na tabela
					tabela.add(um); // adicao de nova transicao na tabela
				}
			}
		}
		Set<String> novosFinais = new TreeSet<String>();
		novosFinais.addAll(automato.getFinais()); // pegando os antigos finais e jogando nos novos

		for (Transicao destino : tabela) {
			for (int i = 0; i < automato.getFinais().size(); i++) { // percorre todos finais e adiocina o que nao estao incluidos
				for (int k = 0; k < destino.getOrigem().length(); k = k + 2) {
					String aux = destino.getOrigem().substring(k, Math.min(k + 2, destino.getDestino().length()));
					if (aux.equals(automato.getFinais().get(i))) {
						novosFinais.add(destino.getOrigem());
					}
				}
			}
		}
		Transicao t = new Transicao("Ø", "Ø", "Ø");
		tabela.add(0, t);  //inclusao da transicao vazia
		automato.setNovosFinais(novosFinais); // adicao de novos finais no AFD
		automato.setTabela(tabela); // adicao das novas transicoes no AFD
	}

	public void criaArquivo(String criaArquivo, Automato automato) { // metodo para criacao do arquivo novo


		try {
			File arquivo = new File(criaArquivo);
			arquivo.createNewFile(); // cria novo arquivo
			FileWriter fw = new FileWriter(arquivo); 
			@SuppressWarnings("resource")
			BufferedWriter bw = new BufferedWriter(fw);

			for(String x: automato.getEstado()) {
				if(!x.equals(automato.getEstado().get(automato.getEstado().size()-1))) {
					bw.write(x + ","); // escreve os estados no arquivo
				}else {
					bw.write(x);
				}
			}
			bw.newLine();
			
			bw.write("0,1"); // escreve os simbolos no arquivo
			bw.newLine();
			
			for(Transicao x: automato.getTabela()) {
				bw.write(x.getOrigem()+ "," + x.getSimbolo() + "," + x.getOrigem()); // escreve as transicoes no arquivo
				bw.newLine();
			}
			bw.write(">" + automato.getqInicial()); // escreve o estado inicial no arquivo
			bw.newLine();
			
			bw.write("*");
			List<String> auxiliar = new ArrayList<String>();
			auxiliar.addAll(automato.getNovosFinais());
			for(String x: auxiliar) {
				if(!x.equals(auxiliar.get(auxiliar.size()-1))) {
					bw.write(x + ","); // escreve os estados fianis no arquivo
				}else {
					bw.write(x);
				}
			}
			bw.newLine();
			bw.close(); // encerra a criacao do arquivo
			fw.close(); // encerra a escrita do arquivo
			JOptionPane.showMessageDialog(null, "ARQUIVO CRIADO COM SUCESSO!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro na cria��o do arquivo: " + e, "ERROR!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
