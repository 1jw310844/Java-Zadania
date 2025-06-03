package pl.zajecia.sklepczegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.zajecia.sklepczegos.model.Koszulki;
import pl.zajecia.sklepczegos.repository.KoszulkiRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final KoszulkiRepository repozytorium;
    @Autowired
    public DbInit(KoszulkiRepository repozytorium){
        this.repozytorium = repozytorium;
    }
    @Override
    public void run(String...args) throws Exception{
        repozytorium.saveAll(List.of(
                new Koszulki("Real Madryt", new BigDecimal(50.0),
                        "https://www.tradeinn.com/f/13992/139925435/adidas-real-madrid-23-24-domowy-koszulka-z-krotkim-r%C4%99kawem.webp"),
                new Koszulki("Bayern Monachium", new BigDecimal(50.0),
                "https://www.no10.pl/img/grande/79971/KOSZULKA%20adidas%20KOSZULKA%20adidas%20FC%20BAYERN%20MONACHIUM%20AI0049%20(1)"),
                new Koszulki("FC Barcelona", new BigDecimal(100.0),
                "https://static.nike.com/a/images/t_PDP_936_v1/f_auto,q_auto:eco/9a477f39-480c-41e8-9937-0e9e20312167/FCB+M+NK+DF+JSY+SS+STAD+HM.png")
                ));
    }
}
