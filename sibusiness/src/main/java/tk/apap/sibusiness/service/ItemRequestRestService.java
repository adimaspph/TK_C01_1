package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.ItemRequestModel;
import java.util.List;

public interface ItemRequestRestService {
    List<ItemRequestModel> getAllRequestItem();
//    Boolean rejectItemRequest(String uuid);
    ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel);
    Object addItemToSIItem(ItemRequestModel itemRequestModel) throws Exception;
    ItemRequestModel findItemRequestModelByUuid(String uuid);
    List<ItemRequestModel> getItemRequestFromStatus();
    ItemRequestModel acceptItemRequestStatus1(ItemRequestModel itemRequestModel, String nama);
    ItemRequestModel rejectItemRequestStatus2(ItemRequestModel itemRequestModel);
}
