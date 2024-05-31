# Herança: Construtor da Superclasse

- ## Conceito

  - A palavra-chave `super` é utilizada para acessar o construtor da superclasse.
  - A palavra-chave `super` é utilizada para acessar métodos e atributos da superclasse.

  - Exemplo de uso da palavra-chave `super` para acessar o construtor da superclasse:

    ```java
    // Superclasse
    public class Conta {
        private double saldo;
        
        public Conta(double saldoInicial) {
            this.saldo = saldoInicial;
        }
    }

    // Subclasse
    public class ContaInvestimento extends Conta {
        private double valorTotalRendimentos;
        
        public ContaInvestimento() {
            super(0);
        }
    }
    
    // Subclasse de ContaInvestimento
    public class ContaEspecial extends ContaInvestimento {
        private double limite;
        
        public ContaEspecial() {
            super();
        }
    }
    ```

[Pagina Anterior](heranca-override.md)| [Sumario](sumario.md) | [Próxima Pagina](heranca-polimorfismo.md)
