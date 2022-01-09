package com.tqi_evolution_avaliacao.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanResource {

    @Autowired
    LoanService loanService;

    @Autowired
    LoanRepository loanRepository;

    //Criar novo emprestimo
    @PostMapping
    public ResponseEntity<LoanCreate> save(@RequestBody LoanCreate createLoan) {

        if (createLoan == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        if (createLoan.getInstallments() < 1 || createLoan.getInstallments() > 60) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        if (createLoan.getDate_first_installment() == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        LoanCreate loanCreate = loanService.save(createLoan);

        return new ResponseEntity<>(loanCreate, HttpStatus.CREATED);
    }

    // Listar emprestimos do Cliente
    @GetMapping("/clientLoanList")
    public ResponseEntity<?> getByClientId(@Param("client_id") Long client_id){
        return new ResponseEntity<List<Loan>>(loanService.findByClientId(client_id), HttpStatus.OK);
    }

    // Detalhar emprestimo
    @GetMapping("/{id}")
    public LoanDetails loanDetails(@PathVariable Long id)
    {
        Loan loan = loanRepository.getOne(id);

        return new LoanDetails(loan);
    }
}
