package HW_3;

public class Main {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        StudentRepository repository = new StudentRepository(group);
        StudentGroupService service = new StudentGroupService(repository);
        StudentController controller = new StudentController(service);

        System.out.println("\nСписок без сортировки:");
        controller.addStudent(new Student(4L, "Карпова Александра"));
        controller.addStudent(new Student(6L, "Косарев Дмитрий"));
        controller.addStudent(new Student(2L, "Ильина Вероника"));
        controller.addStudent(new Student(1L, "Анисимов Иван"));
        controller.addStudent(new Student(8L, "Ларин Владимир"));
        controller.printAll();

        System.out.println("\nСортировка по имени:");
        controller.sortByFirstName();
        controller.printAll();

        System.out.println("\nСортировка по фамилии:");
        controller.sortByLastName();
        controller.printAll();

    }
}