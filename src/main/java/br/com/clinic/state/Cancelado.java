package br.com.clinic.state;
import br.com.clinic.model.Atendimento;

public class Cancelado implements SituacaoAtendimento {

    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser iniciado.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser finalizado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está cancelado.");
    }

    @Override
    public String getNome() {
        return "Cancelado";
    }
}