# Boas Práticas de Encapsulamento

- ## Use **métodos** de **acesso** em classes publicas (incluindo **Tell, Don't Ask**)

  - **Tell, Don't Ask**: **diga** ao objeto o que você quer que ele faça, **não pergunte** a ele sobre seu estado para fazer algo.
  
  - **Exemplo Falho**:
  
    ```java
    public class Horario {
        public int hora;
        public int minuto;

        public Horario(int hora, int minuto) {
            if (hora < 0 || hora > 23) {
                throw new IllegalArgumentException("Hora inválida: " + hora);
            }
            
            if (minuto < 0 || minuto > 59) {
                throw new IllegalArgumentException("Minuto inválido: " + minuto);
            }
            
            this.hora = hora;
            this.minuto = minuto;
        }
    }
    ```

    - **Principal.java (Teste)**:

    ```java
    public class Principal {
        public static void main(String[] args) {
            Horario horario = new Horario(10, 55);
            System.out.println("%dh%dm", horario.hora, horario.minuto);
        }
    }
    ```

    - Na classe `Principal`, o acesso direto aos atributos `hora` e `minuto` da classe `Horario` viola o princípio de encapsulamento. O ideal é que a classe `Horario` forneça métodos de acesso para esses atributos.

    - **Exemplo Correto**:

    ```java
    public class Horario {
        private int hora;
        private int minuto;

        public Horario(int hora, int minuto) {
            setHora(hora);
            setMinuto(minuto);
        }

        public int getHora() {
            return hora;
        }

        public int getMinuto() {
            return minuto;
        }
        
        public void setHora(int hora) {
            if (hora < 0 || hora > 23) {
                throw new IllegalArgumentException("Hora inválida: " + hora);
            }
            
            this.hora = hora;
        }


    - **Principal.java (Teste)**:

        ```java
            public class Principal {
                        public static void main(String[] args) {
                                        Horario horario = new Horario(10, 55);
                                                    System.out.println(horario.formatar());
                                                            }
                                                                }
                                                                    ```
        public void setMinuto(int minuto) {
            if (minuto < 0 || minuto > 59) {
                throw new IllegalArgumentException("Minuto inválido: " + minuto);
            }
            
            this.minuto = minuto;
        }
        
        public String formatar() {
            return String.format("%dh%dm", getHora(), getMinuto());
        }
    }
    ```

    - **Principal.java (Teste)**:

    ```java
    public class Principal {
        public static void main(String[] args) {
            Horario horario = new Horario(10, 55);
            System.out.println(horario.formatar());
        }
    }
    ```

