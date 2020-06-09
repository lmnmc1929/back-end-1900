package phim.itsol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ROLE")
@NoArgsConstructor
@AllArgsConstructor

public class Role {

    @OneToMany(targetEntity = Manager.class)
    private List<Manager> managerList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(sequenceName = "ROLE_SEQ", allocationSize = 1,name = "ROLE_SEQ")
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;
}