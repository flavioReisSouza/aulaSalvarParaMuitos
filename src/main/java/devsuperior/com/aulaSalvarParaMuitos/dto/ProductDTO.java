package devsuperior.com.aulaSalvarParaMuitos.dto;

import devsuperior.com.aulaSalvarParaMuitos.entities.Category;
import devsuperior.com.aulaSalvarParaMuitos.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();

        for (Category cat : entity.getCategories()) { //percorre a lista de categorias do produto
            categories.add(new CategoryDTO(cat)); //adiciona a referência a uma entidade (no caso, o nome de uma categoria) à lista de categorias do produto
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

}