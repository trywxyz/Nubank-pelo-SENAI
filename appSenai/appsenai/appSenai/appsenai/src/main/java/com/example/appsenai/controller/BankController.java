package com.example.appsenai.controller;

import com.example.appsenai.model.Conta;
import com.example.appsenai.model.CurrentAcountPF;
import com.example.appsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankController implements CurrentAcount{

    @Autowired
    private BankRepository bancoRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;
    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public CurrentAcountPF criarConta(String name) throws Exception {
        CurrentAcountPF contaCorrentePF = new CurrentAcountPF();
        number++;
        contaCorrentePF.setNumeroConta(number);
        Person person =controller.findPerson(name);
        if(person != null){
            contaCorrentePF.setPerson(person);
            bancoRepository.save(contaCorrentePF);
        }else{
            throw new Exception("Pessoa não está cadastrada");
        }

        return contaCorrentePF;
    }

    public CurrentAcountPF consultaConta(String name){

        List<CurrentAcountPF> contas = (List<CurrentAcountPF>) bancoRepository.findAll();

        for(CurrentAcountPF cc : contas){
            if(cc.getPerson() != null && cc.getPerson().getName().equals(name)){
                return cc;
            }
        }
        return null;
    }


    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade ;
        conta.setSaldo(total);
    }

    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        CurrentAcountPF destino = bancoRepository.findById(contaDestino).get();
        CurrentAcountPF origem = bancoRepository.findById(contaOrigem).get();

        if(origem.getSaldo() >= valor){
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = "A conta do(a) " + destino.getPerson().getName() + " recebeu a transferência no valor de R$ " + valor;
        }else{
            message = message + " Saldo insuficiente para a operação";
        }

        return message;
    }

    // @Override
    // public Double depositar(Double valor) {
    //     if (valor > 0) {
    //         Double saldo = valor;
    //         System.out.println("Depósito de " + valor + " realizado com sucesso.");
    //     } else {
    //         System.out.println("Valor inválido para depósito.");
    //     }
    //     return valor.setSaldo();
    // }

    @Override
    public Double consultaSaldo(CurrentAcountPF conta) {
        return conta.getSaldo();
    }

    // @Override
    // public Double imprimirExtrato(Double saldo, String titular) {
    //     Double saldo;
    //     String titular;
    //     String[] historico;

    //     System.out.println("Extrato da conta de " + titular);
        
    //     for (String transacao : historico) {
    //         System.out.println(transacao);
    //     }
       
    //     System.out.println("Saldo atual: " + saldo);
    // }
}
