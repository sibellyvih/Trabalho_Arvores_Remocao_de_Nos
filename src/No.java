public class No {
    No esquerda;
    No direita;
    Integer Conteudo;

    public No(Integer conteudo) {
        this.esquerda = null;
        this.direita = null;
        Conteudo = conteudo;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public Integer getConteudo() {
        return Conteudo;
    }

    public void setConteudo(Integer conteudo) {
        Conteudo = conteudo;
    }
}
