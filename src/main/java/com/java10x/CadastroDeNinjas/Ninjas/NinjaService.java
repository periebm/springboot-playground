package com.java10x.CadastroDeNinjas.Ninjas;


import com.java10x.CadastroDeNinjas.Missoes.IMissoesRepository;
import com.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private INinjaRepository ninjaRepository;
    private IMissoesRepository missoesRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(INinjaRepository ninjaRepository, IMissoesRepository missoesRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.missoesRepository = missoesRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);

        return ninjaPorID.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        if (ninjaDTO.getMissoes() != null && ninjaDTO.getMissoes().getId() != null) {
            MissoesModel missoes = missoesRepository.findById(ninjaDTO.getMissoes().getId()).orElseThrow(() -> new RuntimeException("Missão não encontrada com ID: " + ninjaDTO.getMissoes().getId()));
        }

        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);

        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninja) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);

            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }

        return null;
    }
}
