package com.example.appsenai.view;

import com.example.appsenai.controller.BankController;
import com.example.appsenai.model.AcountType;
// import com.example.appsenai.model.Conta;
import com.example.appsenai.model.CurrentAcountPF;
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
        CurrentAcountPF conta = new CurrentAcountPF();
        conta.setSaldo(100D);
        return bancoController.consultaSaldo(conta);

    }
    @PostMapping("/criaconta")
    public CurrentAcountPF criarConta(@PathParam("name") String name) throws Exception {
        return bancoController.criarConta(name);
    }
    @GetMapping("/type")
    public String listAccountType() {
        String text = AcountType.CONTA_CORRENTE + ", " + AcountType.CONTA_POUPANCA;
        return text;
    }

    @GetMapping("/consultaconta")
    public CurrentAcountPF consultaConta(@PathParam("name") String name){
        return bancoController.consultaConta(name);
    }
    @PutMapping("/transferir")
    public String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){

        return bancoController.transferir(contaOrigem, contaDestino, valor);

    // @PostMapping("/depositar")
    // public String depositar(@PathParam("quantidade") Double quantidade, @PathParam("conta") Conta conta,@PathParam("total") Double total){
        
    //     return bancoController.depositar(total);
    // }
    // @GetMapping("/Extrato")
    // public Double extrato(@PathParam("saldo") Double saldo, @PathParam("titular") String titular ){

    //    return bancoController.imprimirExtrato(); 
    // }
    }

}
