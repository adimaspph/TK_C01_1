package tk.apap.sibusiness.service;

import reactor.core.publisher.Mono;
import tk.apap.sibusiness.rest.BaseResponse;
import tk.apap.sibusiness.rest.CabangDetail;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tk.apap.sibusiness.rest.Setting;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CabangRestServiceImpl implements CabangRestService{
    private final WebClient webClient;

    public CabangRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siretailUrl).build();
    }

    @Override
    public Mono<String> permintaanCabang(CabangDetail cabang) {


        System.out.println(Mono.just(cabang).block());
        Mono<String> a = this.webClient
                .post()
                .uri("/rest/cabang/full")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(cabang), CabangDetail.class)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(String.class);
//        System.out.println(a.block());
        return a;
    }
}
