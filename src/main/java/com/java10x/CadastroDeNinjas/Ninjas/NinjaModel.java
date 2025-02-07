package com.java10x.CadastroDeNinjas.Ninjas;

import com.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String img;

    @Column (name = "idade")
    private int idade;

    @Column (name = "rank")
    private String rank;

    // @ManyToOne um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreig Key
    private MissoesModel missoes;
}
