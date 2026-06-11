package br.com.clinic.state;
import br.com.clinic.model.Atendimento;

public class Agendado implements SituacaoAtendimento {

    @Override
    public void iniciar(Atendimento atendimento) {
        atendimento.setSituacao(new EmAtendimento());
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento agendado não pode ser finalizado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        atendimento.setSituacao(new Cancelado());
    }

    @Override
    public String getNome() {
        return "Agendado";
    }
}