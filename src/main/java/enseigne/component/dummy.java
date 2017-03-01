package enseigne.component;

import enseigne.component.magasin.Magasin;

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
        mag.setInfoFr("on est la ");
        mag.setInfoEn("there we are");
        mag.setMaint(100);
        mag.setNbEmpl(2);
        mag.setPhoto("/home/luqua/IdeaProjects/IHM/src/main/resources/images/common/flags/france.png");
        mag.setRendu(500);
        mag.setWeb("salut.fr");
        HashMap<Integer,Integer> point = new HashMap<>();
        point.put(10,10);
        point.put(11,2);
        mag.setPointe(point);
        mag.write();

        new Magasin("/home/luqua/IdeaProjects/IHM/data/enseigne/stores/salut.fr.json");
    }
}
