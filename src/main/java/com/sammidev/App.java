package com.sammidev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Student student = new Student("samidev","20031139");
        Details details = new Details(1,"A","SI","ILKOM");
        Object[][] students = {
                {student,details},
                {
                    new Student((student.getName() + " ganteng"), (student.getNim() + " 100")),
                    new Details((details.getSemester() + 1), details.getKelas(),details.getProdi(),details.getJurusan())}
                };
        System.out.println(students[0][0].toString());
        System.out.println(students[0][1].toString());
        PrintUtilities.print(Arrays.deepToString(students));
    }

    static class Details {
        @Override
        public String toString() {
            return "Details{" +
                    "semester=" + semester +
                    ", kelas='" + kelas + '\'' +
                    ", prodi='" + prodi + '\'' +
                    ", jurusan='" + jurusan + '\'' +
                    '}';
        }

        private Integer semester;
        private String kelas;
        private String prodi;
        private String jurusan;

        public Integer getSemester() {
            return semester;
        }

        public void setSemester(Integer semester) {
            this.semester = semester;
        }

        public String getKelas() {
            return kelas;
        }

        public void setKelas(String kelas) {
            this.kelas = kelas;
        }

        public String getProdi() {
            return prodi;
        }

        public void setProdi(String prodi) {
            this.prodi = prodi;
        }

        public String getJurusan() {
            return jurusan;
        }

        public void setJurusan(String jurusan) {
            this.jurusan = jurusan;
        }

        public Details(Integer semester, String kelas, String prodi, String jurusan) {
            this.semester = semester;
            this.kelas = kelas;
            this.prodi = prodi;
            this.jurusan = jurusan;
        }
    }
    static class Student {
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", nim='" + nim + '\'' +
                    '}';
        }

        private String name;
        private String nim;

        public Student(String name, String nim) {
            this.name = name;
            this.nim = nim;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }
    }
    static void learn() {
        Object[] names = new Object[]{"sammi", 19, true};
        System.out.println(Arrays.toString(names));

        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        String[][] emails = new String[][]{
                {"Sammidev@gmail.com", "adid@gmail.com"},
                {"Sammi@yahoo.com", "testing@gmail.com"},
                {"sappe@gmail.com", "testing@gmail.com"}
        };

        for (int i = 0; i < emails.length; i++) {
            for (int j = 0; j < emails[0].length; j++) {
                System.out.println(emails[i][j]);
            }
        }

        Boolean[][] statuses = new Boolean[][]{
                {true, false, false},
                {true, true, true, true, true},
                {false},
                {true}
        };

        System.out.println(Arrays.toString(emails)); // address
        System.out.println(Arrays.deepToString(emails)); // values
        System.out.println(statuses[0][0]); // values
        System.out.println(Arrays.deepToString(statuses)); // values

        String[] hobbies = {"ngoding", "mancing"};
        Arrays.stream(hobbies).forEach(System.out::println);

        String[][] hobbies2 = {{"a", "b"}, {"c"}, {"d", "e", "f", "g"}};
        Arrays.stream(hobbies2).flatMap(Arrays::stream).forEach(System.out::println);

        String[] lang = {"JAVA","GOLANG","RUBY","PYTHON"};
        Integer[] calculate = {(2 + 2), (2 * 2)};
        Object[] objects = {true,false,1.2,54F,"sammi",lang,calculate};

        PrintUtilities.print(lang);
        PrintUtilities.print(calculate);
        PrintUtilities.print(objects);
    }
    static class PrintUtilities {
        private static final ObjectMapper mapper = new ObjectMapper();
        public static void print(Object object) {
            String result;
            try {
                result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
                System.out.println(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}