- ## Código Limpo: Lei de Demeter (incluindo Train Wreck)

  - **Lei de Demeter**: Um objeto deve conhecer apenas seus objetos mais próximos. Não deve acessar objetos de objetos de objetos. Cada unidade deve ter conhecimento limitado sobre outras unidades. Apenas unidades "vizinhas" devem ser acessadas.

  - **Train Wreck**: Encadeamento excessivo de chamadas de métodos. Isso pode ser um sinal de violação da Lei de Demeter.
  - **Exemplo:**

    - **Veiculo.java**

    ```java
    package com.exemplo.locacao;

    public class Veiculo {

        private String placa;
        private boolean disponivel = true;
        private GrupoVeiculo grupo;

        public Veiculo() {
        }

        public Veiculo(String placa, GrupoVeiculo grupo) {
            this.placa = placa;
            this.grupo = grupo;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }

        public GrupoVeiculo getGrupo() {
            return grupo;
        }

        public void setGrupo(GrupoVeiculo grupo) {
            this.grupo = grupo;
        }

        public double getValorDiaria() {
            return grupo.getValorDiaria();
        }

    }
    ```

    - **GrupoVeiculo.java**

    ```java
    package com.example.locacao;

    public class GrupoVeiculo {

        private String nome;
        private double valorDiaria;

        public GrupoVeiculo() {
        }

        public GrupoVeiculo(String nome, double valorDiaria) {
            this.nome = nome;
            this.valorDiaria = valorDiaria;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getValorDiaria() {
            return valorDiaria;
        }

        public void setValorDiaria(double valorDiaria) {
            this.valorDiaria = valorDiaria;
        }
    }
    ```

    - **Locacao.java**

    ```java
    package com.example.locacao;

    public class Locacao {

        private Veiculo veiculo;
        private int quantidadeDiarias;

        public Locacao() {
        }

        public Locacao(Veiculo veiculo, int quantidadeDiarias) {
            this.veiculo = veiculo;
            this.quantidadeDiarias = quantidadeDiarias;
        }

        public Veiculo getVeiculo() {
            return veiculo;
        }

        public void setVeiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
        }

        public int getQuantidadeDiarias() {
            return quantidadeDiarias;
        }

        public void setQuantidadeDiarias(int quantidadeDiarias) {
            this.quantidadeDiarias = quantidadeDiarias;
        }

        public double getValorDiaria() {
            return veiculo.getValorDiaria();
        }

        public double calcularTotalDiarias() {
            return getValorDiaria() * quantidadeDiarias;
        }

        public void reservarVeiculo() {
            veiculo.setDisponivel(false);
        }

    }
    ```

    - **Principal.java (Teste)**

    ```java
    import com.example.locacao.GrupoVeiculo;
    import com.example.locacao.Locacao;
    import com.example.locacao.servico.ServicoDeLocacao;
    import com.example.locacao.Veiculo;

    public class Principal {

        public static void main(String[] args) {
            GrupoVeiculo grupo = new GrupoVeiculo("SUV", 450);
            Veiculo veiculo = new Veiculo("ALG-9999", grupo);
            Locacao locacao = new Locacao(veiculo, 5);

            ServicoDeLocacao servicoDeLocacao = new ServicoDeLocacao();
            servicoDeLocacao.confirmarLocacao(locacao);
        }

    }
    ```

    - **ServicoDeLocacao.java**

    ```java
    package com.example.locacao.servico;

    import com.example.locacao.Locacao;
    import com.example.locacao.Veiculo;

    public class ServicoDeLocacao {

        public void confirmarLocacao(Locacao locacao) {
    //        double totalDiarias = locacao.getVeiculo().getGrupo().getValorDiaria()
    //                * locacao.getQuantidadeDiarias();

    //        double totalDiarias = locacao.getValorDiaria()
    //                * locacao.getQuantidadeDiarias();

            double totalDiarias = locacao.calcularTotalDiarias();

            // TODO realiza lógica para registrar locação pelo valor das diárias

    //        locacao.getVeiculo().setDisponivel(false);
            locacao.reservarVeiculo();
        }

    }
    ```

    - No exemplo acima, a classe `ServicoDeLocacao` viola a Lei de Demeter ao acessar indiretamente o valor da diária do veículo através do grupo de veículo. O ideal é que a classe `Locacao` forneça um método para calcular o total das diárias.

    - O método `confirmarLocacao` da classe `ServicoDeLocacao` também viola a Lei de Demeter ao acessar indiretamente o veículo para reservá-lo. O ideal é que a classe `Locacao` forneça um método para reservar o veículo.

