package br.com.heart.sysodont.service;

import br.com.heart.sysodont.model.Paciente;

public interface PacienteService {
    Paciente save(Paciente paciente);

    Paciente findById(Long id);

}