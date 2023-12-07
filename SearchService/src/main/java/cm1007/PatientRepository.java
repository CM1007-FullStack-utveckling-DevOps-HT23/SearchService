package cm1007;

import cm1007.Tables.Patient_T;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PatientRepository implements PanacheRepositoryBase<Patient_T, Long> {

    @WithTransaction
    public Uni<List<Patient_T>> findByFullName(String name){
        return find("fullName LIKE '?1'", name).list();
    }

    public Uni<List<Patient_T>> findByConditionType(String conditionType){
        return find("SELECT DISTINCT p FROM Patient_T p " +
                "JOIN p.conditions c " +
                "WHERE c.conditionType = ?1", conditionType)
                .list();
    }

    public Uni<List<Patient_T>> findByEncounterDate(LocalDate encounterDate, Long doctorId){
        return find("SELECT DISTINCT p FROM Patient_T p " +
                "JOIN p.encounters e " +
                "WHERE e.encounterDate = ?1" +
                "AND e.doctorId = ?2",
                encounterDate, doctorId)
                .list();
    }
}
