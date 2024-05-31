package codes.wrath.banco;

public class ContaEspecial extends ContaInvestimento {

    private double limiteChequeEspecial;
    private double tarifaMensal;

    public ContaEspecial(Titular titular, int agencia, int numero, double tarifaMensal) {
        super(titular, agencia, numero);
        this.tarifaMensal = tarifaMensal;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public double getSaldoDisponivel() {
        return getSaldo() + limiteChequeEspecial;
    }

    @Override
    protected final void validarSaldoParaSaque(double valorSaque) {
        if (getSaldoDisponivel() < valorSaque) {
            throw new RuntimeException("Saldo insuficiente para saque");
        }
    }

    public void debitarTarifaMensal() {
        sacar(tarifaMensal);
    }

    @Override
    public void imprimirDemonstrativo() {
        super.imprimirDemonstrativo();
        System.out.printf("Saldo disponível: %.2f%n", getSaldoDisponivel());
    }

    @Override
    public String toString() {
        return String.format(
                "ContaEspecial(titular=%s, agencia=%d, numero=%d, rendimentos=%.2f, chequeEspecias=%.2f, tarifaMensal=%.2f)",
                getTitular().getNome(), getAgencia(),
                getNumero(), getValorTotalRendimentos(), getLimiteChequeEspecial(), getTarifaMensal());
    }

}
