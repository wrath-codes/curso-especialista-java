package codes.wrath.banco;

public class ContaInvestimento extends Conta {

    private double valorTotalRendimentos;

    public ContaInvestimento(Titular titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

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

    @Override
    public String toString() {
        return String.format("ContaInvestimento(titular=%s, agencia=%d, numero=%d, rendimentos=%.2f)",
                getTitular().getNome(),
                getAgencia(),
                getNumero(), getValorTotalRendimentos());
    }

}
