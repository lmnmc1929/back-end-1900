package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Manager;
import phim.itsol.domain.Role;


import javax.validation.constraints.NotNull;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ManagerDto {
    private Long managerId;
    @NotNull
    private String managerUsername;
    @NotNull
    private String managerPassword;

    private String managerName;
    private Boolean rememberMe;

    private List<Role> roleList;


    public ManagerDto(Manager manager){
        this.managerId = manager.getManagerId();
        this.managerUsername = manager.getManagerUsername();
        this.managerPassword = manager.getManagerPassword();
        this.managerName = manager.getManagerName();
        this.roleList = manager.getRoleList();
    }
}
