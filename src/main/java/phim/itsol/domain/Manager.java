package phim.itsol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MANAGER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Manager {

    @ManyToMany
    @JoinTable(
            name = "MANAGER_ROLE",
            joinColumns = {@JoinColumn(name = "MANAGER_ID", referencedColumnName = "MANAGER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    @BatchSize(size = 20)
    private Set<Role> roleList;

    @OneToOne
    @JoinColumn(name = "CINEMA_ID")
    private Cinema cinema;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANAGER_SEQ")
    @SequenceGenerator(sequenceName = "MANAGER_SEQ", allocationSize = 1,name = "MANAGER_SEQ")
    @Column(name = "MANAGER_ID")
    private Long managerId;

    @Column(name = "MANAGER_USERNAME")
    private String managerUsername;

    @Column (name = "MANAGER_PASSWORD")
    private String managerPassword;

    @Column(name = "MANAGER_NAME")
    private String managerName;

}