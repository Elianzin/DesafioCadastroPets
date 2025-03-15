package program;

import entities.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programa {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        int opcao = menu(sc);

        if (opcao == 1){

            List<String> perguntas = exibirFormulario();

            boolean nomeValido;

            String nome = "";

            int c = 0;

            String regex = "^(([aA-zZ])+(\\s[aA-zZ]+)+)$";

            Pattern pattern = Pattern.compile(regex);

            do {

                nomeValido = true;

                System.out.println(perguntas.get(c));
                System.out.print("Digite: ");

                try {

                    nome = sc.nextLine();

                    Matcher matcher = pattern.matcher(nome);

                    if (!matcher.matches()) {
                        throw new Exception("Erro: O nome do seu pet deve ser apenas letras e um ou mais espaços separando o nome e o sobrenome!" + "\n" + "Exemplo correto: Bruce Bumstead");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    nomeValido = false;
                    Thread.sleep(1000);
                }

            }while (!nomeValido);

            String tipo;

            boolean tipoValido;

            c++;

            do {

                tipoValido = true;

                System.out.println(perguntas.get(c));
                System.out.print("Digite: ");
                tipo = sc.next();

                if (!tipo.equalsIgnoreCase("Cachorro") && !tipo.equalsIgnoreCase("Gato")) {
                    System.out.println("Digite um tipo de pet valido!" + "\n" + "Os validos são Cachorro e Gato!");
                    tipoValido = false;
                    Thread.sleep(1000);
                }

            }while (!tipoValido);

            Pet.TIPO enumTipo = Pet.TIPO.valueOf(tipo.toUpperCase());

            boolean sexoValido;

            String sexo;

            c++;

            do {

                sexoValido = true;

                System.out.println(perguntas.get(c));
                System.out.print("Digite: ");
                sexo = sc.next();

                if (!sexo.equalsIgnoreCase("Macho") && !sexo.equalsIgnoreCase("Femea")){
                    System.out.println("Digite um genero de pet valido!" + "\n" + "Os validos são Macho e Femea!");
                    sexoValido = false;
                    Thread.sleep(1000);
                }

            }while (!sexoValido);

            Pet.SEXO enumSexo = Pet.SEXO.valueOf(sexo.toUpperCase());

            c++;

            boolean informacoesValidas;

            String numeroDaCasa = "";
            String cidade;
            String rua;

            do {

                String numeroDaCasaString;

                informacoesValidas = true;

                System.out.println(perguntas.get(c));

                System.out.print("Número da casa: ");
                numeroDaCasaString = sc.next();
                sc.nextLine();

                try {

                    if (!numeroDaCasaString.matches("[0-9]*[0-9]*[0-9]*[0-9]*")){
                        throw new Exception();
                    }

                    numeroDaCasa = numeroDaCasaString;

                }catch (Exception e){
                    System.out.println("Para número da casa só são valido digitos!");
                    informacoesValidas = false;
                }

            }while (!informacoesValidas);

            String regex2 = "^(([aA-zZãíóáâ-])*(\\s[aA-zZãíóáâ-]+)*)$";
            Pattern pattern2 = Pattern.compile(regex2);

            do {

                informacoesValidas = true;

                System.out.print("Cidade: ");
                cidade = sc.nextLine();

                Matcher matcher2 = pattern2.matcher(cidade);

                if (!matcher2.matches()){
                    System.out.println("Digite um nome de cidade valido!");
                    informacoesValidas = false;
                }

            }while (!informacoesValidas);

            System.out.print("Rua: ");
            rua = sc.nextLine();

            String endereco = rua + ", " + numeroDaCasa+ ", " + cidade;

            c++;

            double idade = 0;

            do {

                String idadeString;

                informacoesValidas = true;

                System.out.println(perguntas.get(c));

                System.out.print("Digite: ");
                idadeString = sc.next();
                sc.nextLine();

                try {
                    idade = Double.parseDouble(idadeString);

                    if (idade > 20){
                        throw new IllegalArgumentException();
                    }

                }catch (IllegalArgumentException e){
                    System.out.println("A idade não pode ser maior que 20 anos!");
                    informacoesValidas = false;
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println("Para idade só são valido digitos!");
                    informacoesValidas = false;
                    Thread.sleep(1000);
                }

            }while (!informacoesValidas);

            c++;

            double peso = 0;

            do {

                String pesoString;

                informacoesValidas = true;

                System.out.println(perguntas.get(c));

                System.out.print("Digite: ");
                pesoString = sc.next();
                sc.nextLine();

                try {
                    peso = Double.parseDouble(pesoString);

                     if (peso > 60){
                        throw new IllegalArgumentException("O peso não pode ser maior que 60 kilos!");
                    }else if (peso < 0.5){
                        throw new IllegalArgumentException("O peso não pode ser menor que 0.5 kilos!");
                    }

                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    informacoesValidas = false;
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println("Para idade só são valido digitos!");
                    informacoesValidas = false;
                    Thread.sleep(1000);
                }

            }while (!informacoesValidas);

            c++;

            String raca;

            do {

                informacoesValidas = true;

                System.out.println(perguntas.get(c));

                System.out.print("Raça: ");
                raca = sc.nextLine();

                Matcher matcher3 = pattern2.matcher(raca);

                if (!matcher3.matches()){
                    System.out.println("Digite um nome de raça valido!");
                    informacoesValidas = false;
                }

            }while (!informacoesValidas);

            Pet pet = new Pet(nome, endereco, raca, idade, peso, enumTipo, enumSexo);
        }
    }

    public static int menu(Scanner sc) throws InterruptedException {

        boolean entradaValida = false;

        int opcao = 0;

        System.out.println("========================================================");
        System.out.println("| 1 - Cadastrar um novo pet                            |");
        System.out.println("| 2 - Alterar dados de um pet cadastrado               |");
        System.out.println("| 3 - Deletar um pet cadastrado                        |");
        System.out.println("| 4 - Listar todos os pets cadastrados                 |");
        System.out.println("| 5 - Listar pets por algum criterio (idade,nome,raça) |");
        System.out.println("| 6 - Sair                                             |");
        System.out.println("========================================================");
        System.out.print("Digite: ");

        do {

            String opcaoString = sc.nextLine();

            try {

                opcao = Integer.parseInt(opcaoString);

                if (opcao > 0 && opcao < 7) {
                    entradaValida = true;
                }else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("DIGITE UM DIGITO VALIDO!");
                Thread.sleep(1000);
                opcao = menu(sc);
                if (opcao > 0 && opcao < 7) {
                    entradaValida = true;
                }
            }

        } while (!entradaValida);
        
        return opcao;
    }

    public static List<String> exibirFormulario(){

        List<String> perguntas = new ArrayList<>();

        String formulario = "C:\\Users\\emath\\IdeaProjects\\DesafioCadastroPets\\com.Elian.DesafioCadastroPets\\src\\data\\formulario.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(formulario))){

            String line = br.readLine();

            while (line != null) {
                perguntas.add(line);
                line = br.readLine();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return perguntas;
    }
}
