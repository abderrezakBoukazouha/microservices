package org.example.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudService fraudService;

    @GetMapping("fraudsters")
    public void addingFraudulent () {
        fraudService.addFraudulents();
    }

    @GetMapping("isfraudster")
    public boolean isFraudster(@RequestParam String mail) {
        return fraudService.checkPresence(mail);
    }

    @GetMapping
    public List<Fraud> getFraudsters() {
        return fraudService.getFraudsters();
    }
}
