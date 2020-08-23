import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class Tests {


    public class Kotki {

        public Kotki (String imie) {
            this.imie = imie;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        String imie;
    }

        @org.junit.Test
        public void PrintToArray(){

            ArrayList<Kotki> kotki = new ArrayList();
            kotki.add(new Kotki("Mania"));
            kotki.add(new Kotki("Szkrabus"));

            ArrayList<Kotki> manie = new ArrayList(kotki.stream().filter(kotek -> kotek.getImie() == "Mania").collect(Collectors.toList()));

            boolean czyJestMania = kotki.stream().anyMatch(kotek -> kotek.getImie() == "Mania");

            boolean czyWszystkieMania = kotki.stream().allMatch(kotek -> kotek.getImie() == "Mania");
        }


    }





