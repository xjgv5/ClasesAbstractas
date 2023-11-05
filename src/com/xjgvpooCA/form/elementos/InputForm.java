package com.xjgvpooCA.form.elementos;

public class InputForm extends ElementoForm{

    private String tipo = "text";

    public InputForm(String nombre, int i, int i1) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHTML() {
        return "<input type=\"" + this.tipo
        + "\" name=\"" + this.nombre
                + "\" value=\"" + this.valor + "\">";
    }
}
