package cm1007;

import cm1007.Tables.Encounter_T;
import cm1007.Tables.Patient_T;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EncounterRepository implements PanacheRepositoryBase<Encounter_T, Long> {
    public Uni<List<Encounter_T>> findByEncounterDate(LocalDate encounterDate, Long doctorId){
        return find("SELECT e FROM Encounter_T e " +
                        "JOIN FETCH e.patient p " +
                        "WHERE DATE(e.encounterDate) = ?1 " +
                        "AND e.doctorId = ?2",
                encounterDate, doctorId)
                .list();
    }

    public Uni<List<Encounter_T>>findByDoctorId(Long doctorId){
        return find("SELECT e FROM Encounter_T e " +
                        "JOIN FETCH e.patient p " +
                        "WHERE e.doctorId = ?1 " +
                        "ORDER BY e.encounterDate ASC", doctorId)
                .list();
    }
}



/*
        return find("SELECT DISTINCT p FROM Patient_T p " +
                "JOIN p.encounters e " +
                "WHERE DATE(e.encounterDate) = ?1 " +
                "AND e.doctorId = ?2",
                encounterDate, doctorId)
                .list();
 */
