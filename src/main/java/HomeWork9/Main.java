package HomeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Oleg",Arrays.asList(new Course("Math"), new Course("Testing"))),
                new Student("Aleks",Arrays.asList(new Course("Math"), new Course("Testing"),
                        new Course("Biology"), new Course("Language"))),
                new Student("Peter",Arrays.asList(new Course("Chemistry"), new Course("Math"),
                        new Course("Physics"))),
                new Student("John",Arrays.asList(new Course("Testing"), new Course("Physics"),
                        new Course("Driving"), new Course("Reading")))
        ));

            // spisok unikalnih kursov

//        System.out.println(students.stream()
//                .map(s -> s.getCourses())
//                .flatMap(c -> c.stream())
//                             //  variant1: переопределить equals v Course для коркктной работы distinct
//                //.distinct()
//                //.collect(Collectors.toList());
//                            // variant2
//                .collect(Collectors.toSet()));
//        System.out.println("-----------------------------------------------------------------------------");

         // сортировка студентов по кол-курсов(3  у которых больше всего курсов)
//
//        System.out.println(students.stream()
//                        .sorted((s1,s2) -> s2.getCourses().size() - s1.getCourses().size())
//                        .limit(3)
//                        .collect(Collectors.toList()));
//        System.out.println("-------------------------------------");

           // сортировать стисок студентов которые посещают одит и тот же курс
      //  Course course = new Course("Physics");
//        System.out.println(students.stream()
//                .filter(s -> s.getCourses().contains(course))
//                .collect(Collectors.toList()));


        sortCourse(students,new Course("Physics"));
        sortStudent(students);
        uniqCourse(students);

    }

     static void sortCourse(List<Student> s , Course course) {
         course = new Course(course.getName());
         Course finalCourse = course;
         System.out.println( s.stream()
                .filter(students -> students.getCourses().contains(finalCourse))
                .collect(Collectors.toList()));
         System.out.println("-----------------------");
    }

    static void sortStudent(List<Student> s){
        System.out.println(s.stream()
                .sorted((s1,s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println("-------------------------------------");
    }
            // сортировка уникальных курсов
    static void uniqCourse(List<Student> s){
        System.out.println(s.stream()
                .map(st -> st.getCourses())
                .flatMap(c -> c.stream())
                //  variant1: переопределить equals v Course для коркктной работы distinct
//                .distinct()
//                .collect(Collectors.toList());
                // variant2
                .collect(Collectors.toSet()));
        System.out.println("-----------------------------------------------------------------------------");
    }

}
