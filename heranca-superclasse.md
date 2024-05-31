# Herança: Superclasse com super

- ## Conceito

  - A palavra-chave `super` é utilizada para acessar métodos e atributos da superclasse.
  - A palavra-chave `super` é utilizada para acessar o construtor da superclasse.

  - Exemplo de uso da palavra-chave `super` para acessar o construtor da superclasse:

    ```java
    public class ContaInvestimento extends Conta {

        private double valorTotalRendimentos;

        public void creditarRendimentos(double valorRendimentos) {
            valorTotalRendimentos += valorRendimentos;
        }
        
        @Override
        public void imprimirDemonstrativo() {
            super.imprimirDemonstrativo();
            System.out.println("Valor total de rendimentos: " + valorTotalRendimentos);
        }
    }
    ```

[Pagina Anterior: Heranca: Override](heranca-override.md) | [Sumario](sumario.md) | [Próxima Página: Herança: Connstrutor da Superclasse](heranca-construtor-superclasse.md)
