package br.com.clinic.valor;
import br.com.clinic.model.Atendimento;

public class ServicoBanhoPosConsulta implements RegraValor {

    @Override
    public double aplicar(double valorAtual, Atendimento atendimento) {
        return valorAtual + 30.0;
    }
}