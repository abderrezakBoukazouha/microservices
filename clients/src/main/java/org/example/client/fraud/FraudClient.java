package org.example.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping("api/v1/fraud-check/isfraudster")
    boolean isFraudster(@RequestParam("mail") String mail);
}
