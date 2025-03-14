package entities;

public class Pet {

    private String nome;
    private String endereco;
    private String raca;
    private double idade;
    private double peso;

    public enum TIPO{
        CACHORRO, GATO
    }

    public enum SEXO{
        MACHO, FEMEA
    }

    public Pet(String nome, String endereco, String raca, double idade, double peso) {
        this.nome = nome;
        this.endereco = endereco;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
