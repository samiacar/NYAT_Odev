package NYATODEV;

import java.util.ArrayList;
import java.util.Random;

public class EyleyiciAlgila implements IEyleyiciVeAlgilayici {
    private ArrayList List = new ArrayList();
    @Override
    public void SogutucuAc() {
        messageShow(" Sogutucu Acildi ");
    }

    @Override
    public void SogutucuKapa() {
        messageShow("Sogutucu kapatildi ");
    }

    @Override
    public int SicaklikOku() {
        Random rand = new Random();
        int sayi = rand.nextInt(100);
        return sayi;
    }

    int sicaklik;
    @Override
    public int SicaklikGonder() {
        sicaklik=SicaklikOku();
        messageShow("Sicaklik    : "+ sicaklik+"°C");
        return SicaklikOku();
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    public void regObserver(Observer i) {
        List.add(i);
    }

    public void deleteObserver(Observer i) {
        int j = List.indexOf(i);
        if (j >= 0) {
            List.remove(i);
        }
    }

    public void notObservers() {
        for (int j = 0; j < List.size(); j++) {
            Observer observer = (NYATODEV.Observer) List.get(j);
            observer.update(SicaklikGonder());
        }
    }
}
