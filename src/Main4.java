
import codes.wrath.banco.ContaEspecial;
import codes.wrath.banco.Titular;

public class Main4 {

    public static void main(String[] args) {
        Titular titular = new Titular("João da Silva", "12312312300");
        ContaEspecial contaEspecial = new ContaEspecial(titular, 1234, 999999, 90);

        System.out.println(contaEspecial.toString());
    }
}
