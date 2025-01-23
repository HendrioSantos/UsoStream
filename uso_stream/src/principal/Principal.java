package principal;

import model.Aluno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    final static List<Aluno> alunos = new ArrayList<>();
    final static Principal principal = new Principal();

    public static void main(String[] args) {
        System.out.println("Todos os alunos da minha lista");
        alunos.add(new Aluno(0, "Matheus Silva", "1A", "6º série"));
        alunos.add(new Aluno(1, "Alessandra Coronha", "A1", "6º"));
        alunos.add(new Aluno(2, "Joao Miguel", "A2", "7º"));
        alunos.add(new Aluno(3, "Guilherme Alves", "A2", "7º"));
        alunos.add(new Aluno(4, "Joana Pamela", "A2", "7º"));
        alunos.forEach(System.out::println);

        principal.mostrarAlunosStream();
        principal.nomeDecrescenteAluno();
        principal.concatenarNomeEClasse();

        System.out.println("\nFiltro os alunos que estão na serie 7º e faço uma lista e printo ela");
        alunos.stream()
                .filter(aluno -> aluno.getSerie().contains("7º"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nTransformo o nome do aluno em um novo elemento e insiro numa lista");
        alunos.stream()
                .map(Aluno::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nComparar o maior nome do aluno");
        alunos.stream()
                .max(Comparator.comparingInt(alunos -> alunos.getNome().length()))
                .ifPresentOrElse(
                        aluno -> System.out.println("Aluno com maior nome: " + aluno.getNome() + " (" + aluno.getNome().length() + " caracteres)"),
                        () -> System.out.println("Nenhum aluno encontrado."));

        System.out.println("\nConcatena o nome, classe e serie");
        alunos.stream()
                .sorted(Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getSerie).thenComparing(Aluno::getClasse))
                .forEach(System.out::println);

        System.out.println("\nVerifica o nome, comparando o que eu passei com o nome e vendo se dá true ou false");
        System.out.println("E o anyMatch também retorna true ou false");
        boolean existeAluno = alunos.stream()
                .anyMatch(aluno -> aluno.getNome().equals("Joana Pamela"));
        System.out.println(existeAluno);

        System.out.println("\nLimita a lista em 3 alunos");
        alunos.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public void mostrarAlunosStream(){
        System.out.println("\nAbaixo uso de stream: ");
        alunos.stream()
                .forEach(System.out::println);
    }

    private void nomeDecrescenteAluno() {
        System.out.println("\nAbaixo listo por nome dos Alunos");
        alunos.stream()
                .sorted(Comparator.comparing(Aluno::getNome))
                .forEach(System.out::println);
    }

    private void concatenarNomeEClasse() {
        System.out.println("\nAbaixo eu junto a informação da nome e classe do aluno");
        alunos.stream()
                .sorted(Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getClasse))
                .forEach(System.out::println);
    }
}