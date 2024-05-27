
# Fundamentos da Programação Orientada a Objetos com Java

- ## Encapsulamento

  - **Conceito**

    - **Encapsulamento** é um dos pilares da programação orientada a objetos, que consiste em **esconder** os detalhes de implementação de um objeto, expondo apenas a **interface** de uso. O objetivo é **proteger** os atributos de um objeto, permitindo que eles sejam acessados e modificados apenas por métodos específicos.

    - **Interface** é o conjunto de métodos públicos de um objeto, que são acessíveis por outros objetos.

    - **Detalhes de implementação** são os atributos e métodos privados de um objeto, que não são acessíveis por outros objetos.

- ### Exemplo

#### Cartao.java

```java
public class Cartao {
      public static final double TARIFA_DEPOSITO = 0.1;
      public static final double VALOR_MINIMO_DEPOSITO = 50.0;
      
      private String titular;
      private double saldo;

      public Cartao(String titular) {
            this.titular = titular;
      }

      public String getTitular() {
            return titular;
      }

      public double getSaldo() {
            return saldo;
      }

      public void debitar(double valor){
            if(getSaldo() < valor){
                  throw new RuntimeException("Saldo insuficiente para pagamento");
            }
            
            saldo -= valor;
      }
      
      public void depositar(double valor){
            if(valor < VALOR_MINIMO_DEPOSITO){
                  throw new RuntimeException("Valor mínimo para depósito é de %.2f", VALOR_MINIMO_DEPOSITO);
            }
            
            saldo += valor - TARIFA_DEPOSITO;
      }
}

```

#### Estabelecimento.java

```java
public class Estabelecimento {
      private String nome;
      public double saldo;

      public Estabelecimento(String nome) {
            this.nome = nome;
      }
}
```

#### Recibo.java

```java
public class Recibo {
      public String titular;
      public String descricao;
      public double valor;
      
      public Recibo(String titular, String descricao, double valor) {
            this.titular = titular;
            this.descricao = descricao;
            this.valor = valor;
      }

      public void imprimir(){
            System.out.println("------------------");
            System.out.println("RECIBO PARA %s%n", titular);
            System.out.println("%s -> %.2f%n", descricao, valor);
            System.out.println("------------------");
      }
}
```

- **Vantagens do Encapsulamento**

  - **Segurança**: protege os atributos de um objeto, evitando que sejam acessados e modificados de forma indevida.

  - **Flexibilidade**: permite alterar a implementação interna de um objeto sem afetar os demais objetos que o utilizam.

  - **Reusabilidade**: facilita a reutilização de objetos em diferentes contextos, pois a interface de uso é independente dos detalhes de implementação.

  - **Exemplo**:

- #### Serviço de pagamento online que utiliza cartões de crédito e débito

- ##### ServicoDePagamentoOnline.java

```java
import com.exemplo.Cartao;
import com.exemplo.Estabelecimento;
import com.exemplo.Recibo;

public class ServicoDePagamentoOnline {
      public Recibo efetuarPagamento(Estabelecimento estabelecimento, Cartao cartao, double valor){
            cartao.debitar(valor);
            estabelecimento.saldo += valor;
            
            return new Recibo(cartao.getTitular(), estabelecimento.getNome(), "Pagamento online", valor);
      }
}
```

- #### Serviço de pagamento via PIX

- ##### ServicoDeDepositoPix.java

```java
import com.exemplo.cartao;
import com.exemplo.recibo;

public class servicodedepositopix {
public recibo efetuardeposito(cartao cartao, double valor){
cartao.depositar(valor);
      
      return new recibo(cartao.gettitular(), "depósito via pix", valor);
}
}

```

[Sumário](sumario.md) | [Próxima](java-beans.md) | [Topo](#fundamentos-da-programação-orientada-a-objetos-com-java)
