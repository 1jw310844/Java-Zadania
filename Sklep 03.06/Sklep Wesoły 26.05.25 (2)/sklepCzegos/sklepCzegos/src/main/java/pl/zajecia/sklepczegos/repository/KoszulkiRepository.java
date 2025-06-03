package pl.zajecia.sklepczegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.sklepczegos.model.Koszulki;

@Repository
public interface KoszulkiRepository extends JpaRepository<Koszulki, Long> {

}