- ## Não permita instanciação com construtor privado

  - **Exemplo:**
  - **CaluladoraArea.java**

    ```java
    package com.example.matematica;

    public class CalculadoraArea {

        public static final double PI = 3.14159265358979323846;

        private CalculadoraArea() {
        }

        public static double calcularAreaQuadrado(double medidaDoLado) {
            return medidaDoLado * medidaDoLado;
        }

        public static double calcularAreaCirculo(double raio) {
            return raio * raio * CalculadoraArea.PI;
        }

    }
    ```

  - **Principal.java (Teste)**

    ```java
    import com.example.matematica.CalculadoraArea;

    public class Principal {

        public static void main(String[] args) {
            double areaQuadrado = CalculadoraArea.calcularAreaQuadrado(5.2);
            double areaCirculo = CalculadoraArea.calcularAreaCirculo(10.5);

            System.out.printf("PI: %.2f%n", CalculadoraArea.PI);
            System.out.printf("Área do quadrado: %.2f%n", areaQuadrado);
            System.out.printf("Área do círculo: %.2f%n", areaCirculo);
        }

    }
    ```

    - No exemplo acima, a classe `CalculadoraArea` não deve ser instanciada, pois possui apenas métodos estáticos. Para evitar a instanciação, o construtor da classe é privado.

    - Na classe `Agendamento`, o construtor recebe um objeto `Horario` e uma descrição. O objeto `Horario` é uma cópia defensiva, para evitar que seja modificado fora da classe `Agendamento`.
  
    - O método `getHorario` da classe `Agendamento` retorna uma cópia defensiva do objeto `Horario`. Dessa forma, o objeto `Horario` original não pode ser modificado fora da classe `Agendamento`.

    - O método `setHora` da classe `Principal` tenta modificar o objeto `Horario` do agendamento de corte de cabelo. Como o objeto `Horario` é uma cópia defensiva, a modificação não é refletida no agendamento.
  
    - O método `setHora` da classe `Principal` modifica o objeto `Horario` original. Como o objeto `Horario` do agendamento de barba é uma cópia defensiva, a modificação não é refletida no agendamento.
  
    - O método `main` da classe `Principal` testa os métodos da classe `CalculadoraArea`.

- ## Crie copias defensivas

  - **Exemplo:**
    - **Horario.java**

    ```java
    package com.example.agenda;

    public class Horario {

        private int hora;
        private int minuto;

        public Horario(int hora, int minuto) {
            setHora(hora);
            setMinuto(minuto);
        }

        public int getHora() {
            return hora;
        }

        public void setHora(int hora) {
            if (hora < 0 || hora > 23) {
                throw new IllegalArgumentException("Hora inválida: " + hora);
            }

            this.hora = hora;
        }

        public int getMinuto() {
            return minuto;
        }

        public void setMinuto(int minuto) {
            if (minuto < 0 || minuto > 59) {
                throw new IllegalArgumentException("Minuto inválido: " + minuto);
            }

            this.minuto = minuto;
        }

        public String formatar() {
            return String.format("%dh%dm", getHora(), getMinuto());
        }

    }
    ```

    - **Agendamento.java**

    ```java
    package com.example.agenda;

    public class Agendamento {

        private final Horario horario;
        private String descricao;

        public Agendamento(Horario horario, String descricao) {
            this.horario = new Horario(horario.getHora(), horario.getMinuto());
            this.descricao = descricao;
        }

        public Horario getHorario() {
            return new Horario(horario.getHora(), horario.getMinuto());
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getHorarioFormatado() {
            return horario.formatar();
        }

    }    
    ```

    - **Principal.java (Teste)**

    ```java
    package com.example.agenda;

    public class Principal {

        public static void main(String[] args) {
            Horario horario = new Horario(10, 30);
            Agendamento agendamentoCabelo = new Agendamento(horario, "Corte de cabelo");
            agendamentoCabelo.getHorario().setHora(20);

            horario.setHora(19);
            Agendamento agendamentoBarba = new Agendamento(horario, "Feitio de barba");

            imprimir(agendamentoCabelo);
            imprimir(agendamentoBarba);
        }

        private static void imprimir(Agendamento agendamento) {
            System.out.printf("%s às %s%n", agendamento.getDescricao(), agendamento.getHorarioFormatado());
        }

    }
    ```

    - No exemplo acima, a classe `Agendamento` possui um atributo `horario` do tipo `Horario`. O construtor da classe `Agendamento` recebe um objeto `Horario` e uma descrição. Para evitar que o objeto `Horario` seja modificado fora da classe `Agendamento`, é feita uma cópia defensiva do objeto no construtor.

    - O método `getHorario` da classe `Agendamento` retorna uma cópia defensiva do objeto `Horario`. Dessa forma, o objeto `Horario` original não pode ser modificado fora da classe `Agendamento`.

    - O método `setHora` da classe `Principal` tenta modificar o objeto `Horario` do agendamento de corte de cabelo. Como o objeto `Horario` é uma cópia defensiva, a modificação não é refletida no agendamento.

    - O método `setHora` da classe `Principal` modifica o objeto `Horario` original. Como o objeto `Horario` do agendamento de barba é uma cópia defensiva, a modificação não é refletida no agendamento.

