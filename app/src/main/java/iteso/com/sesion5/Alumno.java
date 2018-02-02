package iteso.com.sesion5;

/**
 * Created by hecto on 01/02/2018.
 */

public class Alumno {
    String name, phone, degree, gender, favBook;
    Boolean sports;

    Alumno(){
        name = "";
        phone = "";
        degree = "";
        gender = "";
        favBook = "";
        sports = true;
    }

    Alumno(String name, String phone, String degree, String gender, String favBook, Boolean sports){
        this.name = name;
        this.phone = phone;
        this.degree = degree;
        this.gender = gender;
        this.favBook = favBook;
        this.sports = sports;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFavBook(String favBook) {
        this.favBook = favBook;
    }

    public void setSports(Boolean sports) {
        this.sports = sports;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDegree() {
        return degree;
    }

    public String getGender() {
        return gender;
    }

    public String getFavBook() {
        return favBook;
    }

    public Boolean getSports() {
        return sports;
    }

    @Override
    public String toString() {
        return ("Nombre: " + name + "\n" +
                "Telefono: " + phone + "\n" +
                "Escolaridad: " + degree + "\n" +
                "Genero: " + gender + "\n" +
                "Libro favorito: " + favBook + "\n" +
                "Practica deporte: " + (sports ? "Si" : "No"));
    }
}

