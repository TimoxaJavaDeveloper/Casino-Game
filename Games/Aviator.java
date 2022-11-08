package CasinoPackage.Games;

import CasinoPackage.Profile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Aviator extends Profile {

    private int StavkaMoney;
    private double NumbStavka;
    private double FinRec;

    private void getRandomNumb100(){
        FinRec = Math.random();
        FinRec = FinRec * 100 ;
        FinRec = new BigDecimal(FinRec).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private void getRandomNumb30(){
        FinRec = (Math.random() * 30);
        FinRec = new BigDecimal(FinRec).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private void getRandomNumb15(){
        FinRec = (Math.random() * 15);
        FinRec = new BigDecimal(FinRec).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private void getRandomNumb6(){
        FinRec = (Math.random() * 6);
        FinRec = new BigDecimal(FinRec).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private void getRandomNumb3(){
        FinRec = (Math.random() * 3);
        FinRec = new BigDecimal(FinRec).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }



    private void Shans(){
        int ShansNum = (int) (Math.random() * 40);
        switch (ShansNum){
            case 26,27,28,29,30,31,32,33,34,35,36,37,38,39,40:
                getRandomNumb3();
                break;
            case 9,10,11,7,13,14,15,16,17,18,1,20,21,22,3,24,25:
                getRandomNumb6();
                break;
            case 5,6,12,8,23:
                getRandomNumb15();
                break;
            case 0,19,2:
            getRandomNumb30();
            break;

            case 4:
                getRandomNumb100();
                break;
        }
    }

    private void Srav(){
        if(FinRec > NumbStavka){
            System.out.println("\nВы выйграли " + "+" + StavkaMoney + "\n");
            StartBalance += (StavkaMoney * NumbStavka);
        }else{
            System.out.println("\nВы проиграли " + "-" + StavkaMoney + "\n");
            StartBalance -= StavkaMoney;
        }
    }

    private void Game() throws InterruptedException {
        for(double i = 0; i <= FinRec; i += 0.01){
            i = new BigDecimal(i).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
            Thread.sleep(10);
            System.out.println(i);
        }
        Srav();
        StartGame();
    }

    public void Stavka(){
        Scanner scanStavka = new Scanner(System.in);
        System.out.println("Ваш баланс: " + StartBalance);
        System.out.print("Введите предпологаемое значение игры: ");
        NumbStavka = scanStavka.nextDouble();
        System.out.print("Введите сумму ставки: ");
        StavkaMoney = scanStavka.nextInt();
        if(StavkaMoney <= StartBalance){
            Shans();
        }else{
            System.out.println("На счету недостаточно средств");
            System.exit(0);
        }
    }

    public void StartGame() throws InterruptedException {
        Stavka();
        Game();
    }

}
