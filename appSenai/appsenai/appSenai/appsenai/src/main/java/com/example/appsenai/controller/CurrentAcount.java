package com.example.appsenai.controller;

import com.example.appsenai.model.Conta;
import com.example.appsenai.model.CurrentAcountPF;

public interface CurrentAcount {

    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    void transferir(Double quantidade, Conta conta);

    Double consultaSaldo(CurrentAcountPF conta);

}