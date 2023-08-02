package devsuperior.com.aulaSalvarParaMuitos.services;

import devsuperior.com.aulaSalvarParaMuitos.dto.CategoryDTO;
import devsuperior.com.aulaSalvarParaMuitos.dto.ProductDTO;
import devsuperior.com.aulaSalvarParaMuitos.entities.Category;
import devsuperior.com.aulaSalvarParaMuitos.entities.Product;
import devsuperior.com.aulaSalvarParaMuitos.repositories.CategoryRepository;
import devsuperior.com.aulaSalvarParaMuitos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto) {

       Product entity = new Product();
       entity.setName(dto.getName());
       entity.setPrice(dto.getPrice());

       for (CategoryDTO catDTO : dto.getCategories()) {
           Category cat = categoryRepository.getReferenceById(catDTO.getId());
           entity.getCategories().add(cat);
       }

       return new ProductDTO(repository.save(entity));
    }

}
