# Conhecendo o Diagrama de Herança e Relacionamento

- ## Conceito

  - O diagrama de herança e relacionamento é uma representação gráfica que mostra a relação entre as classes de um sistema orientado a objetos.

  - Ele é utilizado para visualizar a hierarquia de classes e os relacionamentos entre elas.

  - O diagrama de herança e relacionamento é uma ferramenta importante para o desenvolvimento de sistemas orientados a objetos, pois permite identificar a estrutura do sistema e as dependências entre as classes.
  
- ## Exemplo

    ```mermaid
    classDiagram
    class Conta {
        - Titular titular
        - int agencia
        - int numero
        - double saldo
        + void sacar(double valorSaque)
        + void depositar(double valorDeposito)
        + void imprimirDemonstrativo()
    }
    
    class ContaInvestimento {
        - double valorTotalRendimentos
        + void creditarRendimentos(double valorRendimentos)
    }
    
    class ContaEspecial {
       - double limiteChequeEspecial
       - double tarifaMensal
       + double getSaldoDisponivel()
       + void debitarTarifaMensal() 
    }
    
    Conta <|-- ContaInvestimento
    ContaInvestimento <|-- ContaEspecial
    ```
