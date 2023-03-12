package listaDuplamenteEncadeada;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        lista.add("a1");
        lista.add("a2");
        lista.add("a3");
        lista.add("a4");
        lista.add("a5");
        lista.add("a6");
        lista.add("a7");

        System.out.println(lista);

        lista.remove(3);
        lista.add(3, "b9");

        System.out.println("\n" + lista);
        System.out.println("\n" + lista.get(3));
    }
}
