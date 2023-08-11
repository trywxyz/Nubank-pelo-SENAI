package com.example.appsenai.model;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class CurrentAccountPF{

    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;
    private Double saldo;

    @Column(name = "type")
    private AccountType accountType;

    //private Person pessoa;

    @OneToOne
    private Person person;

    @Transient
    private String error;



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    /*public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }*/

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}