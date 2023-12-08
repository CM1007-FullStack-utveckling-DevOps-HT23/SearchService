package cm1007.Tables;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="observation_t")
public class Observation_T {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    //One condition can have multiple observations why the patient has the condition
    @ManyToOne
    @JoinColumn(name = "encounter_id") // Foreign key referencing Encounter table
    @Getter @Setter
    private Encounter_T encounter;

    @Column(name = "observation_details")
    @Getter @Setter
    private String observationDetails;

    public Observation_T() {
    }

    public Observation_T(Encounter_T encounter, String observation_details) {
        this.observationDetails = observation_details;
        this.encounter = encounter;
    }
}
