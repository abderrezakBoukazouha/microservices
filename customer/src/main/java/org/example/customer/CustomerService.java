package org.example.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addCustormer(int id, String name, String mail) {

      Boolean isfraudster = restTemplate.getForObject(
              "http://FRAUD/isfraudster?mail="+mail,
              Boolean.class
      );

      if (Boolean.TRUE.equals(isfraudster)) {
          throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Customer is a Fraudster");
      }

            final Customer customer = Customer.builder()
                    .name(name)
                    .mail(mail)
                    .build();

            customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
