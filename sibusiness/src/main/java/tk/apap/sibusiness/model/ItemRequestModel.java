package tk.apap.sibusiness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="itemRequest")

public class ItemRequestModel {

    @Id
    @Size(max = 200)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String uuid;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "harga", nullable = false)
    private Integer harga;

    @NotNull
    @Column(name = "stok", nullable = false)
    private Integer stok;

    @NotNull
    @Column(name = "kategori", nullable = false)
    private Integer kategori;

    @NotNull
    @Column(nullable = false)
    private Integer status;

    @Size(max=200)
    @Column(nullable = true)
    private String approver;

    @NotNull
    @Size(max=50)
    @Column(nullable = false)
    private String cluster;
}
