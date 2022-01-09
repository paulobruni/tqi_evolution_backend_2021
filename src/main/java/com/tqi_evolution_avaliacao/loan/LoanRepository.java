package com.tqi_evolution_avaliacao.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByClientId(@Param("id_cliente") Long client_id);
}
