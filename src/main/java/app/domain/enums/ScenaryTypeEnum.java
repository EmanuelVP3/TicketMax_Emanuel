package app.domain.enums;

public enum ScenaryTypeEnum {
    TEATRO("Teatro"),
    SALON("Salon"),
    ARENA("Arena");

    private final String scenary;

    ScenaryTypeEnum(String scenary) {this.scenary = scenary;}

    public String getScenary(){return scenary;}
}
