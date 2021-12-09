package tk.apap.sibusiness.service;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.rest.BaseResponse;
import tk.apap.sibusiness.rest.CabangDetail;

public interface CabangRestService {
    Mono<String> permintaanCabang(CabangDetail cabang);
}
