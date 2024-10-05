import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in); // Создаем объект для работы с консолью

    //Метод для тестов
    private static void Test() {
        SrvInput.initialization();

        //# Test 1: выдача студента по ID
        SrvInput.input("GET student 9");
        System.out.println(" - - - - ");
        SrvInput.input("GET student 1000"); // такого элемента в базе нет
        System.out.println("-----------------------------");

        //# Test 2: выдача студентов по курсу
        SrvInput.input("GET students 2");
        System.out.println(" - - - - ");
        SrvInput.input("GET students 1000");
        System.out.println("-----------------------------");


        //# Test 3: выдача студентов по курсу
        SrvInput.input("GET discipline 2");
        System.out.println(" - - - - ");
        SrvInput.input("GET discipline 100");
        System.out.println(" - - - - ");
        SrvInput.input("GET disciplines");  //выдача всех студентов
        System.out.println("-----------------------------");

        // Test  4: PUT
        //PUT student *имя студента* *номер курса*
        SrvInput.input("PUT student Dima 2");
        //PUT discipline *название дисциплины* *день недели* *номер пары* номер курса*
        SrvInput.input("PUT discipline Math monday 2 5");
        System.out.println("-----------------------------");

        // Test  5: DELETE
        SrvInput.input("DELETE student 10");
        SrvInput.input("DELETE student 1000");
        SrvInput.input("DELETE discipline 2");
//       System.out.println("-----------------------------");


    }


    public static void main(String[] args) {
        //Todo: метод для выполнения тестов, его нужно раскоментарить, и закоментить все что ниже него
        //Test();

        //Выбор вводы с консоли вмето метода тестов:
        SrvInput.initialization(); // подключаемся к БД
        System.out.println("Введите ваш запрос:");
        String line = scanner.nextLine(); // считываем линию
        SrvInput.input(line); //например: GET student 9
    }
}
