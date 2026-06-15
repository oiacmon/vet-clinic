package br.com.clinic.state;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanceladoTest {

    private Atendimento criarAtendimentoCancelado() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);
        atendimento.cancelar();

        return atendimento;
    }

    @Test
    public void naoDevePermitirIniciar() {
        Atendimento atendimento = criarAtendimentoCancelado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::iniciar);
    }

    @Test
    public void naoDevePermitirFinalizar() {
        Atendimento atendimento = criarAtendimentoCancelado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::finalizar);
    }

    @Test
    public void naoDevePermitirCancelarNovamente() {
        Atendimento atendimento = criarAtendimentoCancelado();

        Assertions.assertThrows(IllegalStateException.class, atendimento::cancelar);
    }
}