package com.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/buscar")
    public String buscarMissao() {
        return "Missoes buscadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/alterar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }
}
