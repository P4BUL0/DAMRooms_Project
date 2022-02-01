package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
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
    public Set<Habitacion> findAll(){
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitacion> findById(long id){
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitacion addHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion modifyHabitacion(long id, Habitacion newHabitacion){
        Habitacion habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new HabitacionNotFoundException(id));
        newHabitacion.setId(habitacion.getId());
        return habitacionRepository.save(newHabitacion);
    }

    @Override
    public void deleteHabitacion(long id){
        habitacionRepository.findById(id)
                .orElseThrow( () -> new HabitacionNotFoundException(id) );
        habitacionRepository.deleteById(id);
    }
}
