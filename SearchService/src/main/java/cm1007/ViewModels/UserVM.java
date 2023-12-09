package cm1007.ViewModels;

import lombok.Getter;
import lombok.Setter;

public class UserVM {
    @Getter @Setter
    public Long userId;

    @Getter @Setter
    public String doctorName;

    public UserVM(Long userId, String doctorName) {
        this.userId = userId;
        this.doctorName = doctorName;
    }
}
