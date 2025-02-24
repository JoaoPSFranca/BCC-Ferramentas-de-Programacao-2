package br.edu.ifsp.pep.bcc.estoque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // recebe json (ou não) e retorna json
@RequestMapping("client") // tipo o listener e o lifecycle, sempre que tem algum request ele executa uma classe especifica
public class ClientController {

    @GetMapping("")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/all")
    public String getAllClients() {
        return "Joao<br/>Maria<br/>Gustavo<br/>";
    }

    @GetMapping("/{codigo}")
    public String getClient(@PathVariable int codigo) {
        return "Cliente de Codigo " + codigo;
    }
}
