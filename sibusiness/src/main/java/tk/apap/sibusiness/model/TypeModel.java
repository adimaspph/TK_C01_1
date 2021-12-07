package tk.apap.sibusiness.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

    @ManyToMany
    @JoinTable(
            name = "type_coupon",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id")
    )
    Set<CouponModel> listCoupon;
}
