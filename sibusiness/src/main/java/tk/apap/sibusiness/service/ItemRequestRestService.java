package tk.apap.sibusiness.service;

import reactor.core.publisher.Mono;
import tk.apap.sibusiness.model.ItemRequestModel;
import java.util.List;

public interface ItemRequestRestService {
    List<ItemRequestModel> getAllRequestItem();
//    Boolean rejectItemRequest(String uuid);
    ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel);
    Mono<String> addItemToSIItem(ItemRequestModel itemRequestModel);
    ItemRequestModel findItemRequestModelByUuid(String uuid);
    List<ItemRequestModel> getItemRequestFromStatus();
    ItemRequestModel acceptItemRequestStatus1(ItemRequestModel itemRequestModel);
    ItemRequestModel rejectItemRequestStatus2(ItemRequestModel itemRequestModel);
}
