import org.eclipse.persistence.annotations.ChangeTracking;
import org.eclipse.persistence.annotations.ChangeTrackingType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ChangeTracking(ChangeTrackingType.ATTRIBUTE)
public class M2MInverse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    @javax.persistence.ManyToMany( cascade = { CascadeType.ALL }, mappedBy="inverses")
    private Set<M2MOwner> owners = new HashSet<>();
    
    public Set<M2MOwner> getOwners() {
        return owners;
    }
}
