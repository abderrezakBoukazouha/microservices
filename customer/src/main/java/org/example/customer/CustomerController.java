package org.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> newCustomer (@RequestParam String mail,@RequestParam String name)
    {
        customerService.addCustormer(2,name, mail);
        return ResponseEntity.ok("Customer correctly added");
    }

}
