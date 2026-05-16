package com.example.dwbe_configuration_bean.repository;

import com.example.dwbe_configuration_bean.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository <Prontuario, Long> {
}
