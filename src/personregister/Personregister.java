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
public class Personregister {

    private Person[] register;
    private static final int KAPASITET = 10;
    private int antall;
    
    public Personregister() {
        register = new Person[KAPASITET];
        antall = 0;
    }
    
    public boolean nyPerson(Person p) {
        if (antall < KAPASITET) {
            register[antall++] = p;
            return true;
        } else
            return false;
    }
    
    public String visPerson(int nr) {
        for (int i = 0; i < antall; i++) {
            if (register[i].getPersonnr() == nr)
                return register[i].toString();
        }
        return null;
    }
    
    public String visAlleNavn() {
        StringBuilder navneliste = new StringBuilder();
        for (int i = 0; i < antall; i++) {
            if (register[i] != null)
                navneliste.append(register[i].getNavn()).append("\n");
        }
            
        return navneliste.toString();
    }
    
    public boolean fjernPerson(String navn) {
        for (int i = 0; i < register.length; i++) {
            Person p = register[i];
            if (p != null) {
                if (navn.equals(p.getNavn())) {
                    register[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
