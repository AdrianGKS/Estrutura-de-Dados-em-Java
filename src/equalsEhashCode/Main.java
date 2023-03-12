package equalsEhashCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Carro> list = new ArrayList<>();

        list.add(new Carro("Ford"));
        list.add(new Carro("Chevrolet"));
        list.add(new Carro("Volkswagen"));

        System.out.println(list.contains(new Carro("Ford")));
        System.out.println(new Carro("Ford").hashCode());
        System.out.println(new Carro("Ford2").hashCode());

        Carro carro1 = new Carro("Ford");
        Carro carro2 = new Carro("Chevrolet");
        System.out.println(carro1.equals(carro2));

        carro2.setMarca("Ford");
        System.out.println(carro1.equals(carro2));

    }
}
