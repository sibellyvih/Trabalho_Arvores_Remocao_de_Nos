//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

    arvoreBinaria.inserir(9);
    arvoreBinaria.inserir(14);
    arvoreBinaria.inserir(99);
    arvoreBinaria.inserir(88);
    arvoreBinaria.inserir(-75);
    arvoreBinaria.inserir(-7);
    arvoreBinaria.inserir(20);

    arvoreBinaria.percurso("Pre");

    System.out.println("  \n \n \n");

    arvoreBinaria.remover(9);
    arvoreBinaria.remover(-7);
    arvoreBinaria.remover(20);
    arvoreBinaria.remover(777);
    arvoreBinaria.remover(33);

}
