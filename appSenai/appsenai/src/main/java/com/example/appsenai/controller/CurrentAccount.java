package com.example.appsenai.controller;

import com.example.appsenai.model.Account;
import com.example.appsenai.model.CurrentAccountPF;
// import javax.websocket.server.PathParam;

public interface CurrentAccount {

    String sacar(Double valor, Long conta);

    void depositar(Double quantidade, Account conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    Double consultaSaldo(CurrentAccountPF conta);

    String extrato(Long conta);

    String rendimento(Double valor, Long conta);
}