package com.stdio.esm.repository;

import com.stdio.esm.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Account,Long> {
    Optional<Account> findByUsername(String name);
    List<Account> findAllByDeleteFlagFalse();
    Page<Account> findAllByDeleteFlagFalse(Pageable pageable);

}
