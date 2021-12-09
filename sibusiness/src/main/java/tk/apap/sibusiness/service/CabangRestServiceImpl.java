package tk.apap.sibusiness.service;

import reactor.core.publisher.Mono;
import tk.apap.sibusiness.rest.CabangDTO;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tk.apap.sibusiness.rest.Setting;

import javax.transaction.Transactional;

@Service
@Transactional
public class CabangRestServiceImpl implements CabangRestService{
    private final WebClient webClient;

    public CabangRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siretailUrl).build();
    }

    @Override
    public Mono<String> permintaanCabang(CabangDTO cabang) {


//        System.out.println(Mono.just(cabang).block());
        Mono<String> a = this.webClient
                .post()
                .uri("/api/cabang")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(cabang), CabangDTO.class)
//                .bodyValue(cabang)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(String.class);
//        System.out.println(a.block());
        return a;
    }
}
