package com.xjgvpooCA.form;

import com.xjgvpooCA.form.elementos.ElementoForm;
import com.xjgvpooCA.form.elementos.InputForm;
import com.xjgvpooCA.form.elementos.SelectForm;
import com.xjgvpooCA.form.elementos.TextAreaForm;
import com.xjgvpooCA.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username", 5, 9);
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");
        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
            .addOpcion(new Opcion("2", "Python"))
            .addOpcion(new Opcion("3", "Javascript"))
            .addOpcion(new Opcion("4", "Typescript"))
            .addOpcion(new Opcion("5", "PHP"));

        username.setValor("john.doe");
        password.setValor("a1b3x2");
        email.setValor("johnd.email.com");
        edad.setValor("24");
        experiencia.setValor("Mas de 10 años de experiencia...");
        java.setSelected(true);

        List<ElementoForm> elementos =  Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje);


        elementos.forEach(e -> {
            System.out.println(e.dibujarHTML());
            System.out.println("<br>");
        });

    }
}
