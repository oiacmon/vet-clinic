package br.com.clinic.state;
import br.com.clinic.model.Atendimento;

public class EmAtendimento implements SituacaoAtendimento {

    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está em andamento.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        atendimento.setSituacao(new Finalizado());
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento em andamento não pode ser cancelado.");
    }

    @Override
    public String getNome() {
        return "Em Atendimento";
    }
}