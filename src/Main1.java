import codes.wrath.banco.Conta;
import codes.wrath.banco.Titular;

public class Main1 {

    public static void main(String[] args) {
        Titular titular = new Titular("João da Silva", "12312312300");
        Conta contaNormal = new Conta(titular, 1234, 999999);

        contaNormal.imprimirDemonstrativo();

        contaNormal.depositar(100);
        contaNormal.imprimirDemonstrativo();

        contaNormal.sacar(27.5);
        contaNormal.imprimirDemonstrativo();
    }
}
