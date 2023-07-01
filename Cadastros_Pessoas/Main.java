
// import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


List<Person> studants = new ArrayList<Person>();
boolean exit = true;
while (exit){
            
        
        Scanner scanner = new Scanner(System.in);

    System.out.println("------------Sistema--------------");
    System.out.println("------Escolha Uma Das Opções!------");
    System.out.println("1 - Cadastrar");
    System.out.println("2 - Buscar");
    System.out.println("3 - Sair \n\n");

    int option = scanner.nextInt();



    switch (option){
    case 1 :

        addStudant(studants);

        break;

    case 2 :
    
        System.out.println(" \n Qual o nome que deseja buscar?");
        String nameToFind = scanner.next();
        findStudant(studants, nameToFind);

        break;


    case 3 :

        System.out.println("SAINDO...");
        System.out.println("SAINDO..");
        System.out.println("SAINDO.");
        exit = false;
        break;

    
    default:

        System.out.println("OPÇÃO INVALIDA! OU INCORRETA");

        exit = false;
        break;

            }
        }
    }

    private static void addStudant(List<Person> studants){

        Person studant = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome completo do estudante:");
        studant.name = scanner.nextLine();
        studants.add(studant);
        System.out.println("\n" + studant.name + ",Aluno Cadastrado Com Sucesso! \n");

    }





    private static void findStudant (List<Person> studants, String studantName) {

        for(int count = 0; count < studants.size(); count++){
            Person student = studants.get(count);

            if(student.name.equals(studantName)){
                System.out.println("Encontrei o :" + studantName);
            }
        }
    }
}