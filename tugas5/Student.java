public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = new String[10];
    private int[] grades = new int[10]; // nilai untuk setiap mata kuliah

    public Student(String nama, String alamat) {
        super(nama, alamat);
    }

    // Method tambah course dengan nilai
    public boolean addCourseGrade(String course, int grade) {
        // Cek apakah course sudah ada
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false; // Sudah ada
            }
        }
        
        // Tambah course baru
        if (numCourses < courses.length) {
            courses[numCourses] = course;
            grades[numCourses] = grade;
            numCourses++;
            return true;
        }
        return false;
    }

    // Method hapus course
    public boolean removeCourse(String course) {
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            return false;
        }
        
        // Shift array
        for (int i = index; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
            grades[i] = grades[i + 1];
        }
        courses[numCourses - 1] = null;
        grades[numCourses - 1] = 0;
        numCourses--;
        return true;
    }

    // Hitung rata-rata nilai
    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            total += grades[i];
        }
        return (double) total / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + getNama() + "(" + getAlamat() + ")";
    }
}