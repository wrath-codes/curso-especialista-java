# Herança: Metodos Protected

- ## Conceito

  - O modificador de acesso `protected` é utilizado para permitir que os métodos de uma classe sejam acessados pelas classes filhas.
  - Os métodos com o modificador `protected` podem ser acessados pelas classes filhas, mas não podem ser acessados por classes que não sejam filhas da classe que contém o método.
  - O modificador `protected` é utilizado para garantir o encapsulamento dos métodos, permitindo que eles sejam acessados apenas pelas classes filhas.

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

        protected void validarSaldoParaSaque(double valorSaque) {
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

        protected void validarSaldoParaSaque(double valorSaque) {
            if (getSaldoDisponivel() < valorSaque) {
                throw new RuntimeException("Saldo insuficiente para saque");
            }
        }

        public void debitarTarifaMensal() {
            sacar(tarifaMensal);
        }

        public void imprimirDemonstrativo() {
            super.imprimirDemonstrativo();
            System.out.printf("Saldo disponível: %.2f%n", getSaldoDisponivel());
        }

    }
    ```

[Pagina Anterior: Métodos Protected](heranca-metodos-protected.md)   [Sumario](sumario.md) | [Proxima Pagina: Herança: Override](heranca-override.md)
