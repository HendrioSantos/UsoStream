package principal;

import model.Aluno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    final static List<Aluno> alunos = new ArrayList<>();
    final static Principal principal = new Principal();
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Todos os alunos da minha lista");
        alunos.add(new Aluno(0, "Matheus Silva", "1A", "6º série"));
        alunos.add(new Aluno(1, "Alessandra Coronha", "A1", "6º"));
        alunos.add(new Aluno(2, "Joao Miguel", "A2", "7º"));
        alunos.add(new Aluno(3, "Guilherme Alves", "A2", "7º"));
        alunos.add(new Aluno(4, "Joana Pamela", "A2", "7º"));
        alunos.forEach(System.out::println);

        int escolha = 0;

        while (escolha != -1) {
            principal.mostrarMenu();

            escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    principal.mostrarAlunosStream();
                    break;
                case 2:
                    principal.nomeDecrescenteAluno();
                    break;
                case 3:
                    principal.concatenarNomeEClasse();
                    break;
                case 4:
                    principal.buscarPorSetimaSerie();
                    break;
                case 5:
                    principal.mostrarSoNomeAluno();
                    break;
                case 6:
                    principal.compararMaiorNomeAluno();
                    break;
                case 7:
                    principal.concatenarNomeEClasseESerie();
                    break;
                case 8:
                    principal.existeAluno();
                    break;
                case 9:
                    principal.limiteAListaEmTres();
                    break;
                case -1:
                    System.out.println("...Saindo Do Sistema...");
                    break;
                default:
                    System.out.println("Escolha dentre 1 a 9 e -1 para sair do aplicativo");
            }
        }
    }

    public void mostrarMenu(){
        System.out.println("\nHá algumas opções para você escolher:\n");
        System.out.println
                ("""
                      1 - Mostrar Todos os alunos
                      2 - Mostrar Os Nomes Dos Alunos Em Ordem Alfabética
                      3 - Junta As Informações Do Nome E Da Classe Do Aluno
                      4 - Buscar Por Todos Os Alunos Da Sétima Série
                      5 - Mostra Só O Nome Do Aluno
                      6 - Mostra O Maior Nome De Todos Os Alunos
                      7 - Junta As Informações Do Nome E Da Classe E Da Série Do Aluno
                      8 - Mostra Se Existe O Nome Do Aluno
                      9 - Limita A Lista Em Três Nomes Dos Alunos
                      
                               ***************************
                       -1 -    *** Digite -1 para sair ***
                               ***************************
                      """
                );
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

    private void buscarPorSetimaSerie() {
        System.out.println("\nFiltro os alunos que estão na serie 7º e faço uma lista e printo ela");
        alunos.stream()
                .filter(aluno -> aluno.getSerie().contains("7º"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void mostrarSoNomeAluno() {
        System.out.println("\nTransformo o nome do aluno em um novo elemento e insiro numa lista");
        alunos.stream()
                .map(Aluno::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void compararMaiorNomeAluno() {
        System.out.println("\nComparar o maior nome do aluno");
        alunos.stream()
                .max(Comparator.comparingInt(alunos -> alunos.getNome().length()))
                .ifPresentOrElse(
                        aluno -> System.out.println("Aluno com maior nome: " + aluno.getNome() + " (" + aluno.getNome().length() + " caracteres)"),
                        () -> System.out.println("Nenhum aluno encontrado."));
    }

    private void concatenarNomeEClasseESerie() {
        System.out.println("\nConcatena o nome, classe e serie");
        alunos.stream()
                .sorted(Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getSerie).thenComparing(Aluno::getClasse))
                .forEach(System.out::println);
    }

    private void existeAluno() {
        System.out.println("\nVerifica o nome, comparando o que eu passei com o nome e vendo se dá true ou false");
        System.out.println("E o anyMatch também retorna true ou false");
        boolean existeAluno = alunos.stream()
                .anyMatch(aluno -> aluno.getNome().equals("Joana Pamela"));
        System.out.println(existeAluno);
    }

    private void limiteAListaEmTres() {
        alunos.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}