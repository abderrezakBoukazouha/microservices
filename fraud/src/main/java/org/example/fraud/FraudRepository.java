package org.example.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository <Fraud, Integer> {
    public Fraud findByMail(String mail);
}
