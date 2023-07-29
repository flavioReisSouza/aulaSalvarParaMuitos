package devsuperior.com.aulaSalvarParaMuitos.repositories;

import devsuperior.com.aulaSalvarParaMuitos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
