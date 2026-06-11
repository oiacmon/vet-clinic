package br.com.clinic.observer;

import br.com.clinic.model.Atendimento;

public interface AtendimentoObserver {
    void notificar(Atendimento atendimento, String novaSituacao);
}
