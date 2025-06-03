package pl.zajecia.sklepczegos.kontrolery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.sklepczegos.Cart;
import pl.zajecia.sklepczegos.dto.OrderDto;
import pl.zajecia.sklepczegos.service.CartService;
import pl.zajecia.sklepczegos.ItemOperation;

@Controller
@RequestMapping("/order")
public class OrderKontroler {
    private final CartService cartService;
    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String showCart(){//@ModelAttribute("cart") Cart cart, Model model) {
        //model.addAttribute("cart", cart);
        return "cartView";
    }

    public OrderKontroler(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable("itemId") Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);

        return "redirect:/order/cart";
    }

    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable("itemId") Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.DECREASE);
        return "redirect:/order/cart";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItemsFromCart(@PathVariable("itemId") Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.REMOVE);
        return "redirect:/order/cart";
    }

    @GetMapping("/summary")
    public String showSummary() {
        return "summary";
    }

    @PostMapping("/saveorder")
    public String saveOrder(@ModelAttribute OrderDto orderDto) {
        System.out.println("Zamówienie od: " + orderDto.getFirstName() + " " + orderDto.getLastName());
        System.out.println("Adres: " + orderDto.getAddress() + ", " + orderDto.getPostCode() + " " + orderDto.getCity());
        return "redirect:/";
    }
}
