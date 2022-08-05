package bragagustavo.com.github.TeraBank.controller;


import bragagustavo.com.github.TeraBank.domain.dto.SavingsAccountDto;

import bragagustavo.com.github.TeraBank.domain.entity.SavingsAccount;
import bragagustavo.com.github.TeraBank.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sa")
public class SavingsAccountController {

    @Autowired
    SavingsAccountService savingsAccountService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createSavingsAccount(@RequestBody @Valid SavingsAccount savingsAccount) {
        savingsAccountService.createSavingsAccount(savingsAccount);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savingsAccount.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SavingsAccount> findSavingsAccount(@PathVariable Integer id){
        SavingsAccount savingsAccount = savingsAccountService.find(id);
        return ResponseEntity.ok().body(savingsAccount);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SavingsAccount>> findAll(){
        List<SavingsAccount> list = savingsAccountService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSavingsAccount(@PathVariable Integer id, @Valid @RequestBody SavingsAccountDto savingsAccountDto){
        SavingsAccount savingsAccount = savingsAccountService.fromDto(savingsAccountDto);
        savingsAccount.setId(id);
        savingsAccountService.updateSavingsAccount(savingsAccount);
        return ResponseEntity.noContent().build();


    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Integer id){
        savingsAccountService.deleteSavingsAccount(id);
        return ResponseEntity.noContent().build();
    }

}
