package com.none.domain;





import java.time.LocalDate;
import java.util.Random;

public class Card {
    private  String CardNumber;
    private String cvv2;
    private String Password;
    private LocalDate ExpiredDate;
    private Integer id;
    public Card( String password) {
        Random random=new Random();
        int num= random.nextInt(100000,9999999);
        this.CardNumber="673245"+num;
         this.id=random.nextInt();
        this.cvv2 = String.valueOf(random.nextInt(4));
        this.Password = password;
        this.ExpiredDate =LocalDate.now().plusYears(5);
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public Integer getId() {
        return id;
    }

    public boolean Validation(String pass){
        return pass.equals(this.Password);
    }

}

