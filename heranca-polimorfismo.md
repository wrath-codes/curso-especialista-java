# Herança: Polimorfismo

- ## Conceito

  - Polimorfismo é a capacidade de um objeto de assumir diferentes formas.
  - Polimorfismo é a capacidade de um objeto de ser referenciado por um tipo mais genérico.
  - Polimorfismo é a capacidade de um objeto de ser referenciado por um tipo mais específico.
  - Polimorfismo é a capacidade de um objeto de ser referenciado por um tipo mais genérico e mais específico.
  - Polimorfismo é a capacidade de um objeto de ser referenciado por um tipo mais genérico e mais específico em momentos diferentes.
  - Polimorfismo é a capacidade de um objeto de ser referenciado por um tipo mais genérico e mais específico em momentos diferentes, sem alterar o código fonte.

  - Exemplo de uso do polimorfismo:

    ```java
    // Superclasse
    public class Conta {
        private double saldo;
        
        public Conta(double saldoInicial) {
            this.saldo = saldoInicial;
        }
        
        public void depositar(double valor) {
            this.saldo += valor;
        }
        
        public void sacar(double valor) {
            this.saldo -= valor;
        }
    }

    // Subclasse
    public class ContaInvestimento extends Conta {
        private double valorTotalRendimentos;
        
        public ContaInvestimento() {
            super(0);
        }
        
        public void calcularRendimentos(double taxa) {
            this.valorTotalRendimentos = this.saldo * taxa;
        }
    }

    // Subclasse de ContaInvestimento
    public class ContaEspecial extends ContaInvestimento {
        private double limite;
        
        public ContaEspecial() {
            super();
        }
        
        public void setLimite(double limite) {
            this.limite = limite;
        }
    }


    // Programa Principal
    public class ProgramaPrincipal {
        public static void main(String[] args) {
            Conta conta = new Conta(1000);
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            ContaEspecial contaEspecial = new ContaEspecial();
            
            conta.depositar(500);
            conta.sacar(200);
            
            contaInvestimento.depositar(500);
            contaInvestimento.sacar(200);
            contaInvestimento.calcularRendimentos(0.1);
            
            contaEspecial.depositar(500);
            contaEspecial.sacar(200);
            contaEspecial.calcularRendimentos(0.1);
            contaEspecial.setLimite(1000);
        }
    }
    ```
