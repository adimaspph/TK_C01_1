package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.repository.ItemRequestDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemRequestRestServiceImpl implements ItemRequestRestService{
    @Autowired
    private ItemRequestDB itemRequestDB;

    @Override
    public List<ItemRequestModel> getAllRequestItem() {
        return itemRequestDB.findAll();
    }

    @Override
    public Boolean deleteItemRequest(String uuid) {
        return itemRequestDB.deleteItemRequestModelByUuid(uuid);
    }

    @Override
    public ItemRequestModel addItemRequest(ItemRequestModel itemRequestModel) {
        itemRequestModel.setCluster("C01");
        itemRequestModel.setStatus(0);
        return itemRequestDB.save(itemRequestModel);
    }
}
