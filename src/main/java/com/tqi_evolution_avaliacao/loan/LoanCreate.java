package com.tqi_evolution_avaliacao.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
public class LoanCreate {

    public static final int MAX_MONTH_DIFFERENCE = 3;

    private Long client_id;
    private Double value;
    private int installments;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("date_first_installment")
    private LocalDate date_first_installment;

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {

        if (installments < 1 || installments > 60) return;
        else
            this.installments = installments;
    }

    public LocalDate getDate_first_installment() {
        return date_first_installment;
    }

    public void setDate_first_installment(LocalDate date_first_installment) {

        Period period = Period.between(LocalDate.now(), date_first_installment);

        if (period.getMonths() > MAX_MONTH_DIFFERENCE) return ;
        else {
            this.date_first_installment = date_first_installment;
        }
    }
}
