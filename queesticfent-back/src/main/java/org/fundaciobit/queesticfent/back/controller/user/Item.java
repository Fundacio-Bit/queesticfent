package org.fundaciobit.queesticfent.back.controller.user;

public class Item {

    String dia;
    String comentari;

    public Item() {
    }

    /**
     * @param dia
     * @param comentari
     */
    public Item(String dia, String projecte, String comentari) {
        super();
        this.dia = dia;
        this.comentari = comentari;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

}
