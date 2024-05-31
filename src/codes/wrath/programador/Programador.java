package codes.wrath.programador;

import java.util.Objects;

public class Programador extends Funcionario {

    double valorBonus;

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    public Programador(String nome, double valorHora) {
        super(nome, valorHora);
    }

    @Override
    public String toString() {
        return "Programador(nome=%s, valorHora=%.2f, bonus=%.2f)".formatted(getNome(), getValorHora(), valorBonus);
    }

    @Override
    public final double calcularSalario(int horasTrabalhadas) {
        return getValorHora() * horasTrabalhadas + valorBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorBonus);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Programador other = (Programador) obj;
        return Double.doubleToLongBits(valorBonus) == Double.doubleToLongBits(other.valorBonus);
    }

}
