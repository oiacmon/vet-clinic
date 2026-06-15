package br.com.clinic.observer;

import br.com.clinic.model.Animal;
import br.com.clinic.model.Atendimento;
import br.com.clinic.model.ServicoVeterinario;
import br.com.clinic.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ObserverTest {

    private ByteArrayOutputStream saidaConsole;

    @BeforeEach
    public void configurarCapturaConsole() {
        saidaConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saidaConsole));
    }

    private Atendimento criarAtendimento() {
        Tutor tutor = new Tutor("Caio", "99999-9999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);

        Atendimento atendimento = new Atendimento(tutor, animal, servico, 100.0);

        atendimento.addObserver(new TutorObserver());
        atendimento.addObserver(new VeterinarioObserver());
        atendimento.addObserver(new RecepcaoObserver());

        return atendimento;
    }

    @Test
    public void deveNotificarTutorQuandoIniciar() {
        Atendimento atendimento = criarAtendimento();

        atendimento.iniciar();

        String saida = saidaConsole.toString();

        Assertions.assertTrue(
                saida.contains("o atendimento do animal Rex foi iniciado"),
                "Tutor deveria ter sido notificado"
        );
    }

    @Test
    public void deveNotificarVeterinarioQuandoCancelar() {
        Atendimento atendimento = criarAtendimento();

        atendimento.cancelar();

        String saida = saidaConsole.toString();

        Assertions.assertTrue(
                saida.contains("o atendimento foi cancelado"),
                "Veterinário deveria ter sido notificado"
        );
    }

    @Test
    public void deveNotificarRecepcaoQuandoFinalizar() {
        Atendimento atendimento = criarAtendimento();

        atendimento.iniciar();   // precisa iniciar antes de finalizar
        atendimento.finalizar();

        String saida = saidaConsole.toString();

        Assertions.assertTrue(
                saida.contains("o atendimento foi finalizado"),
                "Recepção deveria ter sido notificada"
        );
    }
}