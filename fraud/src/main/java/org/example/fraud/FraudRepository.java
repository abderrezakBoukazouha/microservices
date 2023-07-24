package org.example.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository <Fraud, Integer> {
    public Fraud findByMail(String mail);
}
