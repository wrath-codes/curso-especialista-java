# Classes Etiquetadas (Tagged Classes)

- ## Conceito

  - Classes etiquetadas são classes que possuem uma ou mais tags associadas a elas.
  - As tags são utilizadas para identificar a classe como um tipo específico.
  - As classes etiquetadas são utilizadas para representar tipos de dados que possuem características em comum.

- ## Exemplo

  - Considere o exemplo de uma classe `Animal` que possui um atributo `tipo` para identificar o tipo de animal.
  - A classe `Animal` é uma classe etiquetada, pois possui uma tag associada a ela.
  - A tag `tipo` é utilizada para identificar o tipo de animal, por exemplo: `cachorro`, `gato`, `pássaro`, etc.

    ```java
    public class Animal {
        private String tipo;
        private String nome;
        private int idade;
        
        public Animal(String tipo, String nome, int idade) {
            this.tipo = tipo;
            this.nome = nome;
            this.idade = idade;
        }
        
        public String getTipo() {
            return tipo;
        }
        
        public String getNome() {
            return nome;
        }
        
        public int getIdade() {
            return idade;
        }
    }
    ```

    - A classe `Animal` é uma classe etiquetada, pois possui uma tag `tipo` associada a ela.

- ## Exemplo da Conta usando classes etiquetadas

    ```java
    
    package codes.wrath.banco;

    public class Conta {

        private Titular titular;
        private int agencia;
        private int numero;
        private double saldo;
        private TipoConta tipo;

        // conta investimento
        private double valorTotalRendimentos;

        // conta especial
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
            if (tipo == TipoConta.ESPECIAL) {
                return saldo + limiteChequeEspecial;
            }
            return saldo;
        }

        public TipoConta getTipo() {
            return tipo;
        }

        public void setTipo(TipoConta tipo) {
            if (tipo == null) {
                throw new IllegalArgumentException("Tipo de conta inválido: null");
            }
            if (tipo != TipoConta.NORMAL && tipo != TipoConta.INVESTIMENTO && tipo != TipoConta.ESPECIAL) {
                throw new IllegalArgumentException("Tipo de conta inválido: " + tipo.toString());
            }

            this.tipo = tipo;
        }

        public double getValorTotalRendimentos() {
            return valorTotalRendimentos;
        }

        public double getLimiteChequeEspecial() {
            return limiteChequeEspecial;
        }

        public void setLimiteChequeEspecial(double limiteChequeEspecial) {
            if (this.tipo != TipoConta.ESPECIAL) {
                throw new RuntimeException(
                        "Esta conta não permite limite de cheque especial. Tipo da conta: " + this.tipo.toString());
            }

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

            if (saldo < valorSaque && tipo != TipoConta.ESPECIAL) {
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
            if (getTipo() == TipoConta.INVESTIMENTO || getTipo() == TipoConta.ESPECIAL) {
                double rendimentos = getSaldo() * percentualJuros / 100;
                this.valorTotalRendimentos += rendimentos;
                depositar(rendimentos);
            } else {
                throw new RuntimeException(
                        "Não é possível creditar rendimentos neste tipo de conta. Conta do tipo: " + getTipo().toString());
            }
        }

        public void debitarTarifaMensal() {
            if (getTipo() == TipoConta.ESPECIAL) {
                if (getSaldoDisponivel() < tarifaMensal) {
                    throw new RuntimeException("Saldo insuficiente para debitar tarifa mensal");
                }
                sacar(tarifaMensal);
            } else {
                throw new RuntimeException(
                        "Não é possível debitar tarifa mensal neste tipo de conta. Conta do tipo: " + getTipo().toString());
            }
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

- ## Observações

  - As classes etiquetadas são verbosas e podem ser difíceis de manter.
  - as classes etiquetadas são propensas a erros, pois dependem de strings para identificar o tipo de dados.

[Pagina Anterior](heranca.md)  [Sumario](sumario.md) | [Proxima Pagina: Duplicando classes e isolando os comportamentos](heranca-duplicando-classes.md)
