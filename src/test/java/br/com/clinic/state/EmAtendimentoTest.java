package br.com.clinic.state;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmAtendimentoTest {

    private Atendimento criarAtendimentoEmAndamento() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);
        atendimento.iniciar();

        return atendimento;
    }

    @Test
    public void devePermitirFinalizarAtendimento() {
        Atendimento atendimento = criarAtendimentoEmAndamento();

        atendimento.finalizar();

        Assertions.assertEquals("Finalizado", atendimento.getSituacaoNome());
    }

    @Test
    public void naoDevePermitirCancelar() {
        Atendimento atendimento = criarAtendimentoEmAndamento();

        Assertions.assertThrows(IllegalStateException.class, atendimento::cancelar);
    }

    @Test
    public void naoDevePermitirIniciarNovamente() {
        Atendimento atendimento = criarAtendimentoEmAndamento();

        Assertions.assertThrows(IllegalStateException.class, atendimento::iniciar);
    }
}