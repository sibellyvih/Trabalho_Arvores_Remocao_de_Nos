//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

    arvoreBinaria.inserir(9);
    arvoreBinaria.inserir(14);
    arvoreBinaria.inserir(-75);
    arvoreBinaria.inserir(10);

    arvoreBinaria.percurso("Pre");

    System.out.println("  \n \n \n");

    arvoreBinaria.remover(9);
    arvoreBinaria.percurso("Pre");
    arvoreBinaria.percurso("Em");
    arvoreBinaria.percurso("Pos");
}
