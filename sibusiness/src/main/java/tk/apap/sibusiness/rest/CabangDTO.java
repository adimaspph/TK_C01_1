package tk.apap.sibusiness.rest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class CabangDTO {
    private String status;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("alamat")
    private String alamat;

    @JsonProperty("no_telp")
    private String no_telp;

    @JsonProperty("ukuran")
    private Integer ukuran;
}
