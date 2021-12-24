package tk.apap.sibusiness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemRequestModel {

    @Id
    @Size(max = 200)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String uuid;

    @JsonProperty("nama")
    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @JsonProperty("harga")
    @NotNull
    @Column(name = "harga", nullable = false)
    private Integer harga;

    @JsonProperty("stok")
    @NotNull
    @Column(name = "stok", nullable = false)
    private Integer stok;

    @JsonProperty("kategori")
    @NotNull
    @Column(name = "kategori", nullable = false)
    private Integer kategori;

    @NotNull
    @Column(nullable = false)
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "approver", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserModel approver;

//    @NotNull
//    @Size(max=50)
//    @Column(nullable = false)
//    private String cluster;

}
