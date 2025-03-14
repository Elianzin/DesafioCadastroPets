package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            String nome;

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

            c++;

            boolean informacoesValidas;

            int numeroDaCasa;
            String cidade;
            String rua;

            do {

                String numeroDaCasaString;

                informacoesValidas = true;

                System.out.println(perguntas.get(c));

                System.out.print("Número da casa: ");
                numeroDaCasaString = sc.next();

                try {

                    numeroDaCasa = Integer.parseInt(numeroDaCasaString);

                }catch (Exception e){
                    System.out.println("Para número da casa só são valido digitos!");
                    informacoesValidas = false;
                }

            }while (!informacoesValidas);

            String regex2 = "[a-zA-Zãéáí-]+";
            Pattern pattern2 = Pattern.compile(regex2);

            do {

                informacoesValidas = true;

                System.out.print("Cidade (Se a cidade conter espaço substituir por hífen): ");
                cidade = sc.next();

                Matcher matcher2 = pattern2.matcher(cidade);

                if (!matcher2.matches()){
                    System.out.println("Digite um nome de cidade valido!");
                    informacoesValidas = false;
                }

            }while (!informacoesValidas);

            System.out.print("Rua: ");
            rua = sc.next();

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
