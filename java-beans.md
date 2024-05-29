# Java Beans

- **Conceito**

  - **Java Beans** é uma especificação da Sun Microsystems que define um conjunto de **regras** para a criação de **componentes reutilizáveis** em Java. Um **Java Bean** é uma classe Java que segue as seguintes regras:

    - Possui um **construtor padrão** sem argumentos.

    - Possui **atributos privados** com métodos **getters** e **setters**.

    - Possui **métodos** que seguem o padrão **get** e **set** para acessar e modificar os atributos.

    - Implementa a interface **Serializable** para permitir a **serialização** dos objetos.

    - Possui um **método toString()** para retornar uma **representação textual** do objeto.

    - Possui **eventos** que podem ser **observados** por outros objetos.
  
    - **Componentes reutilizáveis** são classes que podem ser **facilmente integradas** em diferentes aplicações, sem a necessidade de alterações no código-fonte. Um **Java Bean** é um componente reutilizável que pode ser **arrastado e solto** em um ambiente de desenvolvimento visual, como o **NetBeans** ou o **Eclipse**.

- **Exemplo**
  
  - Voltando ao exemplo apresentado na seção de **[Encapsulamento](encapsulamento)**, a classe `Cartao` pode ser considerada um **Java Bean**, pois possui um **construtor padrão**, **atributos privados** com **getters** e **setters**, **métodos** para acessar e modificar os atributos, **implementação da interface Serializable** e **método toString()**.

- **Cartao.java**

```java
import java.io.Serializable;

public class Cartao implements Serializable {
      public static final double TARIFA_DEPOSITO = 0.1;
      public static final double VALOR_MINIMO_DEPOSITO = 50.0;
      
      private String titular;
      private double saldo;
      private boolean ativo;
      
      public Cartao(){}

      public Cartao(String titular) {
            this.titular = titular;
      }
      
      public boolean isAtivo() {
            return ativo;
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

- Acima, a classe `Cartao` possui um **construtor padrão** sem argumentos, **atributos privados** com métodos **getters** e **setters**, **métodos** para acessar e modificar os atributos, **implementação da interface Serializable** e **método toString()**.

- Desafio Java Beans

  - Dado o seguinte dagrama de classes, implemente as classes `ContaPagar` e `Fornecedor` como **Java Beans**.

    ```mermaid
    classDiagram
    class ContaPagar {
      - descricao: String
      - valor: double
      - dataVencimento: LocalDate
      - pago: boolean
        + pagar() void
        + cancelar() void
    }
    
    class Fornecedor {
      - nome: String
        + Fornecedor()
        + Fornecedor(nome: String)

    }
    
    ContaPagar "1" --> "1" Fornecedor : -fornecedor
    ```

    - O `Main` à seguir deve funcionar sem erros:

    ```java
    public class Principal {
        public static void main(String[] args) {
            Fornecedor imobiliaria = new Fornecedor("Zé Negócios Imobiliários");

            ContaPagar contaAluguel = new ContaPagar();
            contaAluguel.setDescricao("Aluguel do apartamento");
            contaAluguel.setValor(4500);
            contaAluguel.setDataVencimento("10/07/2022");
            contaAluguel.setFornecedor(imobiliaria);

            imprimirConta(contaAluguel);

            contaAluguel.pagar();
            imprimirConta(contaAluguel);

            // Pagar a mesma conta novamente deve ser impedido
            contaAluguel.pagar();

            contaAluguel.cancelarPagamento();
            imprimirConta(contaAluguel);

            // Cancelar o pagamento de uma conta pendente deve ser impedido
            contaAluguel.cancelarPagamento();
        }

        public static void imprimirConta(ContaPagar conta) {
            System.out.printf("Fornecedor: %s%n", conta.getFornecedor().getNome());
            System.out.printf("Descrição: %s%n", conta.getDescricao());
            System.out.printf("Data de vencimento: %s%n", conta.getDataVencimento());
            System.out.printf("Valor: R$%.2f%n", conta.getValor());
            System.out.printf("Pago: %s%n", conta.isPago() ? "Sim" : "Não");
            System.out.println();
        }
    }
    ```

    - **Solução**

    - **Fornecedor.java**

    ```java
    public class Fornecedor {
        private String nome;

        public Fornecedor() {}

        public Fornecedor(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    ```

    - **ContaPagar.java**

    ```java
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    public class ContaPagar {
        private String descricao;
        private double valor;
        private LocalDate dataVencimento;
        private boolean pago;
        private Fornecedor fornecedor;

        public ContaPagar() {}

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getDataVencimento() {
            return dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        public void setDataVencimento(String dataVencimento) {
            this.dataVencimento = LocalDate.parse(dataVencimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        public boolean isPago() {
            return pago;
        }

        public void pagar() {
            if (isPago()) {
                throw new RuntimeException("Conta já foi paga");
            }

            pago = true;
        }

        public void cancelarPagamento() {
            if (!isPago()) {
                throw new RuntimeException("Conta ainda não foi paga");
            }

            pago = false;
        }

        public Fornecedor getFornecedor() {
            return fornecedor;
        }

        public void setFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
        }
    }
    ```

[Sumário](sumario.md) | [Anterior](encapsulamento.md) | [Próximo](encapsulamento-boas-praticas.md)
| [Topo](#java-beans)
