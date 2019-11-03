// Class Money
abstract class Money  {
   protected int amount;
   protected String currency;
   
   public boolean equals(Object object){
   	Money money = (Money) object;
   	return amount == money.amount && getClass().equals(money.getClass());
   }

	static Money dollar(int amount){
  		return new Dollar(amount, "USD");
	}

	static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}

	Money(int amount, String currency) {
      this.amount = amount;
      this.currency = currency;
    }

	abstract Money times(int multiplier);
	
	String currency(){
		return currency;
	}   
}

// Classe Dollar
class Dollar extends Money {

  Dollar(int amount, String currency){
  	super(amount, currency);
  }

  Money times(int multiplier){
  	return Money.dollar(amount * multiplier);
  }  
}

// Classe Franc
class Franc extends Money {

  Franc(int amount, String currency){
  	super(amount, currency);
  }

  Money times(int multiplier){
  	return Money.franc(amount * multiplier);
  }
}

// Testes
public void testMultiplication(){
   Money five = Money.dollar(5);
   assertEquals(Money.dollar(10), five.times(2));
   assertEquals(Money.dollar(15), five.times(3));
}

public void testFrancMultiplication(){
   Money five = Money.franc(5);
   assertEquals(Money.franc(10), five.times(2));
   assertEquals(Money.franc(15), five.times(3));
}

public void testEquality(){
   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
   assertTrue(Money.franc(5).equals(Money.franc(5)));
   assertFalse(Money.franc(5).equals(Money.franc(6)));
   assertFalse(Money.franc(5).equals(Money.dollar(5)));
}

public void testCurrency() {
   assertEquals("USD", Money.dollar(1).currency());
   assertEquals("CHF", Money.franc(1).currency());
}