package app.service.outputPorts;

import app.domain.Seat;

import java.util.List;

public interface SeatRepositoryPort {
    //7
    public Seat save(Seat seat);
    //8
    public Seat selectById(int id);
    //9
    public List<Seat> selectAllSeats();
    //10
    public Seat updateSeat(Seat seat);
    //11
    public void deleteById(int id);
    //12 sigue en la clase SeatServiceAdapter
}
