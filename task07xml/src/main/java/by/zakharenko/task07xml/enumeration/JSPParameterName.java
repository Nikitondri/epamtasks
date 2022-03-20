package by.zakharenko.task07xml.enumeration;

public enum JSPParameterName {
    COMMAND("command"),
    FILE("file");

    private final String parameter;

    JSPParameterName(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
