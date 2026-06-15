package br.com.clinic.model;

import br.com.clinic.state.Agendado;
import br.com.clinic.state.SituacaoAtendimento;
import br.com.clinic.observer.AtendimentoObserver;
import br.com.clinic.valor.RegraValor;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {

    private Tutor tutor;
    private Animal animal;
    private ServicoVeterinario servico;
    private double valorBase;

    private SituacaoAtendimento situacao;

    private List<AtendimentoObserver> observers = new ArrayList<>();
    private List<RegraValor> regrasValor = new ArrayList<>();

    public Atendimento(Tutor tutor, Animal animal, ServicoVeterinario servico, double valorBase) {
        this.tutor = tutor;
        this.animal = animal;
        this.servico = servico;
        this.valorBase = valorBase;

        this.situacao = new Agendado();
    }




    public void addObserver(AtendimentoObserver observer) {
        observers.add(observer);
    }

    private void notificarObservers(String novaSituacao) {
        for (AtendimentoObserver obs : observers) {
            obs.notificar(this, novaSituacao);
        }
    }




    public void iniciar() {
        situacao.iniciar(this);
        notificarObservers(situacao.getNome());
    }

    public void finalizar() {
        situacao.finalizar(this);
        notificarObservers(situacao.getNome());
    }

    public void cancelar() {
        situacao.cancelar(this);
        notificarObservers(situacao.getNome());
    }




    public void adicionarRegraValor(RegraValor regra) {
        regrasValor.add(regra);
    }

    public double calcularValorFinal() {
        double valor = valorBase;

        for (RegraValor regra : regrasValor) {
            valor = regra.aplicar(valor, this);
        }

        return valor;
    }




    public Tutor getTutor() {
        return tutor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public ServicoVeterinario getServico() {
        return servico;
    }

    public double getValorBase() {
        return valorBase;
    }

    public SituacaoAtendimento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAtendimento situacao) {
        this.situacao = situacao;
    }

    public String getSituacaoNome() {
        return situacao.getNome();
    }
}