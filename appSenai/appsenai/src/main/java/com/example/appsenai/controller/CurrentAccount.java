package com.example.appsenai.controller;

import com.example.appsenai.model.Account;
import com.example.appsenai.model.CurrentAccountPF;
// import javax.websocket.server.PathParam;

public interface CurrentAccount {

    Double sacar(Double quantidade, Account conta);

    void depositar(Double quantidade, Account conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    Double consultaSaldo(CurrentAccountPF conta);

    // Double extrato(Double saldo,String titular,String historico);

}