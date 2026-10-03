package app.configuration;

import app.repository.mappers.SeatRepositoryAdapter;
import app.repository.mappers.UserRepositoryImplCollection;
import app.service.SeatServiceAdapter;
import app.service.UserServiceImpl;
import app.service.inputPorts.SeatServiceInterface;
import app.service.inputPorts.UserService;
import app.service.outputPorts.SeatRepositoryPort;
import app.service.outputPorts.UserRepository;
import app.ui.CliUserInterface;
import app.view.SeatView;
import app.view.UserView;

public class Config {
    public static CliUserInterface getCliUserInterface() {


        UserRepository userRepository = new UserRepositoryImplCollection();
        UserService userService = new UserServiceImpl(userRepository);
        UserView userView = new UserView(userService);

        //23. Se crea una instancia de SeatRepositoryAdapter, SeatServiceAdapter y SeatView
        //24 sigue en SetServiceAdapter
        SeatRepositoryPort seatRepositoryPort = new SeatRepositoryAdapter();
        SeatServiceInterface seatServiceInterface = new SeatServiceAdapter(seatRepositoryPort);
        SeatView seatView = new SeatView(seatServiceInterface);

        return new CliUserInterface(userView, seatView);
    }
}
