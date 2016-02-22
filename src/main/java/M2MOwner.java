import org.eclipse.persistence.annotations.ChangeTracking;
import org.eclipse.persistence.annotations.ChangeTrackingType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ChangeTracking(ChangeTrackingType.ATTRIBUTE)
public class M2MOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="m2m_owner_inverse")
    private Set<M2MInverse> inverses = new HashSet<>();

    public Set<M2MInverse> getInverses() {
        return inverses;
    }
}
