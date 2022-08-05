package bragagustavo.com.github.TeraBank.service;

import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountDto;
import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountNoPassword;
import bragagustavo.com.github.TeraBank.domain.entity.CheckingAccount;
import bragagustavo.com.github.TeraBank.exception.ObjectNotFoundException;
import bragagustavo.com.github.TeraBank.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    public Double generateNumber() {
        return Math.floor(Math.random() * 10000);
    }

    public CheckingAccount find(Integer id) {
        return checkingAccountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found"));
    }

    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        checkingAccount.setId(null);
        checkingAccount.setAgency("001");
        checkingAccount.setBalance(BigDecimal.valueOf(0));
        checkingAccount.setNumber(generateNumber());
        return checkingAccountRepository.save(checkingAccount);
    }

    public List<CheckingAccount> findAll() {
        return checkingAccountRepository.findAll();
    }

    public CheckingAccount updateCheckingAccount(CheckingAccountDto accountDto) {
        CheckingAccount checkingAccountToUpdate = find(accountDto.getId());
        updateData(checkingAccountToUpdate, accountDto);
        return checkingAccountRepository.save(checkingAccountToUpdate);
    }

    private void updateData(CheckingAccount checkingAccountToUpdate, CheckingAccountDto accountDto) {
        checkingAccountToUpdate.setAdress(accountDto.getAdress());
        checkingAccountToUpdate.setEmail(accountDto.getEmail());
        checkingAccountToUpdate.setPassword(accountDto.getPassword());
    }

    public void deleteCheckingAccount(Integer id) {
        find(id);
        try {
            checkingAccountRepository.deleteById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Account not found");
        }
    }

    public CheckingAccount fromDto(CheckingAccountDto checkingAccountDto) {
        return CheckingAccount.builder()
                .id(checkingAccountDto.getId())
                .name(null)
                .adress(checkingAccountDto.getAdress())
                .agency(null)
                .cpf(null)
                .balance(null)
                .birth(null)
                .email(checkingAccountDto.getEmail())
                .password(checkingAccountDto.getPassword())
                .number(null)
                .build();

    }

    public CheckingAccountNoPassword converterDto(
            CheckingAccount checkingAccount) {

        return CheckingAccountNoPassword.builder()
                .id(checkingAccount.getId())
                .name(checkingAccount.getName())
                .adress(checkingAccount.getAdress())
                .agency(checkingAccount.getAgency())
                .cpf(checkingAccount.getCpf())
                .balance(checkingAccount.getBalance())
                .birth(checkingAccount.getBirth())
                .email(checkingAccount.getEmail())
                .number(checkingAccount.getNumber())
                .build();
    }

}