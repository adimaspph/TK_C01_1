package tk.apap.sibusiness.service;

import java.util.List;
import java.util.Map;

public interface ItemRestService {
    List<Map<String, Object>> getItemByKategori(Integer kategori);
    Map<String, Object> getItemById(String uuid);
}
