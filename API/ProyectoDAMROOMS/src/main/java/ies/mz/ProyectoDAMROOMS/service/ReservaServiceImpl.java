package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.ReservaNotFoundException;
import ies.mz.ProyectoDAMROOMS.repository.HabitacionRepository;
import ies.mz.ProyectoDAMROOMS.repository.ClienteRepository;
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
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Set<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(long id){
        return reservaRepository.findById(id);
    }

    @Override
    public Set<Reserva> findByFechaInicio(String fechaInicio) {
        return reservaRepository.findByFechaInicio(fechaInicio);
    }

    @Override
    public Reserva addReserva(Reserva reserva){
        long numHab = reserva.getHabitacion().getNumero();
        String dniCli = reserva.getCliente().getDni();
        Set<Cliente> cliente = clienteRepository.findByDni(dniCli);
        Optional<Habitacion> habitacion =  habitacionRepository.findById(numHab);

        reserva.setHabitacion(habitacion.get());
        reserva.calcImporteTotal();
        reserva.setEstado("Pendiente");
        reserva.setCliente(cliente.stream().findFirst().get());

        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva modifyReserva(long id, Reserva newReserva){
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));
        newReserva.setIdReserva(reserva.getIdReserva());
        newReserva.calcImporteTotal();
        return reservaRepository.save(newReserva);
    }

    @Override
    public Reserva modifyReservaCheckIn(long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));

        reserva.setEstado("Activa");

        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva modifyReservaCheckOut(long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));

        reserva.setEstado("Completada");

        return reservaRepository.save(reserva);
    }

    @Override
    public String getDni(Optional<Reserva> reserva){
        return reserva.get().getCliente().getDni();
    }

    @Override
    public void deleteReserva(long id){
        reservaRepository.findById(id)
                .orElseThrow( () -> new ReservaNotFoundException(id) );
        reservaRepository.deleteById(id);
    }

}
