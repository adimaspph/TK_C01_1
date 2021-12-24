package tk.apap.sibusiness.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.rest.Setting;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MesinRestServiceImpl implements MesinRestService {
    private final WebClient webClient;

    public MesinRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siFactoryUrl).build();
    }

    @Override
    public List<Map<String, Object>> getAllMesin() {
        try {
            Mono<List> api = this.webClient.get().uri("/api/v1/list-mesin")
                    .retrieve()
                    .bodyToMono(List.class);

            List data = (List) api.block();

            return data;
        } catch (Exception e) {
            return null;
        }
    }
}
