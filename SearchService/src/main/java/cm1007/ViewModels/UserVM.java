package cm1007.ViewModels;

import lombok.Getter;
import lombok.Setter;

public class UserVM {
    @Getter @Setter
    public String userId;

    @Getter @Setter
    public String doctorName;

    public UserVM(String userId, String doctorName) {
        this.userId = userId;
        this.doctorName = doctorName;
    }
}
