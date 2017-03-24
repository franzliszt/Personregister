/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personregister;

/**
 *
 * @author stianreistadrogeberg
 */
public class Person {
    private String navn;
    private int personnr;
    
    public Person(String n, int nr) {
        navn = n;
        personnr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public int getPersonnr() {
        return personnr;
    }
    
    @Override
    public String toString() {
        return String.format("Navn: %s, nummer %d", getNavn(), getPersonnr());
    }
}
