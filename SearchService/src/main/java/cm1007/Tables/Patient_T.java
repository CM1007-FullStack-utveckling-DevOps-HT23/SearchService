package cm1007.Tables;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patient_t")
public class Patient_T {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private String id;

    @Getter @Setter
    @Column(name = "full_name")
    private String fullName;

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Note_T> notes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Encounter_T> encounters = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Condition_T> conditions = new ArrayList<>();

    public Patient_T() {
    }

    public Patient_T(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
