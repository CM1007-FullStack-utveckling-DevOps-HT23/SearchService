package cm1007;

import cm1007.Tables.Patient_T;
import cm1007.Tables.User_T;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User_T, Long> {

    public Uni<List<User_T>> findByFullName(String name) {
        return find("fullName LIKE CONCAT('%', ?1, '%') " +
                "AND role = DOCTOR", name)
                .list();
    }
}
