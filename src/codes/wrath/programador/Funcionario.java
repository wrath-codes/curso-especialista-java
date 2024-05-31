package codes.wrath.programador;

public class Funcionario {
    private String nome;
    private double valorHora;

    public Funcionario(String nome, double valorHora) {
        this.nome = nome;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Funcionario(name=%s, valorHora=%.2f)".formatted(nome, valorHora);
    }

    protected double calcularSalario(int horasTrabalhadas) {
        return valorHora * horasTrabalhadas;
    }

    public Holerite gerarHolerite(String mesAno, int horasTrabalhadas) {
        double salario = calcularSalario(horasTrabalhadas);
        return new Holerite(nome, mesAno, salario);
    }
}
