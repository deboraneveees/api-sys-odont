package br.com.heart.sysodont.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {

    private Long id;
    private String nome;
    private String cpf;
    private String email;

}