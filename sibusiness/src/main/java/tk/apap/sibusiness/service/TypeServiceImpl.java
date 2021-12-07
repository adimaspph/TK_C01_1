package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.TypeModel;
import tk.apap.sibusiness.repository.TypeDB;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDB typeDB;

    @Override
    public List<TypeModel> getCouponList() {
        return typeDB.findAll();
    }
}
