package entities;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {

    private String nome;
    private String endereco;
    private String raca;
    private double idade;
    private double peso;
    private TIPO tipo;
    private SEXO sexo;

    public enum TIPO{
        CACHORRO, GATO
    }

    public enum SEXO{
        MACHO, FEMEA
    }

    public Pet(String nome, String endereco, String raca, double idade, double peso, TIPO tipo, SEXO sexo){
        this.nome = nome;
        this.endereco = endereco;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.tipo = tipo;
        this.sexo = sexo;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm");

        String path = LocalDateTime.now().format(dtf) + nome.toUpperCase() + ".txt";

        File petsCadastrados = new File("C:\\Users\\emath\\IdeaProjects\\DesafioCadastroPets\\com.Elian.DesafioCadastroPets\\src\\data","PetsCadastrados");
        boolean mkdir = petsCadastrados.mkdir();

        File file = new File(petsCadastrados, path.replace(" ", "T"));

        final String NAO_INFORMADO = "NÃO INFORMADO";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){

            if (nome.isBlank()) {
                bw.write("1 - " + NAO_INFORMADO);
            }else {
                bw.write("1 - " + nome);
            }

            bw.newLine();
            bw.write("2 - " + tipo);
            bw.newLine();
            bw.write("3 - " + sexo);
            bw.newLine();
            bw.write("4 - " + endereco);
            bw.newLine();

            if (idade > 1) {
                bw.write("5 - " + String.format("%.0f", idade) + " meses");
            }else if (idade == 0){
                bw.write("5 - " + NAO_INFORMADO);
            }else {
                bw.write("5 - " + idade + " anos");
            }
            bw.newLine();

            if (peso == 0) {
                bw.write("6 - " + NAO_INFORMADO);
            }else {
                bw.write("6 - " + peso + "kg");
            }
            bw.newLine();

            if (raca.isBlank()) {
                bw.write("7 - " + NAO_INFORMADO);
            }else {
                bw.write("7 - " + raca);
            }

            bw.newLine();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

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

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }
}
