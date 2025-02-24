package br.edu.ifsp.pep.bcc.estoque.controller;

import br.edu.ifsp.pep.bcc.estoque.model.entity.Part;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("part")
public class PartController {
    @GetMapping("")
    public String welcome(){
        return "<form action='http://localhost:8080/part/all'><input type='submit' value='ir para todos'/></form>";
    }

    @GetMapping("/all")
    public String getAllParts(){
        return "Peça 1<br/>Peça 2<br/>Peça 3";
    }

//    @GetMapping(value = "/{numero}", produces)
    @GetMapping("/{numero}")
        public List<Part> getPart(@PathVariable int numero){
        Part part = new Part(numero, "parafuso", 0.50);
        Part part2 = new Part(numero + 2, "parafusadeira", 0.50);
        List<Part> parts = new ArrayList<>();
        parts.add(part);
        parts.add(part2);
        return parts;
    }


}
