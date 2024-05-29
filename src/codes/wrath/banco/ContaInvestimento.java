package codes.wrath.banco;

public class ContaInvestimento extends Conta {

    private double valorTotalRendimentos;

    public double getValorTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public void creditarRendimentos(double percentualJuros) {
        double rendimentos = getSaldo() * percentualJuros / 100;
        this.valorTotalRendimentos += rendimentos;
        depositar(rendimentos);
    }

    public void imprimirDemonstrativo() {
        super.imprimirDemonstrativo();
        System.out.printf("Rendimentos: %.2f%n", getValorTotalRendimentos());
    }
}
