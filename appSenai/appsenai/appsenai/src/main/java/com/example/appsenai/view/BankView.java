package com.example.appsenai.view;

import com.example.appsenai.controller.BankController;
import com.example.appsenai.model.AccountType;
// import com.example.appsenai.model.Conta;
import com.example.appsenai.model.CurrentAccountPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class BankView {

    @Autowired
    private BankController bancoController;
    
    @GetMapping("/consultaSaldo")
    public Double consultaSaldo(){
        CurrentAccountPF conta = new CurrentAccountPF();
        conta.setSaldo(100D);
        return bancoController.consultaSaldo(conta);

    }
    @PostMapping("/criaconta")
    public CurrentAccountPF criarConta(@PathParam("name") String name, @PathParam("type") String type) throws Exception {
        return bancoController.criarConta(name, type);
    }

    @GetMapping("/type")
    public String listAccountType() {
        String text = AccountType.CONTA_CORRENTE + ", " + AccountType.CONTA_POUPANCA;
        return text;
    }

    @GetMapping("/consultaconta")
    public CurrentAccountPF consultaConta(@PathParam("name") String name){
        return bancoController.consultaConta(name);
    }


    @PutMapping("/transferir")
    public String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){
        return bancoController.transferir(contaOrigem, contaDestino, valor);
    }

    // @GetMapping("/Extrato")
    // public Double extrato(@PathParam("saldo") Double saldo, @PathParam("titular") String titular ){

    //    return bancoController.imprimirExtrato(saldo, titular); 
    // }
    

}
