package model;

public class Aluno {
    int id;
    String nome;
    String classe;
    String serie;

    public Aluno(int id, String nome, String classe, String serie) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.serie = serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", classe='" + classe + '\'' +
                ", serie='" + serie + '\'' +
                '}';
    }
}
