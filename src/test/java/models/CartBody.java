package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class CartBody {
    Integer userId;
    String date;
    public List<ListProductsData> products;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListProductsData {
        Integer productId, quantity;
    }

}
