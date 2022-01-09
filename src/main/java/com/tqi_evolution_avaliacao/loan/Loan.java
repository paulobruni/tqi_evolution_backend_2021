package com.tqi_evolution_avaliacao.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tqi_evolution_avaliacao.client.Client;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@JsonIgnoreProperties({"client","client_id","date_first_installment"})
public class Loan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    @Column(name = "id_cliente", insertable = false, updatable = false)
    private Long client_id;

    @Column(name = "valor")
    private Double value;

    @Column(name = "parcelas")
    private int installments;

    @Column(name = "data_pri_par")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("date_first_installment")
    private LocalDate date_first_installment;

    public Loan() {
        this.id = getId();
        this.client_id = getClient_id();
        this.value = getValue();
        this.installments = getInstallments();
        this.date_first_installment = getDate_first_installment();
    }

    public Loan(Loan loan) {
        this.id = loan.getId();
        this.value = loan.getValue();
        this.installments = loan.getInstallments();
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        this.installments = installments;
    }

    public LocalDate getDate_first_installment() {
        return date_first_installment;
    }

    public void setDate_first_installment(LocalDate date_first_installment) {
        this.date_first_installment = date_first_installment;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}


