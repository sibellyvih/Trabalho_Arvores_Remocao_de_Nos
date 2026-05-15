public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
        System.out.println("Raiz da árvore binária criada com sucesso!");
    }

    public void inserir(Integer conteudo){
        No novoNo = new No(conteudo);
        No aux = raiz;
        if(estaVazia()){
            raiz = novoNo;
        } else {
           inserirRecursivo(novoNo, aux);
        }
    }

    private void inserirRecursivo(No novoNo, No aux){
        if (aux.getConteudo() > novoNo.getConteudo()) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido na árvore binária com sucesso!");
            } else {
                aux = aux.getEsquerda();
                inserirRecursivo(novoNo, aux);
            }
        } else {
            if (aux.getDireita() == null) {
                aux.setDireita(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido na árvore binária com sucesso!");
            } else {
                aux = aux.getDireita();
                inserirRecursivo(novoNo, aux);
            }
        }
    }

    private boolean estaVazia(){
        if(raiz != null){
            return false;
        } else {
            return true;
        }
    }

    public void percurso(String percurso) {
        if(estaVazia()) {
            System.out.println("A árvore não existe.");
            return;
        }

        switch (percurso) {
            case("Pre"):
                System.out.println("Executando a árvore em pré ordem.");
                this.preOrdem(this.raiz);
                break;
            case("Em"):
                System.out.println("Executando a árvore em ordem.");
                this.emOrdem(this.raiz);
                break;
            case("Pos"):
                System.out.println("Executando a árvore em pós ordem.");
                this.posOrdem(this.raiz);
                break;
            default:
                System.out.println("Percurso inexistente!");
                break;

        }
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    //Coloquei boolean para verificar se a remoção deu certo
    // Sempre usando o PREDECESSOR
    public boolean remover(int conteudo){
        // vou verificar se o nó existe
        No aux = raiz;
        if (!estaVazia()){
            procurarElemento(conteudo, aux);
//            if (procurarElemento(conteudo, aux)){
//                removerElemento(aux);
//            } else {
//                System.out.println("Encerrado procura!");
//                return false;
//            }
        } else {
            System.out.println("A lista está vazia!");
        }
        return true;
    }

    private boolean procurarElemento(int conteudo, No aux) {

            if (conteudo == aux.getConteudo()) {
                // se for igual raiz
                System.out.println("Elemento " + aux.getConteudo() + " encontrado na árvore binária!");
            } else if (conteudo > aux.getConteudo()) {
                //conferir se é o proximo a direita da raiz
                if(aux.getDireita().getConteudo() == conteudo){
                    return true;
                } else {
                    aux = aux.getDireita();
                    if (aux.getDireita() == null){
                        System.out.println("Elemento " + conteudo + " não encontrado na árvore binária");
                        return false;
                    } else {
                        procurarElemento(conteudo, aux);
                    }
                }

            } else {

                //conferir se é o proximo a esquerda da raiz
                if(aux.getEsquerda().getConteudo() == conteudo){
                    return true; // retorna o pai
                } else {
                    aux = aux.getEsquerda();
                    if (aux.getEsquerda() == null){
                        System.out.println("Elemento " + conteudo + " não encontrado na árvore binária");
                        return false;
                    } else {
                        procurarElemento(conteudo, aux);
                    }
                }
            }

        return true;
    }

    private void removerElemento(No aux){
        // se for folha
        if(aux.getEsquerda() == null && aux.direita == null){

        }
    }
}
