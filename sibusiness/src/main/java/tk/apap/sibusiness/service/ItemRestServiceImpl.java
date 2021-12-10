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
public class ItemRestServiceImpl implements ItemRestService {
    private final WebClient webClient;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
    }

    @Override
    public List<Map<String, Object>> getItemByKategori(Integer kategori) {

        try {
            Mono<Map> itemByKategori = this.webClient.get().uri("/api/item/kategori/"+kategori)
                    .retrieve()
                    .bodyToMono(Map.class);

            List listItem = (List) itemByKategori.block().get("result");
            return listItem;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Map<String, Object> getItemById(String uuid) {

        try {
            Mono<Map> itemByKategori = this.webClient.get().uri("/api/item/" + uuid)
                    .retrieve()
                    .bodyToMono(Map.class);

            Map item = (Map) itemByKategori.block().get("result");
            return item;
        } catch (Exception e) {
            return null;
        }
    }
}
