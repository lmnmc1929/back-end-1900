package phim.itsol.domain;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @OneToOne(targetEntity = Ticket.class)
    private Ticket ticket;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private  String fullName;

    @Column(name = "GENDER")
    private  String gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "PHONE_NUMBER")
    private  String phoneNumber;
}
