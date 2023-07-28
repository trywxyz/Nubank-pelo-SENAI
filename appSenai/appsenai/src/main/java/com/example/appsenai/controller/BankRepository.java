package com.example.appsenai.controller;

// import com.example.appsenai.model.Conta;
import com.example.appsenai.model.CurrentAcountPF;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<CurrentAcountPF, Long> {
}