- ## Minimize a mutabilidade (incluindo Value Object)

  - **Exemplo:**
  - **Agendamento.java**

    ```java
    package com.exemplo.agenda;

    public class Agendamento {

        private Horario horario;
        private String descricao;

        public Agendamento(Horario horario, String descricao) {
            this.horario = horario;
            this.descricao = descricao;
        }

        public Horario getHorario() {
            return horario;
        }

        public void setHorario(Horario horario) {
            this.horario = horario;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getHorarioFormatado() {
            return horario.formatar();
        }

    }
    ```

  - **Horario.java**

    <tab><tab>

    ```java
    package com.example.agenda;

    public final class Horario {

        private final int hora;
        private final int minuto;

        public Horario(int hora, int minuto) {
            if (hora < 0 || hora > 23) {
                throw new IllegalArgumentException("Hora inválida: " + hora);
            }
            if (minuto < 0 || minuto > 59) {
                throw new IllegalArgumentException("Minuto inválido: " + minuto);
            }

            this.hora = hora;
            this.minuto = minuto;
        }

        public int getHora() {
            return hora;
        }

        public int getMinuto() {
            return minuto;
        }

        public String formatar() {
            return String.format("%dh%dm", getHora(), getMinuto());
        }
    }
    ```

    - **CalculadoraHorario.java**

    ```java
    package com.example.agenda;

    public class CalculadoraHorario {

        private CalculadoraHorario() {
        }

        public static Horario somarDuasHoras(Horario horario) {
            int hora = horario.getHora() + 2;

            if (hora > 24) {
                hora = hora - 24;
            }

    //        horario.setHora(hora);
    //        return horario;

            return new Horario(hora, horario.getMinuto());
        }

    }
    ```

    - **Principal.java (Teste)**

    ```java
    package com.example.agenda;

    public class Principal {

        public static void main(String[] args) {
            Horario horario = new Horario(10, 30);
            Agendamento agendamentoCabelo = new Agendamento(horario, "Corte de cabelo");

            Horario novoHorario = CalculadoraHorario.somarDuasHoras(horario);

            agendamentoCabelo.setHorario(new Horario(16, 20));

            System.out.println(agendamentoCabelo.getHorarioFormatado());
            System.out.println(novoHorario.formatar());
        }
    }
    ```

    - No exemplo acima, a classe `Horario` é um objeto de valor (Value Object), ou seja, é imutável. O construtor da classe `Horario` recebe a hora e o minuto, e não possui métodos de acesso e modificação dos atributos. Os atributos `hora` e `minuto` são finais, ou seja, não podem ser modificados após a criação do objeto.

    - A classe `Agendamento` possui um atributo `horario` do tipo `Horario`. O método `setHorario` da classe `Agendamento` recebe um novo `Horario` e substitui o `Horario` original. Como a classe `Horario` é imutável, a substituição do `Horario` não afeta o objeto original.

    - O método `somarDuasHoras` da classe `CalculadoraHorario` recebe um `Horario` e retorna um novo `Horario` com duas horas a mais. Como a classe `Horario` é imutável, o método retorna um novo `Horario` sem modificar o `Horario` original.

    - O `final` na declaração da classe `Horario` impede que a classe seja estendida. O `final` na declaração dos atributos `hora` e `minuto` impede que os atributos sejam modificados após a criação do objeto.

    - O método `formatar` da classe `Horario` retorna uma representação textual do horário no formato `hhh:mmm`.

    - Usar objetos imutáveis (Value Object) ajuda a minimizar a mutabilidade do código, tornando-o mais previsível e fácil de entender. Garante que os objetos não sejam modificados acidentalmente, evitando efeitos colaterais indesejados.
  
    - Objetos imutáveis são seguros para uso concorrente, pois não podem ser modificados após a criação. Isso evita condições de corrida e outros problemas de concorrência.

- ## Records

-
