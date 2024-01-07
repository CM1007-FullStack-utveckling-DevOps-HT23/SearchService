package cm1007;

import cm1007.Tables.Encounter_T;
import cm1007.ViewModels.EncounterDetailsVM;
import cm1007.ViewModels.PatientVM;
import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("/getEncounters")
public class EncounterResource {
    @Inject
    EncounterRepository encounterRepository;

    @GET
    @Authenticated
    @Path("/byDate")
    public Uni<List<EncounterDetailsVM>> findByEncounterDate(
            @QueryParam("encounterDate") String encounterDateString,
            @QueryParam("doctorId") String doctorId) {

        return encounterRepository.findByEncounterDate(LocalDate.parse(encounterDateString), doctorId)
                .map(list -> list.stream()
                        .map(encounter -> new EncounterDetailsVM(
                                encounter.getId(),
                                encounter.getPatient().getId(),
                                encounter.getDoctorId(),
                                encounter.getEncounterDate(),
                                new PatientVM(
                                        encounter.getPatient().getId(),
                                        encounter.getPatient().getFullName())))
                        .collect(Collectors.toList())
                );
    }

    @GET
    @Authenticated
    @Path("/byDoctorId")
    public Uni<List<EncounterDetailsVM>> findByDoctorId(@QueryParam("doctorId") String doctorId) {
        return encounterRepository.findByDoctorId(doctorId)
                .map(list -> list.stream()
                        .map(encounter -> new EncounterDetailsVM(
                                encounter.getId(),
                                encounter.getPatient().getId(),
                                encounter.getDoctorId(),
                                encounter.getEncounterDate(),
                                new PatientVM(
                                        encounter.getPatient().getId(),
                                        encounter.getPatient().getFullName())))
                        .collect(Collectors.toList())
                );
    }

}
