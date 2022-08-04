package bragagustavo.com.github.TeraBank.repository;

import bragagustavo.com.github.TeraBank.domain.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository <CheckingAccount, Integer> {
}
