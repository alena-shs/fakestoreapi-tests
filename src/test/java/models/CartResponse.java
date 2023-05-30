package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponse {
    Integer id, userId, __v;
    String date;
    public List<CartBody.ListProductsData> products;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListProductsData {
        Integer productId, quantity;
    }
}
