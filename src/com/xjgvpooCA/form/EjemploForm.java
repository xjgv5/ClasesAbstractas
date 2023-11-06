package com.xjgvpooCA.form;

import com.xjgvpooCA.form.elementos.*;
import com.xjgvpooCA.form.elementos.select.Opcion;
import com.xjgvpooCA.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username", 5, 9);
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        lenguaje.addOpcion(new Opcion("1", "Java").setSelected())
            .addOpcion(new Opcion("2", "Python"))
            .addOpcion(new Opcion("3", "Javascript"))
            .addOpcion(new Opcion("4", "Typescript"))
            .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm() {
            @Override
            public String dibujarHTML() {
                return "<input disabled name = '" + this.nombre +
                        "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Campo deshabilitado");

        username.setValor("john.doe");
        password.setValor("a2");
        email.setValor("johnd.email.com");
        edad.setValor("24");
        experiencia.setValor("Mas de 10 años de experiencia...");


        List<ElementoForm> elementos =  Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);


        elementos.forEach(e -> {
            System.out.println(e.dibujarHTML());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });

    }
}
