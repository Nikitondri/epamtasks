package by.zakharanka.task03inheritance.service.generator;

public enum Names {
    David,
    James,
    Harry,
    Olivia,
    Sten,
    Nikita,
    Oleg,
    Pasha,
    Artem;

    private static Names[] list = Names.values();

    public static Names getName(int index){
        return list[index];
    }

    public static int size(){
        return list.length;
    }
}
