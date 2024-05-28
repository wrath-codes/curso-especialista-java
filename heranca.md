# Herança

- ## Introdução

  - Herança é um dos pilares da programação orientada a objetos, que permite a criação de novas classes a partir de classes já existentes.
  - A classe que é herdada é chamada de superclasse ou classe pai.
  - A classe que herda é chamada de subclasse ou classe filha.
  - A subclasse herda todos os atributos e métodos da superclasse.
  - A subclasse pode adicionar novos atributos e métodos, ou sobrescrever os métodos da superclasse.
  - A herança é representada em UML por uma linha sólida com uma seta que aponta para a superclasse, por exemplo:

    - ```java
          public class SubClasse extends SuperClasse {
          }
          ```

    - ```mermaid
                classDiagram
                SuperClasse <|-- SubClasse
            ```

[Voltar ao Sumário](sumario.md) [Próxima Página](heranca-tagged-classes.md)
