package br.com.clinic.observer;
import br.com.clinic.model.Atendimento;

public class RecepcaoObserver implements AtendimentoObserver {

    @Override
    public void notificar(Atendimento atendimento, String novaSituacao) {
        if (novaSituacao.equals("Finalizado")) {
            System.out.println("Aviso à recepção: o atendimento foi finalizado.");
        }
    }
}