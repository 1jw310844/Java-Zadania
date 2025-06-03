package pl.zajecia.sklepczegos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zajecia.sklepczegos.Cart;
import pl.zajecia.sklepczegos.CartItem;
import pl.zajecia.sklepczegos.model.Koszulki;
import pl.zajecia.sklepczegos.repository.KoszulkiRepository;
import pl.zajecia.sklepczegos.ItemOperation;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final KoszulkiRepository repozytorium;
    private final Cart cart;

    @Autowired
    public CartService(KoszulkiRepository itemRepository, Cart cart) {
        this.repozytorium = itemRepository;
        this.cart = cart;
    }

    public List<Koszulki> getallItems() {
        return repozytorium.findAll();
    }
    /*public void addItemToCart(Long itemId) {
        Optional<Koszulki> oKoszulki = repozytorium.findById(itemId);
        if(oKoszulki.isPresent()) {
            Koszulki koszulki = oKoszulki.get();
            cart.dodajKoszulke(koszulki);
        }
    }
    public void decreaseItem(Long itemId) {
        Optional<Koszulki> oCartItem = repozytorium.findById(itemId);
        if (oCartItem.isPresent()) {
            Koszulki koszulka = oCartItem.get();
            cart.decreaseItem(koszulka);
        }

    }

    public void removeItem(Long itemId) {
        Optional<Koszulki> oCartItem = repozytorium.findById(itemId);
        if (oCartItem.isPresent()) {
            Koszulki koszulka = oCartItem.get();
            cart.removeAllItems(koszulka);
        }
    }*/

    public void itemOperation(Long itemId, ItemOperation operation) {
        Optional<Koszulki> oKoszulki = repozytorium.findById(itemId);
        if (oKoszulki.isPresent()) {
            Koszulki koszulka = oKoszulki.get();
            switch (operation) {
                case INCREASE -> cart.dodajKoszulke(koszulka);
                case DECREASE -> cart.decreaseItem(koszulka);
                case REMOVE -> cart.removeAllItems(koszulka);
            }
        }
    }

}
