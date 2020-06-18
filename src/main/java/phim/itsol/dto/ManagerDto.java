package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Manager;
import phim.itsol.domain.Role;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ManagerDto {
    private Long managerId;

    private Long cinemaId;

    private String managerUsername;


    private String managerPassword;

    private String managerName;
    private Boolean rememberMe;

    private Set<Role> roleList;

    private String[] roles;

    public ManagerDto(Manager manager){
        this.cinemaId = manager.getCinema().getCinemaId();
        this.managerUsername = manager.getManagerUsername();
        this.managerPassword = manager.getManagerPassword();
        this.managerName = manager.getManagerName();
        this.roleList = manager.getRoleList();

    }
}
