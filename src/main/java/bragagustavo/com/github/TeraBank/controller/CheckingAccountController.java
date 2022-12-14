package bragagustavo.com.github.TeraBank.controller;

import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountDto;
import bragagustavo.com.github.TeraBank.domain.dto.CheckingAccountNoPassword;
import bragagustavo.com.github.TeraBank.domain.entity.CheckingAccount;
import bragagustavo.com.github.TeraBank.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ca")
public class CheckingAccountController {

    @Autowired
    CheckingAccountService checkingAccountService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount) {
        checkingAccountService.createCheckingAccount(checkingAccount);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(checkingAccount.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CheckingAccountNoPassword> findCheckingAccount(@PathVariable Integer id) {
        CheckingAccount checkingAccount = checkingAccountService.find(id);
        CheckingAccountNoPassword noPassword = checkingAccountService.converterDto(checkingAccount);
        return ResponseEntity.ok().body(noPassword);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CheckingAccount>> findAll() {
        List<CheckingAccount> list = checkingAccountService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCheckingAccount(@PathVariable Integer id,
                                                      @Valid @RequestBody CheckingAccountDto checkingAccountDto) {
        CheckingAccount checkingAccount = checkingAccountService.fromDto(checkingAccountDto);
        checkingAccount.setId(id);
        checkingAccountService.updateCheckingAccount(checkingAccountDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCheckingAccount(@PathVariable Integer id) {
        checkingAccountService.deleteCheckingAccount(id);
        return ResponseEntity.noContent().build();
    }

}
