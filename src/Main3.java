import codes.wrath.banco.ContaEspecial;
import codes.wrath.banco.Titular;

public class Main3 {

    public static void main(String[] args) {
        ContaEspecial contaEspecial = new ContaEspecial();
        contaEspecial.setTitular(new Titular("João da Silva", "12312312300"));
        contaEspecial.setAgencia(1234);
        contaEspecial.setNumero(999999);
        contaEspecial.setLimiteChequeEspecial(1000);
        contaEspecial.setTarifaMensal(90);

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
