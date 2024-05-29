import codes.wrath.banco.Conta;
import codes.wrath.banco.Titular;

public class Main1 {

    public static void main(String[] args) {
        Conta contaNormal = new Conta();
        contaNormal.setTitular(new Titular("João da Silva", "12312312300"));
        contaNormal.setAgencia(1234);
        contaNormal.setNumero(999999);

        contaNormal.imprimirDemonstrativo();

        contaNormal.depositar(100);
        contaNormal.imprimirDemonstrativo();

        contaNormal.sacar(27.5);
        contaNormal.imprimirDemonstrativo();
    }

}
