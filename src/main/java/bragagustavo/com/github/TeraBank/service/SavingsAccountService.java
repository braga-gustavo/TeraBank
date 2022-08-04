package bragagustavo.com.github.TeraBank.service;

import bragagustavo.com.github.TeraBank.domain.dto.SavingsAccountDto;
import bragagustavo.com.github.TeraBank.domain.entity.SavingsAccount;
import bragagustavo.com.github.TeraBank.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsAccountService {


    @Autowired
    SavingsAccountRepository savingsAccountRepository;
    public void createSavingsAccount(SavingsAccount savingsAccount) {
    }

    public SavingsAccount find(Integer id) {
        return null;
    }

    public List<SavingsAccount> findAll(){
        return savingsAccountRepository.findAll();
    }

    public SavingsAccount fromDto(SavingsAccountDto savingsAccountDto) {
        return null;
    }

    public void updateSavingsAccount(SavingsAccount savingsAccount) {
    }

    public void deleteSavingsAccount(Integer id) {
    }


}
