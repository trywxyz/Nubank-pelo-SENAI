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
    public void transferir(Double quantidade, Conta conta) {

    }

    @Override
    public Double consultaSaldo(CurrentAcountPF conta) {
        return conta.getSaldo();
    }
}
