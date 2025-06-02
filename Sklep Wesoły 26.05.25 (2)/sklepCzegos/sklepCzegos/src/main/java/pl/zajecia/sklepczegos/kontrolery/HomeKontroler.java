package pl.zajecia.sklepczegos.kontrolery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.zajecia.sklepczegos.Cart;
import pl.zajecia.sklepczegos.model.Koszulki;
import pl.zajecia.sklepczegos.repository.KoszulkiRepository;
import pl.zajecia.sklepczegos.service.CartService;
import pl.zajecia.sklepczegos.ItemOperation;
import java.util.Optional;

@Controller
public class HomeKontroler {

    //private final KoszulkiRepository repozytorium;
    //private final Cart cart;
    private final CartService cartService;

    public HomeKontroler(CartService cartService){
        this.cartService = cartService;
    }

    /*@Autowired
    public HomeKontroler(KoszulkiRepository repozytorium, Cart cart) {
        this.repozytorium = repozytorium;
        this.cart = cart;
    }
*/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("koszulki", cartService.getallItems());
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        return "redirect:/";
    }

}
