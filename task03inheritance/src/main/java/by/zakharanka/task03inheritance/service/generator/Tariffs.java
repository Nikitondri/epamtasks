package by.zakharanka.task03inheritance.service.generator;

public enum Tariffs {
    UltraTariff,
    MegaTariff,
    FlyTariff,
    SmartTariff;

    private static Tariffs[] list = Tariffs.values();

    public static Tariffs getTariff(int index){
        return list[index];
    }

    public static int size(){
        return list.length;
    }
}
