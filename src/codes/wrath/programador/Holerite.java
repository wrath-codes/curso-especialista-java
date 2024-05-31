package codes.wrath.programador;

public record Holerite(String nome, String mesAno, double valorSalario) {

    public void imprimir() {
        System.out.println("Nome: %s".formatted(nome));
        System.out.println("Mês/Ano: %s".formatted(mesAno));
        System.out.println("Salário: %.2f".formatted(valorSalario));
    }

}
