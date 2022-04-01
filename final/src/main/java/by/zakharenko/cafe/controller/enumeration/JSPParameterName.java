package by.zakharenko.cafe.controller.enumeration;

public enum JSPParameterName {
    COMMAND("command"),
    ID("id");

    private final String parameter;

    JSPParameterName(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
