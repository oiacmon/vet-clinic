package br.com.clinic.state;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinalizadoTest {

    private Atendimento criarAtendimentoFinalizado() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);
        atendimento.iniciar();
        atendimento.finalizar();

        return atendimento;
    }

    @Test
    public void naoDevePermitirIniciar() {
        Atendimento atendimento = criarAtendimentoFinalizado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::iniciar);
    }

    @Test
    public void naoDevePermitirFinalizarNovamente() {
        Atendimento atendimento = criarAtendimentoFinalizado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::finalizar);
    }

    @Test
    public void naoDevePermitirCancelar() {
        Atendimento atendimento = criarAtendimentoFinalizado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::cancelar);
    }
}