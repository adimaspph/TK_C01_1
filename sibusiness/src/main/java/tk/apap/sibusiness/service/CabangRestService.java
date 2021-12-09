package tk.apap.sibusiness.service;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.rest.CabangDTO;

public interface CabangRestService {
    Mono<String> permintaanCabang(CabangDTO cabang);
}
