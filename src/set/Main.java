package set;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, String> aluno = new HashMap<>();
        aluno.put("Nome", "João");
        aluno.put("Idade", "17");
        aluno.put("Média", "7.6");
        aluno.put("Turma", "6B");

        System.out.println(aluno);
        System.out.println(aluno.keySet());
        System.out.println(aluno.values());

        List<Map<String, String>> listaAlunos = new ArrayList();
        listaAlunos.add(aluno);

        Map<String, String> aluno2 = new HashMap<>();
        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "15");
        aluno2.put("Média", "9.5");
        aluno2.put("Turma", "5A");

        listaAlunos.add(aluno2);

        System.out.println(listaAlunos);
        System.out.println(aluno.containsKey("Nome"));
    }
}
