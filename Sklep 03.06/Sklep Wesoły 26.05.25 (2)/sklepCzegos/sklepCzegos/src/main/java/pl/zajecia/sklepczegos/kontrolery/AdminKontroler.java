package pl.zajecia.sklepczegos.kontrolery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zajecia.sklepczegos.model.Koszulki;
import pl.zajecia.sklepczegos.repository.KoszulkiRepository;

@Controller
@RequestMapping("/admin")
public class AdminKontroler {
    private final KoszulkiRepository repozytorium;

    @Autowired
    public AdminKontroler(KoszulkiRepository repozytorium)
    {
        this.repozytorium = repozytorium;
    }
    @GetMapping
    private String adminPage(){
        return "adminview/addItem";
    }

    @PostMapping
    private String addItem(Koszulki item)
    {
        repozytorium.save(item);
        //HomeKontroler.listaKoszulek.add(item);
        return "redirect:/";
    }
}
