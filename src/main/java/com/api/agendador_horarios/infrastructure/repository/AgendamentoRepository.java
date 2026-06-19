package com.api.agendador_horarios.infrastructure.repository;

import java.beans.Transient;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.agendador_horarios.infrastructure.repository.entity.Agendamento;
import jakarta.transaction.Transactional;
import java.util.List;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio,
                                                           LocalDateTime dataHoraFinal);

    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);
}

