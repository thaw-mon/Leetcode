package Year2020.November.day06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Demo07 {

    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public boolean equals(Object obj) {
            Student student = (Student) obj;
            return student.score == this.score;
            //return super.equals(obj);
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }

    static class StudentCompare implements Comparator<Student> {
        private final int type;


        public StudentCompare(int type) {
            this.type = type;
        }

        @Override
        public int compare(Student o1, Student o2) {
            if (type == 0) { //从高到低
                return o2.score - o1.score;
            } else return o1.score - o2.score;
        }

    }

    /**
     * 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
     * 都按先录入排列在前的规则处理。
     */
    public void sortStudent(Student[] students, int type) {

        Arrays.sort(students);
        //Arrays.sort(students, new StudentCompare(type));

    }

    public void display(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int type = scanner.nextInt();
            Student[] students = new Student[N];
            for (int i = 0; i < N; i++) {
                String name = scanner.next();
                int score = scanner.nextInt();
                students[i] = new Student(name,score);
            }
           // Arrays.sort(students);
            Arrays.sort(students, new StudentCompare(type));
            for (Student student : students) {
                System.out.println(student);
            }
        }
        scanner.close();
    }
}
