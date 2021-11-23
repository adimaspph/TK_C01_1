package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.RoleModel;
import tk.apap.sibusiness.repository.RoleDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDB roleDB;


    @Override
    public List<RoleModel> getListRole() {
        return roleDB.findAll();
    }
}