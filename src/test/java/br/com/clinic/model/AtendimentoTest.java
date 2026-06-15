package br.com.clinic.model;

import br.com.clinic.state.Agendado;
import br.com.clinic.valor.DescontoAnimalAdotado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtendimentoTest {

    @Test
    public void deveCriarAtendimentoComDadosCorretos() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", true);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);

        Assertions.assertEquals(tutor, atendimento.getTutor());
        Assertions.assertEquals(animal, atendimento.getAnimal());
        Assertions.assertEquals(servico, atendimento.getServico());
        Assertions.assertEquals(100.0, atendimento.getValorBase());
    }

    @Test
    public void deveIniciarComSituacaoAgendado() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);

        Assertions.assertTrue(atendimento.getSituacao() instanceof Agendado);
        Assertions.assertEquals("Agendado", atendimento.getSituacaoNome());
    }

    @Test
    public void deveCalcularValorFinalUsandoRegras() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", true);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);

        atendimento.adicionarRegraValor(new DescontoAnimalAdotado());

        double valorFinal = atendimento.calcularValorFinal();

        Assertions.assertEquals(80.0, valorFinal);
    }
}