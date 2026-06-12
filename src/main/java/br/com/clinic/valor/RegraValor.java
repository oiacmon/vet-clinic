package br.com.clinic.valor;
import br.com.clinic.model.Atendimento;

public interface RegraValor {
    double aplicar(double valorAtual, Atendimento atendimento);
}