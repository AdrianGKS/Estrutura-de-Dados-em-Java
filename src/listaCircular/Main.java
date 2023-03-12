package listaCircular;

public class Main {

    public static void main(String[] args) {

        ListaCircular<String> lista =  new ListaCircular<>();

        lista.add("c0");
        System.out.println(lista);

        lista.remove(0);
        System.out.println(lista);

        lista.add("c1");
        System.out.println(lista);

        lista.add("c2");
        lista.add("c3");
        System.out.println(lista);

        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        System.out.println(lista.get(4));

        for (int i = 0; i <20; i ++) {
            System.out.print(lista.get(i) + " ");
        }
    }
}
