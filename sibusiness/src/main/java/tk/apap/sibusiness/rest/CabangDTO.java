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

    @JsonProperty("namaCabang")
    private String namaCabang;

    @JsonProperty("alamatCabang")
    private String alamatCabang;

    @JsonProperty("noTelpCabang")
    private String noTelpCabang;

    @JsonProperty("ukuranCabang")
    private Integer ukuranCabang;
}
