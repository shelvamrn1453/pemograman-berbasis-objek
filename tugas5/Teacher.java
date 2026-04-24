public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[5]; // maksimal 10 mata kuliah

    public Teacher(String nama, String alamat) {
        super(nama, alamat);
    }

    // Method tambah course
    public boolean addCourse(String course) {
        // 1. Cek apakah course sudah ada
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false; // Sudah ada, return false
            }
        }   
        // 2. Cek apakah course masih kosong
        if (numCourses < 5) {
            courses[numCourses] = course; // tambah di index terakhir
            numCourses++; // counter naik
            return true; // berhasil
        }
        return false; // array penuh
    }

    // Method hapus course
    public boolean removeCourse(String course) {
        // 1. Cari index course yang mau dihapus
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                index = i;
                break;
            }
        }
        
        // 2. Kalau tidak ditemukan
        if (index == -1) {
            return false;
        }
        
        // 3. Hapus dengan shifting (geser elemen setelahnya)
        for (int i = index; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[numCourses - 1] = null; // hapus referensi terakhir
        numCourses--; // counter turun
        return true;
    }

    @Override
    public String toString() {
        return "Teacher: " + getNama() + "(" + getAlamat() + ")";
    }
}