package program;

import entities.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programa {

    public static void main(String[] args) throws InterruptedException, IOException {

        final String NAO_INFORMADO = "NÃO INFORMADO";

        boolean sair;

        List<Pet> listaPets = new ArrayList<>();

        do {

            sair = false;

            Scanner sc = new Scanner(System.in);

            int opcao = menu(sc);

            if (opcao == 1) {

                List<String> perguntas = exibirFormulario();

                boolean nomeValido;

                String nome = "";

                int c = 0;

                String regex = "^(([aA-zZ])*(\\s[aA-zZ]+)*)$";

                Pattern pattern = Pattern.compile(regex);

                do {

                    nomeValido = true;

                    System.out.println(perguntas.get(c));
                    System.out.print("Digite: ");

                    try {

                        nome = sc.nextLine();

                        Matcher matcher = pattern.matcher(nome);

                        if (nome.isBlank()) {
                            nome = "";
                        } else if (!matcher.matches()) {
                            throw new Exception("Erro: O nome do seu pet deve ser apenas letras!" + "\n" + "Exemplos: Rex, Bruce Bumstead");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        nomeValido = false;
                        Thread.sleep(1000);
                    }

                } while (!nomeValido);

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

                } while (!tipoValido);

                Pet.TIPO enumTipo = Pet.TIPO.valueOf(tipo.toUpperCase());

                boolean sexoValido;

                String sexo;

                c++;

                do {

                    sexoValido = true;

                    System.out.println(perguntas.get(c));
                    System.out.print("Digite: ");
                    sexo = sc.next();

                    if (!sexo.equalsIgnoreCase("Macho") && !sexo.equalsIgnoreCase("Femea")) {
                        System.out.println("Digite um genero de pet valido!" + "\n" + "Os validos são Macho e Femea!");
                        sexoValido = false;
                        Thread.sleep(1000);
                    }

                } while (!sexoValido);

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

                    System.out.print("Número da casa (se não deseja preencher digite 0): ");

                    try {

                        numeroDaCasaString = sc.next();
                        sc.nextLine();

                        if (Integer.parseInt(numeroDaCasaString) == 0) {
                            numeroDaCasaString = NAO_INFORMADO;
                        } else if (!numeroDaCasaString.matches("[0-9]*[0-9]*[0-9]*[0-9]*")) {
                            throw new Exception();
                        }

                        numeroDaCasa = numeroDaCasaString;

                    } catch (Exception e) {
                        System.out.println("Para número da casa só são valido digitos!");
                        informacoesValidas = false;
                    }

                } while (!informacoesValidas);

                String regex2 = "^(([aA-zZãíóáâ-])*(\\s[aA-zZãíóáâ-]+)*)$";
                Pattern pattern2 = Pattern.compile(regex2);

                do {

                    informacoesValidas = true;

                    System.out.print("Cidade: ");
                    cidade = sc.nextLine();

                    Matcher matcher2 = pattern2.matcher(cidade);

                    if (!matcher2.matches()) {
                        System.out.println("Digite um nome de cidade valido!");
                        informacoesValidas = false;
                    }

                } while (!informacoesValidas);

                System.out.print("Rua: ");
                rua = sc.nextLine();

                if (rua.isBlank()) {
                    rua = NAO_INFORMADO;
                }

                String endereco = rua + ", " + numeroDaCasa + ", " + cidade;

                c++;

                double idade = 0;

                do {

                    String idadeString;

                    informacoesValidas = true;

                    System.out.println(perguntas.get(c));

                    System.out.print("Digite (se não deseja preencher digite 0): ");
                    idadeString = sc.next();
                    sc.nextLine();

                    try {
                        idade = Double.parseDouble(idadeString);

                        if (idade > 20) {
                            throw new IllegalArgumentException("A idade não pode ser maior que 20 anos!");
                        } else if (idade > 0.12 && idade < 1) {
                            throw new IllegalArgumentException("Se a idade for menor que 1 ano represente-a em meses!!\n" + "Exemplos: 0.11, 0.08 ");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        informacoesValidas = false;
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Para idade só são valido digitos!");
                        informacoesValidas = false;
                        Thread.sleep(1000);
                    }

                } while (!informacoesValidas);

                c++;

                double peso = 0;

                do {

                    String pesoString;

                    informacoesValidas = true;

                    System.out.println(perguntas.get(c));

                    System.out.print("Digite (se não deseja preencher digite 0): ");
                    pesoString = sc.next();
                    sc.nextLine();

                    try {
                        peso = Double.parseDouble(pesoString);

                        if (peso > 60) {
                            throw new IllegalArgumentException("O peso não pode ser maior que 60 kilos!");
                        } else if (peso < 0.5 && peso > 0.1) {
                            throw new IllegalArgumentException("O peso não pode ser menor que 0.5 kilos!");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        informacoesValidas = false;
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Para idade só são valido digitos!");
                        informacoesValidas = false;
                        Thread.sleep(1000);
                    }

                } while (!informacoesValidas);

                c++;

                String raca;

                do {

                    informacoesValidas = true;

                    System.out.println(perguntas.get(c));

                    System.out.print("Raça: ");
                    raca = sc.nextLine();

                    Matcher matcher3 = pattern2.matcher(raca);

                    if (raca.isBlank()) {
                        raca = "";
                    } else if (!matcher3.matches()) {
                        System.out.println("Digite um nome de raça valido!");
                        informacoesValidas = false;
                    }

                } while (!informacoesValidas);

                Pet pet = new Pet(nome, endereco, raca, idade, peso, enumTipo, enumSexo);

                listaPets.add(pet);

                System.out.println("PET ADICIONADO COM SUCESSO!");
                Thread.sleep(1000);

            } else if (opcao == 2) {

                if (!listarPetsPorCriterio(listaPets)){
                    System.out.println("Não existem pets com estes criterios");
                }

            } else if (opcao == 3) {

                boolean posicaoExiste;
                boolean infoExiste;

                String info;
                int num;

                if (listarPetsPorCriterio(listaPets)){

                    do {

                        posicaoExiste = true;

                        System.out.print("Digite o número na lista do pet que você deseja alterar: ");
                        num = sc.nextInt();
                        sc.nextLine();

                        if (num > listaPets.size() || num == 0) {
                            System.out.println("Digite um número de pet que existe na lista!");
                            posicaoExiste = false;
                            Thread.sleep(1000);
                        }

                    } while (!posicaoExiste);

                    num--;

                    do {

                        infoExiste = true;

                        System.out.print("Digite a informação que deseja trocar nesse pet: ");
                        info = sc.nextLine();

                        if (!info.equalsIgnoreCase("nome") && !info.equalsIgnoreCase("endereço") && !info.equalsIgnoreCase("endereco") && !info.equalsIgnoreCase("idade") && !info.equalsIgnoreCase("peso") && !info.equalsIgnoreCase("raca") && !info.equalsIgnoreCase("raça")){
                            System.out.println("As informações que podem ser alteradas são: nome, endereço, idade, peso e raça");
                            infoExiste = false;
                            Thread.sleep(1000);
                        }

                    }while (!infoExiste);

                    System.out.println("Digite o que deseja inserir na informação " + info + ": ");
                    String infoNova = sc.nextLine();

                    if (info.equalsIgnoreCase("Nome")){
                        listaPets.get(num).setNome(infoNova);
                    } else if (info.equalsIgnoreCase("endereco") || info.equalsIgnoreCase("endereço")){
                        listaPets.get(num).setEndereco(infoNova);
                    } else if (info.equalsIgnoreCase("idade")){
                        listaPets.get(num).setIdade(Double.parseDouble(infoNova));
                    } else if (info.equalsIgnoreCase("peso")){
                        listaPets.get(num).setPeso(Double.parseDouble(infoNova));
                    } else {
                        listaPets.get(num).setRaca(infoNova);
                    }

                }else {
                    System.out.println("Não encontrado");
                    Thread.sleep(1000);
                }



            } else if (opcao == 4) {

                if (listaPets.isEmpty()){
                    System.out.println("Você não possui pets cadastrados! ");
                    Thread.sleep(1000);
                }else {

                    for (Pet pet : listaPets) {

                        System.out.println(pet);

                    }
                }

            } else if (opcao == 5) {

                boolean posicaoExiste;

                int num;

                if (listarPetsPorCriterio(listaPets)) {

                    do {

                        posicaoExiste = true;

                        System.out.print("Digite o número na lista do pet que você deseja deletar: ");
                        num = sc.nextInt();
                        sc.nextLine();

                        if (num > listaPets.size() || num == 0) {
                            System.out.println("Digite um número de pet que existe na lista!");
                            posicaoExiste = false;
                            Thread.sleep(1000);
                        }

                    } while (!posicaoExiste);

                    boolean respostaValida;

                    num--;


                    do {

                        respostaValida = true;

                        System.out.print("Tem certeza que deseja excluir o pet " + listaPets.get(num).getNome() + "? (Sim/Não): ");
                        String confirmacao = sc.next();

                        if (!confirmacao.equalsIgnoreCase("Sim") && !confirmacao.equalsIgnoreCase("Nao")) {
                            System.out.println("Digite uma resposta valida!");
                            respostaValida = false;
                            Thread.sleep(1000);
                        }else {

                            if (confirmacao.equalsIgnoreCase("Sim")){
                                System.out.println("Pet excluido com sucesso!");
                                listaPets.remove(num);
                            }else {
                                System.out.println("OK!");
                            }

                        }

                    }while (!respostaValida);

                }

            } else if (opcao == 6) {
                sair = true;
            }

        } while (!sair);
    }

    public static int menu(Scanner sc) throws InterruptedException {

        boolean entradaValida = false;

        int opcao;

        System.out.println("========================================================");
        System.out.println("| 1 - Cadastrar um novo pet \uD83D\uDCDD                         |");
        System.out.println("| 2 - Buscar dados do pet cadastrado \uD83D\uDD0D                |");
        System.out.println("| 3 - Altera as informações de um pet cadastrado \uD83D\uDCDD    |");
        System.out.println("| 4 - Listar todos os pets cadastrados \uD83D\uDCCB              |");
        System.out.println("| 5 - Deletar um animal cadastro ❌                    |");
        System.out.println("| 6 - Sair \uD83D\uDEAA                                          |");
        System.out.println("========================================================");
        System.out.print("Digite: ");

        do {

            String opcaoString = sc.nextLine();

            try {

                opcao = Integer.parseInt(opcaoString);

                if (opcao > 0 && opcao < 7) {
                    entradaValida = true;
                } else {
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

    public static List<String> exibirFormulario() {

        List<String> perguntas = new ArrayList<>();

        String formulario = "C:\\Users\\emath\\IdeaProjects\\DesafioCadastroPets\\src\\src\\data\\formulario.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(formulario))) {

            String line = br.readLine();

            while (line != null) {
                perguntas.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return perguntas;
    }

    public static boolean listarPetsPorCriterio(List<Pet> listaPets) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        boolean algumEncontrado = false;

        if (listaPets.isEmpty()) {
            System.out.println("Você não possui pets cadastrados! ");
            Thread.sleep(1000);
        } else {

            boolean tipoValido;

            do {

                tipoValido = true;

                System.out.print("Digite o tipo do pet: ");
                String tipoAnimal = sc.next();

                if (!tipoAnimal.equalsIgnoreCase("Cachorro") && !tipoAnimal.equalsIgnoreCase("Gato")) {
                    System.out.println("Digite um tipo de pet valido! \n" + "Os validos são Cachorro e Gato!");
                    tipoValido = false;
                    Thread.sleep(1000);
                }

            } while (!tipoValido);

            System.out.print("""
                    1 - Nome ou sobrenome
                    2 - Sexo
                    3 - Idade
                    4 - Peso
                    5 - Raça
                    6 - Endereço
                    Digite:\s""");
            int opcao2 = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o criterio 1: ");
            String criterio1 = sc.nextLine();

            System.out.print("Deseja informar outro criterio? (S/N): ");
            String confirmacao = sc.next();


            boolean criterioValido;

            int opcao3;

            String criterio2 = "";

            if (confirmacao.equalsIgnoreCase("S")) {

                do {
                    criterioValido = true;

                    System.out.print("Digite o segundo criterio: ");
                    opcao3 = sc.nextInt();

                    if (opcao3 == opcao2) {
                        System.out.println("Digite outro criterio que não seja o que você já escolheu!");
                        criterioValido = false;
                        Thread.sleep(1000);
                    }

                } while (!criterioValido);

                System.out.print("Digite o criterio 2 que você escolheu: ");
                criterio2 = sc.next();

            }

            int c = 1;

            if (criterio2.isBlank()) {

                for (Pet listaPet : listaPets) {
                    if (listaPet.toString().toLowerCase().contains(criterio1.toLowerCase())) {
                        System.out.println(c + " - " + listaPet);
                        algumEncontrado = true;
                    }
                }

            } else {

                for (Pet listaPet : listaPets) {
                    if (listaPet.toString().toLowerCase().contains(criterio1.toLowerCase()) && listaPet.toString().toLowerCase().contains(criterio2.toLowerCase())) {
                        System.out.println(c + " - " + listaPet);
                        algumEncontrado = true;
                    }
                }
            }
            Thread.sleep(1000);
        }

        return algumEncontrado;
    }
}
