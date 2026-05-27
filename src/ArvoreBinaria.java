public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
        System.out.println("Raiz da árvore binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        No aux = raiz;
        if (estaVazia()) {
            raiz = novoNo;
            System.out.println("Nó " + novoNo.getConteudo() + " inserido na árvore binária com sucesso!");
        } else {
            inserirRecursivo(novoNo, aux);
        }
    }

    private void inserirRecursivo(No novoNo, No aux) {
        if (aux.getConteudo() > novoNo.getConteudo()) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido na árvore binária com sucesso!");
            } else {
                aux = aux.getEsquerda();
                inserirRecursivo(novoNo, aux);
            }
        } else if (aux.getConteudo() < novoNo.getConteudo()) {
            if (aux.getDireita() == null) {
                aux.setDireita(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido na árvore binária com sucesso!");
            } else {
                aux = aux.getDireita();
                inserirRecursivo(novoNo, aux);
            }
        } else {
            System.out.println("O nó " + aux.getConteudo() + " já está presente na árvore!");
        }
    }

    private boolean estaVazia() {
        if (raiz != null) {
            return false;
        } else {
            return true;
        }
    }

    public void percurso(String percurso) {
        if (estaVazia()) {
            System.out.println("A árvore não existe.");
            return;
        }

        switch (percurso) {
            case ("Pre"):
                System.out.println("\n---Executando a árvore em pré-ordem---");
                this.preOrdem(this.raiz);
                break;
            case ("Em"):
                System.out.println("\n---Executando a árvore em-ordem---");
                this.emOrdem(this.raiz);
                break;
            case ("Pos"):
                System.out.println("\n---Executando a árvore em pós ordem---");
                this.posOrdem(this.raiz);
                break;
            default:
                System.out.println("Percurso inexistente!");
                break;

        }
    }

    private void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    private void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    public void remover(int conteudo) {
        No aux = raiz;
        // vou verificar se a árvore existe
        if (!estaVazia()) {
            raiz = removerRecursivamente(conteudo, aux);
        } else {
            System.out.println("Não é possível remover. Lista vazia!");
        }
    }

    private No removerRecursivamente(int conteudo, No aux) {
        if (aux == null) {
            System.out.println("Elemento não encontrado na lista");
            return null;
        } else if (conteudo > aux.getConteudo()) {
            // vai definir a direita pela recursão
            aux.setDireita(removerRecursivamente(conteudo, aux.getDireita()));
        } else if (conteudo < aux.getConteudo()) {
            aux.setEsquerda(removerRecursivamente(conteudo, aux.getEsquerda()));
        } else {
            System.out.println("Elemento " + aux.getConteudo() + " encontrado!");
            System.out.println("Nó removido com sucesso!");

            // Conferir se não tem filho
            if (aux.getEsquerda() == null && aux.getDireita() == null) {
                //retorna nulo o apontamento
                return null;
            } else if (aux.getEsquerda() == null || aux.getDireita() == null) {
                // se o filho da esquerda existir
                if (aux.getEsquerda() != null) {
                    // Nó a esquerda vai substituir o lugar do aux
                    return aux.getEsquerda();
                } else if (aux.getDireita() != null) {
                    // Nó a direita vai substituir o lugar do aux
                    return aux.getDireita();
                }
            } else if (aux.getEsquerda() != null && aux.getDireita() != null) {
                No noSucessor = encontrarSucessor(aux.getDireita());
                System.out.println("Substituindo nó pelo seu sucessor: " + noSucessor.getConteudo());
                aux.setConteudo(noSucessor.getConteudo());
                aux.setDireita(removerRecursivamente(noSucessor.getConteudo(), aux.getDireita()));
                return aux;
            }
        }
        // retorna a raiz
        return aux;
    }

    private No encontrarSucessor(No auxSucessor) {
        if (auxSucessor.getEsquerda() != null) {
            auxSucessor = encontrarSucessor(auxSucessor.getEsquerda());
        }
        return auxSucessor;
    }

}
