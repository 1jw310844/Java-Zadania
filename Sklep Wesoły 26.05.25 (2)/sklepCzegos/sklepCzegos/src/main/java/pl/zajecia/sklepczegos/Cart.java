package pl.zajecia.sklepczegos;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.zajecia.sklepczegos.model.Koszulki;
import pl.zajecia.sklepczegos.repository.KoszulkiRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

@Component
@Scope(value ="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
    private List<CartItem> cartItems=new ArrayList<>();
    private int licznik=0;
    private double sumaKoszyka =0.0;
    KoszulkiRepository kosz;

    /*public Cart(KoszulkiRepository kosz)
    {
        this.kosz = kosz;
        List<Koszulki> lista = new ArrayList();
        lista.addAll(kosz.findAll());
        for (Koszulki koszul:lista)
        {
            this.dodajKoszulke(koszul);
            this.dodajKoszulke(koszul);
        }
    }*/
    public void dodajKoszulke(Koszulki koszulka) {
        if (koszulka == null) return;

        getCartItemByItem(koszulka).ifPresentOrElse(
                CartItem::increaseCounter,
                () -> cartItems.add(new CartItem(koszulka))
        );

        recalculatePriceAndCounter();
    }
    public void recalculatePriceAndCounter() {
        this.sumaKoszyka = cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();

        this.licznik = cartItems.stream()
                .map(CartItem::getCounter)
                .reduce(0, Integer::sum);
    }
    private static class KoszykSum {
        int counter;
        double total;

        KoszykSum(int counter, double total) {
            this.counter = counter;
            this.total = total;
        }

        KoszykSum add(KoszykSum other) {
            return new KoszykSum(this.counter + other.counter, this.total + other.total);
        }
    }
    public void decreaseItem(Koszulki koszulka) {

        Optional<CartItem> oCartItem = getCartItemByItem(koszulka);
        if (oCartItem.isPresent()) {
            CartItem cartItem = oCartItem.get();
            cartItem.decreaseCounter();
            if (cartItem.hasZeroItems()) {
                removeAllItems(koszulka);
            }
        }
        recalculatePriceAndCounter();
    }

    private Optional<CartItem> getCartItemByItem(Koszulki item) {
        return cartItems.stream()
                .filter(cartItem -> cartItem.isEquals(item))
                .findFirst();
    }

    public void removeAllItems(Koszulki koszulka) {
        cartItems.removeIf(i-> i.isEquals(koszulka));
        recalculatePriceAndCounter();
    }

}
