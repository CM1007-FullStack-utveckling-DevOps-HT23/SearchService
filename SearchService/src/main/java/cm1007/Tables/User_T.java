package cm1007.Tables;

import cm1007.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_t")
public class User_T {
    @Id
    @Getter
    private String id;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;

    @Getter @Setter
    @Column(name = "full_name")
    private String fullName;

    public User_T() {
    }
}
