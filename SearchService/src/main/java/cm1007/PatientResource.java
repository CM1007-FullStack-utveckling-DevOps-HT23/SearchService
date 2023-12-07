package cm1007;

import cm1007.Tables.Patient_T;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Path("/getPatients")
public class PatientResource {
    @Inject
    PatientRepository patientRepository;

    @GET
    @Path("/byFullName")
    public Uni<List<Patient_T>> getPatientsByName(@QueryParam("name") String name) {
        return patientRepository.findByFullName(name);
    }

    @GET
    @Path("/byConditionType")
    public Uni<List<PatientVM>> getPatientsByConditionType(@QueryParam("conditionType") String conditionType) {
        return patientRepository.findByConditionType(conditionType)
                .map(list -> list.stream()
                        .map(patient -> new PatientVM(patient.getId(), patient.getFullName()))
                        .collect(Collectors.toList())
                );
    }

    @GET
    @Path("/byEncounterDate")
    public Uni<List<PatientVM>> getPatientsByEncounterDate(
            @QueryParam("encounterDate") String encounterDateString,
            @QueryParam("doctorId") Long doctorId){

        return patientRepository.findByEncounterDate(LocalDate.parse(encounterDateString), doctorId)
                .map(list -> list.stream()
                        .map(patient -> new PatientVM(patient.getId(), patient.getFullName()))
                        .collect(Collectors.toList())
                );
    }
}
