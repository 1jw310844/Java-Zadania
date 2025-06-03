package pl.zajecia.sklepczegos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Koszulki {
    @Id
    @GeneratedValue
    private long id;
    private String Name;
    private BigDecimal price;
    private String imgURL;

    public Koszulki(String name, BigDecimal price, String imgURL) {
        Name = name;
        this.price = price;
        this.imgURL = imgURL;
    }
}
