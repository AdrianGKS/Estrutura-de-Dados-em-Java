package map;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Carro> carroSet = new HashSet<>();
        carroSet.add(new Carro("Ford"));
        carroSet.add(new Carro("Chevrolet"));
        carroSet.add(new Carro("Fiat"));
        carroSet.add(new Carro("Peugeot"));
        carroSet.add(new Carro("Zip"));
        carroSet.add(new Carro("Alfa Romeo"));

        System.out.println(carroSet);

        Set<Carro> treeSetCarros = new TreeSet<>();
        treeSetCarros.add(new Carro("Ford"));
        treeSetCarros.add(new Carro("Chevrolet"));
        treeSetCarros.add(new Carro("Fiat"));
        treeSetCarros.add(new Carro("Peugeot"));
        treeSetCarros.add(new Carro("Zip"));
        treeSetCarros.add(new Carro("Alfa Romeo"));

        System.out.println(treeSetCarros);
    }
}
