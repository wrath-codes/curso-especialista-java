
import codes.wrath.banco.ContaInvestimento;
import codes.wrath.banco.Titular;

public class Main2 {

    public static void main(String[] args) {
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        contaInvestimento.setTitular(new Titular("João da Silva", "12312312300"));
        contaInvestimento.setAgencia(1234);
        contaInvestimento.setNumero(999999);

        contaInvestimento.imprimirDemonstrativo();

        contaInvestimento.depositar(100);
        contaInvestimento.imprimirDemonstrativo();

        // conta1.sacar(27.5);
        // conta1.imprimirDemonstrativo();

        contaInvestimento.creditarRendimentos(6);
        contaInvestimento.imprimirDemonstrativo();
    }

}
