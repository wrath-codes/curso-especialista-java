# Herança: Method Override

- ## Conceito

  - O método `override` é uma técnica utilizada para substituir a implementação de um método de uma superclasse na subclasse.

  - O método `override` é utilizado para alterar o comportamento de um método herdado, sem alterar a sua assinatura.

  - O método `override` é uma forma de reutilização de código, pois permite que a subclasse utilize a implementação do método da superclasse, mas com um comportamento diferente.

- ## Exemplo

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

        public void validarSaldoParaSaque(double valorSaque) {
            if (getSaldo() < valorSaque) {
                throw new RuntimeException("Saldo insuficiente para saque");
            }
        }

        public void sacar(double valorSaque) {
            if (valorSaque <= 0) {
                throw new IllegalArgumentException("Valor do saque deve ser maior que 0");
            }

            validarSaldoParaSaque(valorSaque);

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

- ### ContaEspecial.java

    ```java
    
    package codes.wrath.banco;

    public class ContaEspecial extends ContaInvestimento {

        private double limiteChequeEspecial;
        private double tarifaMensal;

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

        public double getSaldoDisponivel() {
            return getSaldo() + limiteChequeEspecial;
        }

        @Override
        public void validarSaldoParaSaque(double valorSaque) {
            if (getSaldoDisponivel() < valorSaque) {
                throw new RuntimeException("Saldo insuficiente para saque");
            }
        }

        public void debitarTarifaMensal() {
            sacar(tarifaMensal);
        }

        @Override
        public void imprimirDemonstrativo() {
            System.out.println();
            System.out.printf("Agência: %d%n", getAgencia());
            System.out.printf("Conta: %d%n", getNumero());
            System.out.printf("Titular: %s%n", getTitular().getNome());
            System.out.printf("Saldo: %.2f%n", getSaldo());
            System.out.printf("Saldo disponível: %.2f%n", getSaldoDisponivel());
        }

    }
    ```

[Pagina Anterior: Métodos Protected](heranca-metodos-protected.md) [Sumario](sumario.md) | [Proxima Pagina: Superclasse](heranca-superclasse.md)
