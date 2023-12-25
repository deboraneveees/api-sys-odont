package br.com.heart.sisodont.service;

import br.com.heart.sisodont.model.Paciente;

public interface PacienteService {
    Paciente save(Paciente paciente);

    Paciente findById(Long id);

}
