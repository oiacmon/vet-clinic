package br.com.clinic.state;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgendadoTest {

    private Atendimento criarAtendimento() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        return new Atendimento(tutor, animal, servico, 100.0);
    }

    @Test
    public void devePermitirIniciarAtendimento() {
        Atendimento atendimento = criarAtendimento();

        atendimento.iniciar();

        Assertions.assertEquals("Em Atendimento", atendimento.getSituacaoNome());
    }

    @Test
    public void devePermitirCancelarAtendimento() {
        Atendimento atendimento = criarAtendimento();

        atendimento.cancelar();

        Assertions.assertEquals("Cancelado", atendimento.getSituacaoNome());
    }

    @Test
    public void naoDevePermitirFinalizarDireto() {
        Atendimento atendimento = criarAtendimento();

        Assertions.assertThrows(IllegalStateException.class, atendimento::finalizar);
    }
}