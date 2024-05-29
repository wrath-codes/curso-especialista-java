# Duplicando classes e isolando os comportamentos

- ## Conceito

  - Duplicar classes é uma técnica utilizada para isolar comportamentos específicos em classes separadas.
  - As classes duplicadas são utilizadas para representar comportamentos específicos que podem ser reutilizados em diferentes contextos.
  - As classes duplicadas são utilizadas para evitar a duplicação de código e facilitar a manutenção do sistema.

- ## Exemplo da Conta usando duplicação de classes

- ### Conta.java

  ```java

  package codes.wrath.banco;

  public class Conta {

      private Titular titular;
      private int agencia;
      private int numero;
      private double saldo;

      public Titular getTitular() {
          return titular;
      }

      public void setTitular(Titular titular) {
          this.titular = titular;
      }

      public int getAgencia() {
          return agencia;
      }

      public void setAgencia(int agencia) {
          this.agencia = agencia;
      }

      public int getNumero() {
          return numero;
      }

      public void setNumero(int numero) {
          this.numero = numero;
      }

      public double getSaldo() {
          return saldo;
      }

      public void sacar(double valorSaque) {
          if (valorSaque <= 0) {
              throw new IllegalArgumentException("Valor do saque deve ser maior que 0");
          }

          if (saldo < valorSaque) {
              throw new RuntimeException("Saldo insuficiente para saque");
          }

          saldo -= valorSaque;
      }

      public void depositar(double valorDeposito) {
          if (valorDeposito <= 0) {
              throw new IllegalArgumentException("Valor do depósito deve ser maior que 0");
          }

          saldo += valorDeposito;
      }

      public void imprimirDemonstrativo() {
          System.out.println();
          System.out.printf("Agência: %d%n", getAgencia());
          System.out.printf("Conta: %d%n", getNumero());
          System.out.printf("Titular: %s%n", getTitular().getNome());
          System.out.printf("Saldo: %.2f%n", getSaldo());
      }
  }
  ```
  
- ### ContaInvestimento.java

  ```java
  
    package codes.wrath.banco;

    public class ContaInvestimento {

        private Titular titular;
        private int agencia;
        private int numero;
        private double saldo;

        private double valorTotalRendimentos;

        public Titular getTitular() {
            return titular;
        }

        public void setTitular(Titular titular) {
            this.titular = titular;
        }

        public int getAgencia() {
            return agencia;
        }

        public void setAgencia(int agencia) {
            this.agencia = agencia;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public double getValorTotalRendimentos() {
            return valorTotalRendimentos;
        }

        public void sacar(double valorSaque) {
            if (valorSaque <= 0) {
                throw new IllegalArgumentException("Valor do saque deve ser maior que 0");
            }

            if (saldo < valorSaque) {
                throw new RuntimeException("Saldo insuficiente para saque");
            }

            saldo -= valorSaque;
        }

        public void depositar(double valorDeposito) {
            if (valorDeposito <= 0) {
                throw new IllegalArgumentException("Valor do depósito deve ser maior que 0");
            }

            saldo += valorDeposito;
        }

        public void creditarRendimentos(double percentualJuros) {
            double rendimentos = getSaldo() * percentualJuros / 100;
            this.valorTotalRendimentos += rendimentos;
            depositar(rendimentos);
        }

        public void imprimirDemonstrativo() {
            System.out.println();
            System.out.printf("Agência: %d%n", getAgencia());
            System.out.printf("Conta: %d%n", getNumero());
            System.out.printf("Titular: %s%n", getTitular().getNome());
            System.out.printf("Saldo: %.2f%n", getSaldo());
        }

    }
  ```

- ### ContaEspecial.java

  ```java

    package codes.wrath.banco;

    public class ContaEspecial {

        private Titular titular;
        private int agencia;
        private int numero;
        private double saldo;

        private double valorTotalRendimentos;
        private double limiteChequeEspecial;
        private double tarifaMensal;

        public Titular getTitular() {
            return titular;
        }

        public void setTitular(Titular titular) {
            this.titular = titular;
        }

        public int getAgencia() {
            return agencia;
        }

        public void setAgencia(int agencia) {
            this.agencia = agencia;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public double getSaldoDisponivel() {
            return saldo + limiteChequeEspecial;
        }

        public double getValorTotalRendimentos() {
            return valorTotalRendimentos;
        }

        public double getLimiteChequeEspecial() {
            return limiteChequeEspecial;
        }

        public void setLimiteChequeEspecial(double limiteChequeEspecial) {
            this.limiteChequeEspecial = limiteChequeEspecial;
        }

        public double getTarifaMensal() {
            return tarifaMensal;
        }

        public void setTarifaMensal(double tarifaMensal) {
            this.tarifaMensal = tarifaMensal;
        }

        public void sacar(double valorSaque) {
            if (valorSaque <= 0) {
                throw new IllegalArgumentException("Valor do saque deve ser maior que 0");
            }

            if (getSaldoDisponivel() < valorSaque) {
                throw new RuntimeException("Saldo insuficiente para saque");
            }

            saldo -= valorSaque;
        }

        public void depositar(double valorDeposito) {
            if (valorDeposito <= 0) {
                throw new IllegalArgumentException("Valor do depósito deve ser maior que 0");
            }

            saldo += valorDeposito;
        }

        public void creditarRendimentos(double percentualJuros) {
            double rendimentos = getSaldo() * percentualJuros / 100;
            this.valorTotalRendimentos += rendimentos;
            depositar(rendimentos);
        }

        public void debitarTarifaMensal() {
            if (getSaldoDisponivel() < tarifaMensal) {
                throw new RuntimeException("Saldo insuficiente para debitar tarifa mensal");
            }
            sacar(tarifaMensal);
        }

        public void imprimirDemonstrativo() {
            System.out.println();
            System.out.printf("Agência: %d%n", getAgencia());
            System.out.printf("Conta: %d%n", getNumero());
            System.out.printf("Titular: %s%n", getTitular().getNome());
            System.out.printf("Saldo: %.2f%n", getSaldo());
            System.out.println("Saldo disponível: " + getSaldoDisponivel());
        }

    }
    ```
  
- ## Conclusões  

  - A duplicação de classes é uma técnica que permite isolar comportamentos específicos em classes separadas, porem, ela pode gerar um grande número de códigos duplicados.

[Pagina Anterior: Tagged Classes](heranca-tagged-classes.md) [Sumario](sumario.md) | [Proxima Pagina: Herança e o relacionamento no diagrama de classes](heranca-relacionamento-diagrama.md)
