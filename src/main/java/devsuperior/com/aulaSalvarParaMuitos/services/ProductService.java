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
    private ProductRepository repository; //injeta uma dependência da classe ProductRepository

    @Autowired
    private CategoryRepository categoryRepository; //injeta uma dependência da classe CategoryRepository

    public ProductDTO insert(ProductDTO dto) { //método que insere um produto no banco de dados

       Product entity = new Product(); //instancia um produto
       entity.setName(dto.getName()); //seta o nome do produto
       entity.setPrice(dto.getPrice()); //seta o preço do produto

       for (CategoryDTO catDTO : dto.getCategories()) { //percorre a lista de categorias do produto
           Category cat = categoryRepository.getReferenceById(catDTO.getId()); //getReferenceById() é o método que retorna uma referência a uma entidade (no caso, uma o nome de uma categoria)
           entity.getCategories().add(cat); //adiciona a referência a uma entidade (no caso, o nome de uma categoria) à lista de categorias do produto
       }

       return new ProductDTO(repository.save(entity)); //save() é o método que salva o produto no banco de dados e retorna o produto salvo
    }

}
