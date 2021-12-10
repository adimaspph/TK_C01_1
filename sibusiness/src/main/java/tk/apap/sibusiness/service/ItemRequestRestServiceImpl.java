package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.repository.ItemRequestDB;
import tk.apap.sibusiness.rest.Setting;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemRequestRestServiceImpl implements ItemRequestRestService{
    // INI NYOBA FITUR 15
    private final WebClient webClient;

    public ItemRequestRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
    }

    @Autowired
    private ItemRequestDB itemRequestDB;

    @Override
    public List<ItemRequestModel> getAllRequestItem() {
        return itemRequestDB.findAll();
    }
//
//    @Override
//    public Boolean rejectItemRequest(String uuid) {
//        return itemRequestDB.deleteItemRequestModelByUuid(uuid);
//    }

    @Override
    public ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel) {
        //itemRequestModel.setCluster("C01");
        itemRequestModel.setStatus(0);
        return itemRequestDB.save(itemRequestModel);
    }

    @Override
    public Mono<String> addItemToSIItem(ItemRequestModel itemRequestModel) {
        //return this.webClient
        Mono<String> i = this.webClient
                .post()
                .uri("api/item")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(itemRequestModel), ItemRequestModel.class)
                //.bodyValue(itemRequestModel)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(String.class);
        return i;
    }
//        MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
//        data.add("harga", itemRequestModel.getHarga());
//        data.add("kategori", itemRequestModel.getKategori());
//        data.add("nama", itemRequestModel.getNama());
//        data.add("stok", itemRequestModel.getStok());
//        return this.webClient.post().uri("/api/item")
//                .syncBody(data)
//                .retrieve()
//                .bodyToMono(String.class);

    @Override
    public ItemRequestModel findItemRequestModelByUuid(String uuid){
        return itemRequestDB.findItemRequestModelByUuid(uuid);
    }

    @Override
    public List<ItemRequestModel> getItemRequestFromStatus() {
        List<ItemRequestModel> status1 = itemRequestDB.findItemRequestModelByStatus(1);
        List<ItemRequestModel> status0 = itemRequestDB.findItemRequestModelByStatus(0);
        status0.addAll(status1);
        return status0;
    }

    @Override
    public ItemRequestModel acceptItemRequestStatus1(ItemRequestModel itemRequestModel) {
        itemRequestModel.setStatus(1);
        return itemRequestDB.save(itemRequestModel);
    }

    @Override
    public ItemRequestModel rejectItemRequestStatus2(ItemRequestModel itemRequestModel) {
        itemRequestModel.setStatus(2);
        return itemRequestDB.save(itemRequestModel);
    }
}
