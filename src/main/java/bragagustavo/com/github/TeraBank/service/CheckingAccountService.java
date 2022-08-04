package bragagustavo.com.github.TeraBank.service;

import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountDto;
import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountDto2;
import bragagustavo.com.github.TeraBank.domain.entity.CheckingAccount;
import bragagustavo.com.github.TeraBank.exception.ObjectNotFoundException;
import bragagustavo.com.github.TeraBank.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;


    CheckingAccountDto2 checkingAccountDto2;

    CheckingAccount cAccount;

    public Double generateNumber(){
        return Math.floor(Math.random()*10000);
    }


    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        checkingAccount.setId(null);
        checkingAccount.setAgency("001");
        checkingAccount.setBalance(BigDecimal.valueOf(0));
        checkingAccount.setNumber(generateNumber());

        return checkingAccountRepository.save(checkingAccount);
    }

    public CheckingAccountDto2 find(Integer id) {
        Optional<CheckingAccount> checkingAccount = checkingAccountRepository.findById(id);



               CheckingAccountDto2 dtoAccount = converterDto(checkingAccountDto2, cAccount);
               CheckingAccount ca = new CheckingAccount();

             return dtoAccount;

       /* try{


        }catch (ObjectNotFoundException e ){

            throw new ObjectNotFoundException("Conta não encontrada: " + id);
        }
*/

    }

    public List<CheckingAccount> findAll() {
        return checkingAccountRepository.findAll();
    }


    public CheckingAccount updateCheckingAccount(CheckingAccount checkingAccount) {
        CheckingAccount checkingAccountToUpdate = find(checkingAccount.getId());
        updateData(checkingAccountToUpdate, checkingAccount);
        return checkingAccountRepository.save(checkingAccountToUpdate);
    }

    private void updateData(CheckingAccount checkingAccountToUpdate, CheckingAccount checkingAccount) {
        checkingAccountToUpdate.setAdress(checkingAccount.getAdress());
        checkingAccountToUpdate.setEmail(checkingAccount.getEmail());
        checkingAccountToUpdate.setPassword(checkingAccount.getPassword());
    }

    public void deleteCheckingAccount(Integer id) {
        find(id);
        try {
            checkingAccountRepository.deleteById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Conta não encontrada para ser deletada não encontrada: ");
        }

    }

    public CheckingAccount fromDto(CheckingAccountDto checkingAccountDto) {
        return new CheckingAccount(checkingAccountDto.getId(),checkingAccountDto.getAdress(),  null,
                null, null, null, checkingAccountDto .getEmail(), null,
                checkingAccountDto.getPassword(), null);

    }

    public CheckingAccountDto2 converterDto(CheckingAccountDto2 checkingAccountDto2, CheckingAccount checkingAccount) {


        return new CheckingAccountDto2(checkingAccountDto2.getId(), checkingAccountDto2.getName(),  checkingAccountDto2.
                getAdress(),checkingAccountDto2.getAgency(), checkingAccountDto2.getCpf(),
                null, checkingAccountDto2 .getEmail(), checkingAccountDto2.getEmail(),
                 checkingAccountDto2.getNumber());


    }
}
