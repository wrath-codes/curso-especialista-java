# Polimorfismo e Classes Abstratas

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

- ## Upcasting de referencias

  - Upcasting é a conversão de uma referência de um tipo mais específico para um tipo mais genérico.
  - Upcasting é feito de forma automática e implícita.
  - Upcasting é feito de forma segura, pois o objeto referenciado é do tipo mais específico.

    ```java
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

    public class ContaInvestimento extends Conta {
        private double valorTotalRendimentos;
        
        public ContaInvestimento() {
            super(0);
        }
        
        public void calcularRendimentos(double taxa) {
            this.valorTotalRendimentos = this.saldo * taxa;
        }
    }

    public class ProgramaPrincipal {
        public static void main(String[] args) {
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.depositar(1000);
            contaInvestimento.calcularRendimentos(0.1);

            // Upcasting Explícito
            Conta conta = (Conta) contaInvestimento;
            
            // Upcasting Implícito
            Conta conta2 = contaInvestimento;
            
        }
    }
    ```

- ## O problema que o polimorfismo resolve

  - O polimorfismo resolve o problema de ter que criar um método para cada tipo de conta.

  - O polimorfismo resolve o problema de ter que criar um método para cada tipo de conta em cada classe que precisa usar o método.
  
- ## Entendendo Polimorfismo

  - A capacidade de um objeto de assumir diferentes formas, dele ser enxergado de diferentes maneiras.
  
  - Exemplo:

  ```java

    package codes.wrath.banco;

    public class CaixaEletronico {

        public static final double TARIFA_TRANSFERENCIA = 10;

        public void transferir(Conta contaOrigem, Conta contaDestino,
                double valorTransferencia) {
            System.out.printf("Transferindo R$%.2f da conta %d/%d para %d/%d%n",
                    valorTransferencia, contaOrigem.getAgencia(), contaOrigem.getNumero(),
                    contaDestino.getAgencia(), contaDestino.getNumero());

            contaOrigem.sacar(valorTransferencia + TARIFA_TRANSFERENCIA);
            contaDestino.depositar(valorTransferencia);
        }

    }

    ```

- ## Downcasting de referencias

  - Downcasting é a conversão de uma referência de um tipo mais genérico para um tipo mais específico.
  - Downcasting é feito de forma explícita.
  - Downcasting é feito de forma insegura, pois o objeto referenciado pode não ser do tipo mais específico.
  - Downcasting deve ser feito com cuidado, pois pode lançar uma exceção ClassCastException, deve ser evitado.

    ```java
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

    public class ContaInvestimento extends Conta {
        private double valorTotalRendimentos;
        
        public ContaInvestimento() {
            super(0);
        }
        
        public void calcularRendimentos(double taxa) {
            this.valorTotalRendimentos = this.saldo * taxa;
        }
    }

    public class ProgramaPrincipal {
        public static void main(String[] args) {
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.depositar(1000);
            contaInvestimento.calcularRendimentos(0.1);

            // Downcasting
            Conta conta = contaInvestimento;
            ContaInvestimento contaInvestimento2 = (ContaInvestimento) conta;
        }
    }
    ```

- ## instanceof

  - instanceof é um operador que verifica se um objeto é uma instância de uma classe ou de uma subclasse, ou de uma interface, ou de uma superclasse.
  - instanceof é um operador que retorna true se o objeto é uma instância de uma classe ou de uma subclasse, ou de uma interface, ou de uma superclasse.
  - instanceof é um operador que retorna false se o objeto não é uma instância de uma classe ou de uma subclasse, ou de uma interface, ou de uma superclasse.
  - instanceof é um operador que retorna false se o objeto é null.

    ```java
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
    

    public class ContaInvestimento extends Conta {
        private double valorTotalRendimentos;
        
        public ContaInvestimento() {
            super(0);
        }
        
        public void calcularRendimentos(double taxa) {
            this.valorTotalRendimentos = this.saldo * taxa;
        }
    }

    public class ProgramaPrincipal {
        public static void main(String[] args) {
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.depositar(1000);
            contaInvestimento.calcularRendimentos(0.1);

            Conta conta = contaInvestimento;
            if (conta instanceof ContaInvestimento) {
                ContaInvestimento contaInvestimento2 = (ContaInvestimento) conta;
            }
        }
    }
    ```

- ## Coesão

- ### Conceito

  - Coesão é o grau de relacionamento entre os membros de uma classe.
  - Coesão é o grau de relacionamento entre os membros de uma classe com o objetivo de realizar uma única tarefa.
  - O principio da responsabilidade única é um dos princípios da coesão. Criado por Robert C. Martin(Uncle Bob).

- ### Exemplo

        ```java
        public class Programa {
            public void ExibirFormulario() {
                // Código para exibir o formulário
            }

            public void ObterProduto() {
                // Código para obter o produto
            }

            public void SalvarProdutoDB() {
                // Código para salvar o produto
            }
        }
        
        // Refatoração
        public class Programa {
            public void ExibirFormulario() {
                // Código para exibir o formulário
            }

            public void SalvarProdutoDB() {
                Produto.savarDB();
            }
        }
        ```

- ### Exemplo de Coesão

    ```java
    public class Formulario {
        public void Exibir() {
            // Código para exibir o formulário
        }

        public void Obter() {
            // Código para obter o produto
        }

        public void Salvar() {
            // Código para salvar o produto
        }
    }
    ```

- ### Exemplo de Falta de Coesão

    ```java
    public class Formulario {
        public void Exibir() {
            // Código para exibir o formulário
        }

        public void Obter() {
            // Código para obter o produto
        }

        public void Salvar() {
            // Código para salvar o produto
        }

        public void EnviarEmail() {
            // Código para enviar email
        }

        public void EnviarSMS() {
            // Código para enviar SMS
        }
    }
    ```

- ## Acoplamento

  - **Conceito**

  - Acoplamento é o grau de relacionamento entre as classes.
  - Acoplamento é o grau de relacionamento entre as classes com o objetivo de realizar uma única tarefa.
  - O principio do baixo acoplamento é um dos princípios do acoplamento. Criado por Robert C. Martin(Uncle Bob).

  - **Exemplo**

    ```java
    public class Programa {
        public void ExibirFormulario() {
            Formulario formulario = new Formulario();
            formulario.Exibir();
        }
    }
    ```

- ### Exemplo de Acoplamento

    ```java
    public class Programa {
        public void ExibirFormulario() {
            Formulario formulario = new Formulario();
            formulario.Exibir();
            formulario.Obter();
            formulario.Salvar();
        }
    }
    ```

- ### Exemplo de Falta de Acoplamento

    ```java
    public class Programa {
        public void ExibirFormulario() {
            Formulario formulario = new Formulario();
            formulario.Exibir();
            Produto produto = new Produto();
            produto.Obter();
            produto.Salvar();
        }
    }
    ```
