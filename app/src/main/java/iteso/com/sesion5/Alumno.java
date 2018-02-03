package iteso.com.sesion5;

/**
 * Created by hecto on 01/02/2018.
 */

public class Alumno {
    String name, phone, degree, gender, favBook;
    Boolean sports;

    Alumno(String name, String phone, String degree, String gender, String favBook, Boolean sports){
        this.name = name;
        this.phone = phone;
        this.degree = degree;
        this.gender = gender;
        this.favBook = favBook;
        this.sports = sports;
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

