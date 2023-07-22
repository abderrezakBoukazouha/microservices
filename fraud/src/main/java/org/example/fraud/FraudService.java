package org.example.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;

    public void addFraudulents () {
        fraudRepository.saveAll(List.of(Fraud.builder().mail("djamila.boured@gmail.com").build(),
                Fraud.builder().mail("moussa.ka@gmail.com").build()));
    }

    public boolean checkPresence(String mail) {
       return fraudRepository.findAll().stream().anyMatch(fraud -> fraud.getMail().equals(mail));

    }
}
