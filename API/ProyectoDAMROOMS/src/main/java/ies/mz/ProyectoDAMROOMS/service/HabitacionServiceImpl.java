package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class HabitacionServiceImpl implements HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public Set<Habitaciones> findAll(){
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitaciones> findById(long id){
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitaciones addHabitacion(Habitaciones habitacion){
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitaciones modifyHabitacion(long id, Habitaciones newHabitacion){
        Habitaciones habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new HabitacionNotFoundException(id));
        newHabitacion.setNumero(habitacion.getNumero());
        return habitacionRepository.save(newHabitacion);
    }

    @Override
    public void deleteHabitacion(long id){
        habitacionRepository.findById(id)
                .orElseThrow( () -> new HabitacionNotFoundException(id) );
        habitacionRepository.deleteById(id);
    }
    @Override
    public void deleteAll(String tipo) {
        habitacionRepository.deleteByTipo(tipo);
    }
}
