package br.com.clinic.state;
import br.com.clinic.model.Atendimento;

public interface SituacaoAtendimento {

    void iniciar(Atendimento atendimento);

    void finalizar(Atendimento atendimento);

    void cancelar(Atendimento atendimento);

    String getNome();
}