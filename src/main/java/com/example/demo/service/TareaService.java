package com.example.demo.service;

import com.example.demo.model.Tarea;
import com.example.demo.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public Tarea updateTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(t -> {
            t.setTitulo(tareaActualizada.getTitulo());
            t.setDescripcion(tareaActualizada.getDescripcion());
            t.setEstado(tareaActualizada.getEstado());
            return tareaRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
    }
}

