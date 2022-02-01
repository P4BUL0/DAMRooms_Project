package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.ReservaNotFoundException;
import ies.mz.ProyectoDAMROOMS.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public Set<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(long id){
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva addReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva modifyReserva(long id, Reserva newReserva){
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));
        newReserva.setIdReserva(reserva.getIdReserva());
        return reservaRepository.save(newReserva);
    }

    @Override
    public void deleteReserva(long id){
        reservaRepository.findById(id)
                .orElseThrow( () -> new ReservaNotFoundException(id) );
        reservaRepository.deleteById(id);
    }

}
