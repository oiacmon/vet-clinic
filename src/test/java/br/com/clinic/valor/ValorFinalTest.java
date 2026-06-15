package br.com.clinic.valor;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValorFinalTest {

    private Atendimento criarAtendimento(boolean adotado) {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", adotado);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        return new Atendimento(tutor, animal, servico, 100.0);
    }

    @Test
    public void deveAplicarDescontoAnimalAdotado() {
        Atendimento atendimento = criarAtendimento(true);

        atendimento.adicionarRegraValor(new DescontoAnimalAdotado());

        double valorFinal = atendimento.calcularValorFinal();

        Assertions.assertEquals(80.0, valorFinal);
    }

    @Test
    public void deveAplicarTaxaDomiciliar() {
        Atendimento atendimento = criarAtendimento(false);

        atendimento.adicionarRegraValor(new TaxaAtendimentoDomiciliar());

        double valorFinal = atendimento.calcularValorFinal();

        Assertions.assertEquals(150.0, valorFinal);
    }

    @Test
    public void deveAplicarBanhoPosConsulta() {
        Atendimento atendimento = criarAtendimento(false);

        atendimento.adicionarRegraValor(new ServicoBanhoPosConsulta());

        double valorFinal = atendimento.calcularValorFinal();

        Assertions.assertEquals(130.0, valorFinal);
    }

    @Test
    public void deveAplicarMultiplasRegrasCombinadas() {
        Atendimento atendimento = criarAtendimento(true);

        atendimento.adicionarRegraValor(new DescontoAnimalAdotado());
        atendimento.adicionarRegraValor(new TaxaAtendimentoDomiciliar());
        atendimento.adicionarRegraValor(new ServicoBanhoPosConsulta());

        double valorFinal = atendimento.calcularValorFinal();

        Assertions.assertEquals(160.0, valorFinal);
    }
}