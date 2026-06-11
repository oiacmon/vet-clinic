package br.com.clinic.state;
import br.com.clinic.model.Atendimento;

public class Finalizado implements SituacaoAtendimento {

    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser iniciado novamente.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está finalizado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser cancelado.");
    }

    @Override
    public String getNome() {
        return "Finalizado";
    }
}