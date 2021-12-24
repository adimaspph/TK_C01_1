package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.TypeModel;
import tk.apap.sibusiness.repository.CouponDB;
import tk.apap.sibusiness.repository.TypeDB;
import tk.apap.sibusiness.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.*;

@Service
@Transactional
public class TypeRestServiceImpl implements TypeRestService {

    @Autowired
    private TypeDB typeDB;

    @Override
    public TypeModel getTypeByIdType(Long id) {
        Optional<TypeModel> type = typeDB.findById(id);
        if (type.isPresent()) {
            return type.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
