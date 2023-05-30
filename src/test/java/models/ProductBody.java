package models;

import lombok.Data;

@Data
public class ProductBody {
    String title, description, image, category;
    Double price;
}
