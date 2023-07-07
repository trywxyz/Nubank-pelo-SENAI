
// import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Person> studants = new ArrayList<Person>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = true;
        while (exit) {

            System.out.println("------------Sistema--------------");
            System.out.println("------Escolha Uma Das Opções!------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair \n\n");

            int option = scanner.nextInt();

            switch (option) {
                case 1:

                    addStudant(studants);

                    break;

                case 2:

                    System.out.println(" \n Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudant(studants, nameToFind);

                    break;

                case 3:

                    removeStudant();

                    break;

                case 4:

                    editStudant();

                    break;

                case 5:

                    listStudant();

                    break;

                case 6:

                    System.out.println("SAINDO...");
                    // delay(500);
                    System.out.println("SAINDO..");
                    // delay(500);
                    System.out.println("SAINDO.");
                    // delay(500);
                    exit = false;

                    break;

                default:

                    System.out.println("OPÇÃO INVALIDA! OU INCORRETA");

                    exit = false;
                    break;

            }
        }
    }

    private static void addStudant(List<Person> studants) {
        Person studant = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Nome Completo do Estudante:");
        studant.name = scanner.next();
        System.out.println("Digite a Idade do Estudante");
        studant.age = scanner.nextInt();
        System.out.println("Digite o Sexo do Aluno!");
        studant.sexo = scanner.next();
        // studant.toUppercase();
        studants.add(studant);
        System.out.println("\nAluno ," + studant.name + " Com " + studant.age + " Anos Cadastrado Com Sucesso! \n");

    }

    private static Integer findStudant(List<Person> studants, String studantName) {
        Integer position = null;

        for (int count = 0; count < studants.size(); count++) {
            Person student = studants.get(count);

            if (student.name.equals(studantName)) {
                position = count;
                System.out.println("Encontrei o :" + studantName);
            } else {
                System.out.println("Não Encontrei o Aluno!");
            }
        }
        return position;
    }

    private static void listStudant() {
        int countm = 0;
        int countf = 0;

        for (int i = 0; i < studants.size(); i++) {
            if (studants.get(i).sexo.equals("masculino")) {
                countm++;
            } else {
                countf++;
            }

        }
        System.out.println("Masculino: " + countm + " Feminino: " + countf);

        for (int i = 0; i < studants.size(); i++) {

            System.out.println("Nome: " + studants.get(i).name + " Sexo: " + studants.get(i).sexo + " Idade: "
                    + studants.get(i).age);

        }

    }

    private static void removeStudant() {

        System.out.println("Qual o Nome Que Deseja Remover?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if (position != null) {

            studants.remove(position.intValue());
            System.out.print("Aluno Removido!");

        } else {
            System.out.println("Aluno Não Encontrado!");
        }

    }

    private static void editStudant() {

        System.out.println("Qual Nome Que Deseja Editar?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if (position != null) {
            Person p1 = studants.get(position.intValue());
            System.out.println("Qual Seria Novo Nome?");
            name = scanner.next();
            p1.name = name;

        }

    }

}