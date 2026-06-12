package br.com.clinic.valor;
import br.com.clinic.model.Atendimento;

public class TaxaAtendimentoDomiciliar implements RegraValor {

    @Override
    public double aplicar(double valorAtual, Atendimento atendimento) {
        return valorAtual + 50.0; // taxa fixa
    }
}