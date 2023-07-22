package org.example.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fraud")
@AllArgsConstructor
public class fraudController {
    private final FraudService fraudService;

    @GetMapping("fraudsters")
    public void addingFraudulent () {
        fraudService.addFraudulents();
    }

    @GetMapping("isfraudster")
    public boolean isFraudster(@RequestParam String mail) {
        return fraudService.checkPresence(mail);
    }
}
