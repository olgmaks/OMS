package com.softserve.edu.data;

public class Card implements  ICardNumber ,IExpirymonth , IExpiryYear ,ICardType , ICvv,IBuildCard {
	
	private String  creditcardType; 
    private String  creditcardnumber; 
    private String  cvv; 
    private String  expirymonth; 
    private String  expiryyear; 
   
    
    private Card() {
    }

    public static ICardType get() {
        return new Card();
    }
    
    public ICardNumber setCardType(String creditcardType) {
        this.creditcardType = creditcardType;
        return  this;
    }
    
    
    public ICvv setCardNumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
        return  this;
    }
    
    public IExpirymonth setCvv(String cvv) {
	    this.cvv = cvv;
        return  this;
    }
    
    public IExpiryYear setexpirymonthv(String expirymonth) {
	    this.expirymonth = expirymonth;
        return  this;
    }
    
    public IBuildCard setexpiryyear(String expiryyear) {
	    this.expiryyear = expiryyear;
        return  this;
    }
    
    
    public Card build() {
        return this;
    }
    

    public String getCreditcardType(){
    	return this.creditcardType;
    }
  
     public String getCreditcardnumber() {
        return this.creditcardnumber;
    }
    public String getCvv() {
        return this.cvv;
    }
    public String getexpirymonth() {
        return this.expirymonth;
    }
    public String getexpiryyear() {
        return this.expiryyear;
    }
    
    
    
}
