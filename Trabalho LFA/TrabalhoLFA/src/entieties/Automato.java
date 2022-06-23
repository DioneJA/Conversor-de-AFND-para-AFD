package entieties;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Automato {
    
    private List<String> estado = new ArrayList<>();
    private List<String> alfabeto = new ArrayList<>();
    private List<Transicao> transicoes = new ArrayList<>();
    private String qInicial;
    private List<String> finais = new ArrayList<>();
    private List<Transicao> tabela = new ArrayList<>();
    private Set<String> novosFinais = new TreeSet<String>();
    
    public Set<String> getNovosFinais() {
		return novosFinais;
	}

	public void setNovosFinais(Set<String> novosFinais) {
		this.novosFinais = novosFinais;
	}

	public List<String> getEstado() {
        return estado;
    }

    public void setEstado(List<String> estado) {
        this.estado = estado;
    }


    public List<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(List<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(List<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public String getqInicial() {
        return qInicial;
    }

    public void setqInicial(String qInicial) {
        this.qInicial = qInicial;
    }


    public List<String> getFinais() {
        return finais;
    }

    public void setFinais(List<String> finais) {
        this.finais = finais;
    }
    
    public List<Transicao> getTabela() {
		return tabela;
	}

	public void setTabela(List<Transicao> tabela) {
		this.tabela = tabela;
	}

	@Override
    public String toString() {
        return "Automato{" + "estado=" + estado + ", alfabeto=" + alfabeto + ", transicoes=" + transicoes + ", qInicial=" + qInicial + ", finais=" + finais + '}';
    }
    
}
