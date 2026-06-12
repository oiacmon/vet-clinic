package br.com.clinic.valor;
import br.com.clinic.model.Atendimento;

public class DescontoAnimalAdotado implements RegraValor {

    @Override
    public double aplicar(double valorAtual, Atendimento atendimento) {
        if (atendimento.getAnimal().isAdotado()) {
            return valorAtual * 0.8; // 20% de desconto
        }
        return valorAtual;
    }
}