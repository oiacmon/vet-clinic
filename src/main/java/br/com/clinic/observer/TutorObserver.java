package br.com.clinic.observer;
import br.com.clinic.model.Atendimento;

public class TutorObserver implements AtendimentoObserver {

    @Override
    public void notificar(Atendimento atendimento, String novaSituacao) {
        if (novaSituacao.equals("Em Atendimento")) {
            System.out.println("Aviso ao tutor " + atendimento.getTutor().getNome() +
                    ": o atendimento do animal " + atendimento.getAnimal().getNome() + " foi iniciado.");
        }
    }
}