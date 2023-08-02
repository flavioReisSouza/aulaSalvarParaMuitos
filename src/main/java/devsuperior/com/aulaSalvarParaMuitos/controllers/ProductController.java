package devsuperior.com.aulaSalvarParaMuitos.controllers;

import devsuperior.com.aulaSalvarParaMuitos.dto.ProductDTO;
import devsuperior.com.aulaSalvarParaMuitos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = service.insert(dto); //chama o método insert() da classe ProductService e passa o dto como argumento
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") //pega a URI do recurso criado (no caso, o produto) e adiciona o id do produto criado à URI
                .buildAndExpand(dto.getId()).toUri(); //buildAndExpand() é o método que adiciona o id do produto criado à URI do recurso criado (no caso, o produto) e toUri() é o método que converte a URI do recurso criado
        return ResponseEntity.created(uri).body(dto); //created() é o método que retorna o código 201 (código de criação de recurso) e body() é o método que retorna o corpo da resposta (no caso, o produto criado)
    }

}
