package cm1007;

import cm1007.ViewModels.UserVM;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;
import java.util.stream.Collectors;

@Path("/getDoctors")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    @Path("/byFullName")
    @Authenticated
    public Uni<List<UserVM>> getDoctorsByFullName(@QueryParam("fullName") String name) {
        return userRepository.findByFullName(name)
                .map(list -> list.stream()
                        .map(user -> new UserVM(user.getId(), user.getFullName()))
                        .collect(Collectors.toList())
                );
    }
}
