package com.fsoares.machines.abstractions;

import com.fsoares.util.Fifo;

public interface AgentInterface {

    /**
     * Define a fila de ações
     */
    Fifo<ActionInterface> actions = new Fifo<>();

    /**
     * Método que decide a próxima ação válida
     * @return Uma ação válida
     */
    public ActionInterface decide();

    /**
     * Roda o fluxo de execução
     */
    public void run();

    /**
     * Executa a próxima ação da fila
     */
    public void act();

    /**
     * Adiciona uma ação na fila de ações
     * @param action que estrará na fila
     */
    public void addAction(ActionInterface action);

}
