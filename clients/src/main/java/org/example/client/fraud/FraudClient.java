package org.example.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping("api/v1/fraud-check/isfraudster")
    boolean isFraudster(String mail);
}
