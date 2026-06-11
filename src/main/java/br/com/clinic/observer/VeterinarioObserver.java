package br.com.clinic.observer;
import br.com.clinic.model.Atendimento;

public class VeterinarioObserver implements AtendimentoObserver {

    @Override
    public void notificar(Atendimento atendimento, String novaSituacao) {
        if (novaSituacao.equals("Cancelado")) {
            System.out.println("Aviso ao veterinário: o atendimento foi cancelado.");
        }
    }
}