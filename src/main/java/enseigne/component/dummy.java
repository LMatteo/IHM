package enseigne.component;

import java.io.IOException;
import java.util.HashMap;

public class dummy {
    public static void main(String[] args) throws IOException{
        Magasin mag = new Magasin();
        mag.setAddr("31 avenue de salut");
        mag.setChiffreAffaire(10);
        HashMap<Integer,Integer> age = new HashMap<>();
        age.put(10,50);
        age.put(11,80);
        age.put(12,90);
        mag.setAge(age);
        mag.setCentre("centre de sophia");
        mag.setInfo("on est la ");
        mag.setMaint(10);
        mag.setNbEmpl(2);
        mag.setPhoto("/home/luqua/IdeaProjects/IHM/src/main/resources/images/common/flags/france.png");
        mag.setRendu(10);
        mag.setWeb("salut.fr");
        mag.write();
    }
}
