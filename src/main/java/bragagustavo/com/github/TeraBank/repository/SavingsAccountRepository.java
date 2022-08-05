package bragagustavo.com.github.TeraBank.repository;

import bragagustavo.com.github.TeraBank.domain.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository <SavingsAccount, Integer> {

}