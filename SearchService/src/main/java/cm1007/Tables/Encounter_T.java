package cm1007.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Encounter_T {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Column(name = "doctor_id")
    @Getter @Setter
    private Long doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private Patient_T patient;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Observation_T> observations = new ArrayList<>();

    @Column(name = "encounter_date")
    @Getter @Setter
    private LocalDateTime encounterDate;
}
