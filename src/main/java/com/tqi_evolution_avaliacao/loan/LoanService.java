package com.tqi_evolution_avaliacao.loan;

import com.tqi_evolution_avaliacao.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    //Detalhar Emprestimos
    public List<Loan> findById(Long id)
    {
        Optional<Loan> loans = loanRepository.findById(id);

        return loans.stream().map(Loan::new).collect(Collectors.toList());
    }

    //Listar Emprestimos
    public List<Loan> findByClientId(Long id)
    {
        List<Loan> loans = loanRepository.findByClientId(id);

        return loans.stream().map(x -> new Loan(x)).collect(Collectors.toList());
    }

    //Criar Emprestimo
    public LoanCreate save(LoanCreate newLoan) {
        Loan loan = new Loan();
        loan.setClient_id(newLoan.getClient_id());
        loan.setValue(newLoan.getValue());
        loan.setDate_first_installment(newLoan.getDate_first_installment());
        loan.setInstallments(newLoan.getInstallments());
        loan.setClient(clientRepository.findById(newLoan.getClient_id()).get());

        loan = loanRepository.save(loan);

        return newLoan;
    }
}
