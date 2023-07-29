package devsuperior.com.aulaSalvarParaMuitos.repositories;

import devsuperior.com.aulaSalvarParaMuitos.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
