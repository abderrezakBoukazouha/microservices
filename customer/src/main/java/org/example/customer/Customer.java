package org.example.customer;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="customer")
public class Customer {

    @Id
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "customer_id_sequance"
   )
    private int id;

    private String name;

    private String mail;
}
