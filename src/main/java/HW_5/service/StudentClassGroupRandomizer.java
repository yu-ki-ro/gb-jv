package HW_5.service;

import HW_5.model.StudentClass;
import HW_5.repository.StudentClassRepository;
import HW_5.service.StudentClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentClassGroupRandomizer {
    private final Random random;

    //    StudentClassRandomizer studentClassRandomizer;
    StudentClassRepository studentClassRepository;
    StudentClass studentClass;
    StudentClassService studentClassService;

    public StudentClassGroupRandomizer(StudentClassService studentClassService) {
        this.random = new Random();
//        this.studentClassRandomizer = studentClassRandomizer;
        this.studentClassRepository = StudentClassRepository.getInstance();
        this.studentClassService = studentClassService;
    }

    public List<StudentClass> getAvailableStudentClasses() {
        List<StudentClass> studentClasses = new ArrayList<>();
        int freeTeacherSlots, freeStudentSlots;
        for (StudentClass studentClass : studentClassRepository.getAll()) {
            freeTeacherSlots = studentClass.getMaxTeachers() - studentClass.getTeacherRoster().size();
            freeStudentSlots = studentClass.getMaxStudents() - studentClass.getStudentRoster().size();
            if (freeTeacherSlots > 0
                    && studentClassService.getAvailableTeachers().size() > 0
                    || freeStudentSlots > 0
                    && studentClassService.getAvailableStudents().size() > 0) {
                studentClasses.add(studentClass);
            }
        }
        return studentClasses;
    }

    public void populateAllStudentClasses() {
        List<StudentClass> studentClasses = getAvailableStudentClasses();
        if (studentClasses.size() == 0) {
            System.out.println("(fillAll:) <- все классы укомплектованы");
        }
        if (studentClasses.size() > 0) {
            do {
                studentClass = studentClasses.get(random.nextInt(studentClasses.size()));
                studentClassService.populateStudentClassById(studentClass.getId());
                studentClasses = getAvailableStudentClasses();
            } while (studentClasses.size() > 0);
        }
    }

}