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

            int c = 0;

            String regex = "[a-zA-Z]";

            Pattern pattern = Pattern.compile(regex);

            System.out.println(perguntas.get(c));
            System.out.print("Digite: ");

            try {

                String nome = sc.nextLine();

                Matcher matcher = pattern.matcher(nome);

                if (!regex.matches(nome)) {
                    throw new Exception("Não são permitidos caracteres especiais nem números!");
                }

            }catch (Exception e){
                System.out.println(e.getMessage());

            }

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
