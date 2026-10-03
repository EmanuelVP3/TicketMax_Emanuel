    package app.view;

    import app.service.helpers.SetSeatStateHelper;
    import app.service.inputPorts.SeatServiceInterface;
    import app.service.validators.DataTypeValidator;

    public class SeatView {
        //17. Se inyecta la dependencia del servicio en la vista
        private final SeatServiceInterface seatServiceInterface;
        //18. Se inicializa el atributo
        public SeatView(SeatServiceInterface seatServiceInterface) {
            this.seatServiceInterface = seatServiceInterface;
        }
        //19. Continua en SeatServiceAdapter

        //2. Quitalos los metodos de la clase Seat y los movemos a View
        public void createSeat(){
            //26. Se solicitan los datos del asiento al usuario y se validan los tipos de datos
            int id = DataTypeValidator.validateInt("Ingrese el id del asiento");
            String seatNumber = DataTypeValidator.validateString("Ingrese el numero del asiento");
            String seatSector = DataTypeValidator.validateString("Ingrese el sector del asiento");
            //27. Se crea el SelectStateEnum para validar si el asiento esta disponible o no
            //30. Llamamos al metodo getSeatState de la clase SetSeatStateHelper para obtener el estado del asiento
            String seatState = SetSeatStateHelper.getSeatState();

            //31. Llamamos al metodo createSeat del servicio para crear el asiento con los datos ingresados por el usuario
            seatServiceInterface.createSeat(id, seatNumber, seatSector, seatState);
        }

        public void selectAllSeats(){

        }

        public void selectSeatById(int id){

        }

        public void updateSeat(){

        }

        public void deleteSeat(int id){

        }
}
