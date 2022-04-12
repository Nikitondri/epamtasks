package by.zakharenko.cafe.controller.enumeration;

public enum ParameterName {
    COMMAND("command"),
    PASSWORD("password"),
    LOGIN("login"),
    ID("id");

    private final String parameter;

    ParameterName(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
