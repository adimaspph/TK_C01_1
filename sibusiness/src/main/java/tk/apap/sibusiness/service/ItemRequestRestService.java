package tk.apap.sibusiness.service;

import reactor.core.publisher.Mono;
import tk.apap.sibusiness.model.ItemRequestModel;
import java.util.List;

public interface ItemRequestRestService {
    List<ItemRequestModel> getAllRequestItem();
    Boolean deleteItemRequest(String uuid);
    ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel);
    Mono<String> addItemToSIItem(ItemRequestModel itemRequestModel);
    ItemRequestModel findItemRequestModelByUuid(String uuid);
}
