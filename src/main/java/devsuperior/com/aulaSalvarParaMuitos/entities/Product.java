package devsuperior.com.aulaSalvarParaMuitos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product") // nome da tabela
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @ManyToMany //muitos para muitos na tabela de associação entre as duas tabelas (product e category) aonde está o asterisco no diagrama de classes
    @JoinTable(name = "tb_product_category", //nome da tabela de associação que vai ser criada
            joinColumns = @JoinColumn(name = "product_id"), //chave estrangeira da tabela que estamos
            inverseJoinColumns = @JoinColumn(name = "category_id")) //chave estrangeira da outra tabela
    private Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, Double price, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}