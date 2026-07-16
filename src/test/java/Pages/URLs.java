package Pages;

public enum URLs {
    Base_URL_ITN3("PiyushVlaue3"),
    Base_URL_ITN6("PiyushVlaue6"),
    ;


    private String value;

    public String getValue() {
        return this.value;
    }


    URLs(String value) {
        this.value = value;
    }
}
