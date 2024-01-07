package cm1007.ViewModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class EncounterDetailsVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    String patientId;

    @Getter @Setter
    String doctorId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    LocalDateTime encounterDate;

    @Getter @Setter
    PatientVM patient;

    public EncounterDetailsVM(Long id, String patientId, String doctorId, LocalDateTime encounterDate, PatientVM patient) {
        this.id = id;
        this.patientId = patientId;
        this.encounterDate = encounterDate;
        this.patient = patient;
        this.doctorId = doctorId;
    }
}