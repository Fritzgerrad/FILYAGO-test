package com.filyago.demo.repository;

import com.filyago.demo.model.Tailor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Transactional
@Repository
public interface TailorRepository extends JpaRepository<Tailor, Long>, JpaSpecificationExecutor<Tailor> {
    @Query("SELECT u.username FROM Tailor u WHERE u.username = ?1")
    public List<String> findByUsername(String username);

}
