package org.example.fraud;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Fraud {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequance"
    )
    private Integer id;

    private String mail;

    private String name;
}
