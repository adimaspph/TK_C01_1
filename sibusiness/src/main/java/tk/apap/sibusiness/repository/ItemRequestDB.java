package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.model.UserModel;

public interface ItemRequestDB extends JpaRepository<ItemRequestModel, Long> {
    ItemRequestModel findItemRequestModelByUuid(String uuid);
    Boolean deleteItemRequestModelByUuid(String uuid);
}
