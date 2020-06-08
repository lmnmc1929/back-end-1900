package phim.itsol.Domain;



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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMER_ID")
    private long CustomerId;

    @Column(name = "USERNAME")
    private String Username;

    @Column(name = "PASSWORD")
    private String Password;

    @Column(name = "FULL_NAME")
    private  String FullName;

    @Column(name = "GENDER")
    private  String Gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date DateOfBirth;

    @Column(name = "PHONE_NUMBER")
    private  String PhoneNumber;


}
