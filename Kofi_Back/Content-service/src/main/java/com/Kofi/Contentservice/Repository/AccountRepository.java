package com.Kofi.Contentservice.Repository;

import com.Kofi.Contentservice.model.Account;
import com.Kofi.Contentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
