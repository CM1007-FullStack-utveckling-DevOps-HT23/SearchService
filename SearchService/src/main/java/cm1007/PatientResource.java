package cm1007;

import cm1007.ViewModels.PatientVM;
import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.stream.Collectors;

@Path("/getPatients")
public class PatientResource {
    @Inject
    PatientRepository patientRepository;

    @GET
    @Authenticated
    @Path("/byFullName")
    public Uni<List<PatientVM>> getPatientsByFullName(@QueryParam("fullName") String name) {
        return patientRepository.findByFullName(name)
                .map(list -> list.stream()
                        .map(patient -> new PatientVM(patient.getId(), patient.getFullName()))
                        .collect(Collectors.toList())
                );
    }

    @GET
    @Authenticated
    @Path("/byConditionType")
    public Uni<List<PatientVM>> getPatientsByConditionType(@QueryParam("conditionType") String conditionType) {
        return patientRepository.findByConditionType(conditionType)
                .map(list -> list.stream()
                        .map(patient -> new PatientVM(patient.getId(), patient.getFullName()))
                        .collect(Collectors.toList())
                );
    }

    @GET
    @Authenticated
    @Path("/byDoctorId")
    public Uni<List<PatientVM>> getPatientsByDoctorFullName(
            @QueryParam("doctorId") String doctorId){

        return patientRepository.findByDoctorId(doctorId)
                .map(list -> list.stream()
                        .map(patient -> new PatientVM(patient.getId(), patient.getFullName()))
                        .collect(Collectors.toList())
                );
    }
}
