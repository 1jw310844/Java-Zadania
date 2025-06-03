package pl.zajecia.sklepczegos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zajecia.sklepczegos.model.Koszulki;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Koszulki koszulki;
    private int counter;
    private BigDecimal price;
    public CartItem(Koszulki kosz)
    {
        this.koszulki = kosz;
        this.counter = 1;
        this.price = koszulki.getPrice();
    }
    public CartItem(Koszulki koszulki, int counter) {
        this.koszulki = koszulki;
        this.counter = counter;
        this.price = koszulki.getPrice().multiply(new BigDecimal(counter));
    }
    public void increaseCounter()
    {
        counter++;
        price = koszulki.getPrice().multiply(new BigDecimal(counter));
    }
    public void decreaseCounter()
    {
        if(!hasZeroItems())
        {
            --counter;
            recalculate();
        }
    }
    public void recalculate()
    {
        price = koszulki.getPrice().multiply(new BigDecimal(counter));
    }
    public boolean hasZeroItems(){return counter==0;}
    public boolean isEquals(Koszulki item) {
        return this.koszulki != null && item != null &&
                this.koszulki.getId() == item.getId();
    }
}
