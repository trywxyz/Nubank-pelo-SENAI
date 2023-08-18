package com.example.appsenai.controller;

import com.example.appsenai.model.AccountType;
import com.example.appsenai.model.Account;
import com.example.appsenai.model.CurrentAccountPF;
import com.example.appsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankController  {

    @Autowired
    private BankRepository bancoRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;

    public CurrentAccountPF criarConta(String name, String accountType) throws Exception {

        CurrentAccountPF contaCorrentePF = new CurrentAccountPF();
        StringBuilder message = new StringBuilder();

        if (accountType == null) {

            message.append("\nNecessário informar o tipo da conta!");
        } else {
            switch (accountType) {

                case "POUPANCA":
                    contaCorrentePF.setAccountType(AccountType.CONTA_POUPANCA);
                    break;

                case "CORRENTE":
                    contaCorrentePF.setAccountType(AccountType.CONTA_CORRENTE);
                    break;

                default:
                    message.append("\nTipo da conta não é suportado!");
                    break;
            }
        }

        Person person = controller.findPerson(name);

        if (person != null && contaCorrentePF.getError() == null) {
            number++;
            contaCorrentePF.setNumeroConta(number);
            contaCorrentePF.setPerson(person);
            bancoRepository.save(contaCorrentePF);

        } else if (contaCorrentePF.getError() == null) {
            message.append("\nPessoa ");
            message.append(name).append(" informada não foi cadastrada");
        }
        if (!message.isEmpty()) {
            contaCorrentePF.setError(message.toString());
        }

        return contaCorrentePF;
    }

    public CurrentAccountPF consultaConta(String name) {

        List<CurrentAccountPF> contas = (List<CurrentAccountPF>) bancoRepository.findAll();

        for (CurrentAccountPF cc : contas) {
            if (cc.getPerson() != null && cc.getPerson().getName().equals(name)) {
                return cc;
            }
        }
        return null;
    }

    
    public void depositar(Double quantidade, Account conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);
    }

   
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        CurrentAccountPF destino = bancoRepository.findById(contaDestino).get();
        CurrentAccountPF origem = bancoRepository.findById(contaOrigem).get();

        if (origem.getSaldo() >= valor) {
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = "A conta do(a) " + destino.getPerson().getName() + " recebeu a transferência no valor de R$ "
                    + valor;
        } else {
            message = message + " Saldo insuficiente para a operação";
        }

        return message;
    }

    
    public String sacar(Double valor, Long conta) {
        String message = "";
        CurrentAccountPF saque = bancoRepository.findById(conta).get();

        if (saque.getSaldo() >= valor) {
            saque.setSaldo(saque.getSaldo() - valor);
            bancoRepository.save(saque);
            message = message + "R$" + valor + " sacado da conta de " + saque.getPerson().getName() + ".";

        } else {
            message = message + "Saldo insuficiente.";
        }

        return message;
    }

    
    public Double consultaSaldo(CurrentAccountPF conta) {
        return conta.getSaldo();
    }

    
    public String extrato(Long conta) {
        String message = "";

        CurrentAccountPF extrato = bancoRepository.findById(conta).get();

        return message + "Saldo da conta número " + extrato.getNumeroConta() + " de " + extrato.getPerson().getName()
                + " é de R$" + extrato.getSaldo() + ".";
    }

}
