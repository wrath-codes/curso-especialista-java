import codes.wrath.banco.ContaEspecial;
import codes.wrath.banco.Titular;

public class Main3 {

    public static void main(String[] args) {
        ContaEspecial contaEspecial = new ContaEspecial(new Titular("João da Silva", "12312312300"), 1234, 999999, 90);
        contaEspecial.setLimiteChequeEspecial(1000);

        contaEspecial.imprimirDemonstrativo();

        contaEspecial.depositar(100);
        contaEspecial.imprimirDemonstrativo();

        contaEspecial.sacar(27.5);
        contaEspecial.imprimirDemonstrativo();

        contaEspecial.creditarRendimentos(6);
        contaEspecial.imprimirDemonstrativo();

        contaEspecial.sacar(300);
        contaEspecial.imprimirDemonstrativo();

        contaEspecial.debitarTarifaMensal();
        contaEspecial.imprimirDemonstrativo();
    }
}
