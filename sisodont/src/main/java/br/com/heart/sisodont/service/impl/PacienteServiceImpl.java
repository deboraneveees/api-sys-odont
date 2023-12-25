package br.com.heart.sisodont.service.impl;

import br.com.heart.sisodont.model.Paciente;
import br.com.heart.sisodont.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PacienteServiceImpl implements PacienteService {

    private static final Map<Long, Paciente> PACIENTES = new ConcurrentHashMap<>();

    @Override
    public Paciente save(Paciente paciente) {
        PACIENTES.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public Paciente findById(Long id) {
        if (PACIENTES.containsKey(id)) {
            return PACIENTES.get(id);
        }
        throw new RuntimeException("Paciente com o id " + id + " nao encontrado!");
    }
}
