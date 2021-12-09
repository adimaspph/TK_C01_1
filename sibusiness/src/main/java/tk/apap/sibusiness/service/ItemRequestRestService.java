package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.ItemRequestModel;
import java.util.List;

public interface ItemRequestRestService {
    List<ItemRequestModel> getAllRequestItem();
    Boolean deleteItemRequest(String uuid);
    ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel);
}
