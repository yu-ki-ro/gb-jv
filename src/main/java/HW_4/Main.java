package HW_4;

import HW_4.controller.StudentController;
import HW_4.controller.TeacherController;
import HW_4.repository.StudentRepository;
import HW_4.repository.TeacherRepository;
import HW_4.service.StudentService;
import HW_4.service.TeacherService;
import HW_4.view.SortType;
import HW_4.view.StudentView;
import HW_4.view.TeacherView;


public class Main {
    public static void main(String[] args) {
        StudentView studentView = getStudentView();
        TeacherView teacherView = getTeacherView();


        studentView.create("Ярослав Колосов", 20, "231556");
        studentView.create("Иван Козлов", 22, "332552");
        studentView.create("Матвей Романов", 18, "3215565");
        studentView.create("Матвей Романов", 18, "3215565");

        studentView.create("Эмма Полякова", 20, "216842226");
        studentView.create("Александра Осипова", 19, "168216544");

        studentView.sendOnConsole(SortType.AGE);

        teacherView.create("Алина Артемова", 33, "16542364");
        teacherView.create("Вера Чижова", 44, "16842484");
        teacherView.create("Вера Чижова", 44, "16842484");
        teacherView.create("Валерия Кузнецова", 40, "218423215");
        teacherView.create("Лидия Орлова", 35, "32168542");
        teacherView.create("Полина Назарова", 38, "15654651");
        teacherView.sendOnConsole(SortType.ID);

        teacherView.edit("Валерия Кузнецова", 40, "218423215");
        teacherView.sendOnConsole(SortType.ID);

        studentView.edit("Матвей Романович", 14, "24688");
        studentView.edit("Матвей Романов", 18, "32155652");
        studentView.sendOnConsole(SortType.AGE);

    }

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }

    private static TeacherView getTeacherView() {
        TeacherRepository repository = new TeacherRepository();
        TeacherService service = new TeacherService(repository);
        TeacherController controller = new TeacherController(service);
        return new TeacherView(controller);
    }
}