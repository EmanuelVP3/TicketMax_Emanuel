package app.domain.enums;

//27. Se crea el enum y 28, Se crea el helper SeatStateHelper para poder cambiar el estado de un asiento y que se vea reflejado en la vista

public enum SeatStateEnum {
    IS_AVAILABLE("Disponible"),
    IS_NOT_AVAILABLE("No disponible"),
    IS_RESERVED("Reservado"),
    IS_OCCUPIED("Ocupado");

    private final String state;

    SeatStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
