package HW_5.service;

import lombok.Data;
import lombok.Getter;
import HW_5.controller.StudentClassController;
import HW_5.controller.StudentController;
import HW_5.controller.TeacherController;
import HW_5.repository.StudentClassRepository;
import HW_5.repository.StudentRepository;
import HW_5.repository.TeacherRepository;
import HW_5.service.StudentClassGroupRandomizer;
import HW_5.service.StudentClassService;
import HW_5.service.StudentService;
import HW_5.service.TeacherService;
import HW_5.view.StudentClassView;
import HW_5.view.StudentView;
import HW_5.view.TeacherView;

import java.io.IOException;

@Data
@Getter
public class Initializer {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentClassRepository studentClassRepository;

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final StudentClassService studentClassService;
    private final StudentClassGroupRandomizer studentClassGroupRandomizer;

    public final StudentView studentView;
    public final TeacherView teacherView;
    public final StudentClassView studentClassView;

    public Initializer() throws IOException {
        this.studentRepository = StudentRepository.getInstance();
        this.teacherRepository = TeacherRepository.getInstance();
        this.studentClassRepository = StudentClassRepository.getInstance();
        this.studentService = initStudentService();
        this.teacherService = initTeacherService();
        this.studentClassService = iniStudentClassService();
        this.studentView = initStudentView(studentService);
        this.teacherView = initTeacherView(teacherService);
        this.studentClassView = initStudentClassView(studentClassService);
        this.studentClassGroupRandomizer = new StudentClassGroupRandomizer(this.studentClassService);
    }

    private static StudentService initStudentService() throws IOException {
        return new StudentService();
    }

    private static TeacherService initTeacherService() throws IOException {
        return new TeacherService();
    }

    private static StudentClassService iniStudentClassService() {
        return new StudentClassService();
    }

    private static StudentView initStudentView(StudentService studentService) {
        StudentController studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static TeacherView initTeacherView(TeacherService teacherService) {
        TeacherController teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }

    private static StudentClassView initStudentClassView(StudentClassService studentClassService) {
        StudentClassController studentClassController = new StudentClassController(studentClassService);
        return new StudentClassView(studentClassController);
    }

}