package com.tqi_evolution_avaliacao.loan;

import java.time.LocalDate;

public class LoanDetails {

    private Long id;
    private final Double value;
    private final int installments;
    private final LocalDate first_installment;
    private final String email;
    private final Double income;

    public LoanDetails(Loan loan) {
        this.id = loan.getId();
        this.value = loan.getValue();
        this.installments = loan.getInstallments();
        this.first_installment = loan.getDate_first_installment();
        this.email = loan.getClient().getEmail();
        this.income = loan.getClient().getIncome();
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public int getInstallments() {
        return installments;
    }

    public LocalDate getFirst_installment() {
        return first_installment;
    }

    public String getEmail() {
        return email;
    }

    public Double getIncome() {
        return income;
    }

}
