package com.example.dwbe_configuration_bean.repository;

import com.example.dwbe_configuration_bean.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
