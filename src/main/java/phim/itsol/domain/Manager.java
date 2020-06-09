package phim.itsol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MANAGER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @OneToOne
    @JoinColumn(name = "CINEMA_ID")
    private Cinema cinema;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANAGER_SEQ")
    @SequenceGenerator(sequenceName = "MANAGER_SEQ", allocationSize = 1,name = "MANAGER_SEQ")
    @Column(name = "MANAGER_ID")
    private Long mamagerId;

    @Column(name = "MANAGER_USERNAME")
    private String managerUsername;

    @Column (name = "MANAGER_PASSWORD")
    private String managerPassword;

    @Column(name = "MANAGER_NAME")
    private String managerName;

}