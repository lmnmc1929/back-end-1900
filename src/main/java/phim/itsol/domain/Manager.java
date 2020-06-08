package phim.itsol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MANAGER")
@Getter
@Setter
public class Manager {

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @OneToOne
    @JoinColumn(name = "CINEMA_ID")
//    private Cinema cinema;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANA_SEQ")
    @SequenceGenerator(sequenceName = "MANAGER_SEQ", allocationSize = 1,name = "MANA_SEQ")
    @Column(name = "MANAGER_ID")
    private Long mamagerId;

    @Column(name = "MANAGER_USERNAME")
    private String managerUsername;

    @Column (name = "MANAGER_PASSWORD")
    private String managerPassword;

    @Column(name = "MANAGER_NAME")
    private String managerName;

}
