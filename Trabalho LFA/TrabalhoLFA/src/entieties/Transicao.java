package entieties;

public class Transicao {

    private String origem;
    private String destino;
    private String simbolo;

    public Transicao(String origem, String destino, String simbolo) {
        this.origem = origem;
        this.destino = destino;
        this.simbolo = simbolo;
    }
    public Transicao() {
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Transicao{" + "origem=" + origem + ", simbolo=" + simbolo + ", destino=" + destino +  '}';
    }

    

    
}
