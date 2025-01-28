package com.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Criar ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.criarNinja(ninjaDTO);
    }

    //Listar ninjas
    @GetMapping("/todos")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Procurar Ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Atualizar dados do ninja
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {

        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "Deletado";
    }
}
