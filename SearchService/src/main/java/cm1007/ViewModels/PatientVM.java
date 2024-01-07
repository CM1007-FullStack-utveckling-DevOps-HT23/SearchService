package cm1007.ViewModels;

import lombok.Getter;
import lombok.Setter;

public class PatientVM {
    @Getter @Setter
    public String patientId;

    @Getter @Setter
    public String patientName;

    public PatientVM(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }
}
