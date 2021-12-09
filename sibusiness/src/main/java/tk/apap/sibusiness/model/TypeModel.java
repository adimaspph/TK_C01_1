package tk.apap.sibusiness.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="type")
public class TypeModel implements Serializable {
    @Id
    @NotNull
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(nullable = false)
    private String useDay;

    @ManyToMany(mappedBy = "listType", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = CouponModel.class)
    private Set<CouponModel> listCoupon = new HashSet<>();
}
