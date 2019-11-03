// Class Money
class Money  {
	protected int amount;
	protected String currency;

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

    public boolean equals(Object object){
   		Money money = (Money) object;
   		return amount == money.amount && currency().equals(money.currency());
	}

	Money times(int multiplier){
		return new Money(amount * multiplier, currency);
	}
	
	String currency(){
		return currency;
	}   
}

// Testes
public void testMultiplication(){
   Money five = Money.dollar(5);
   assertEquals(Money.dollar(10), five.times(2));
   assertEquals(Money.dollar(15), five.times(3));
}

public void testEquality() {
   assertTrue(Money.dollar(5).equals(Money.dollar(5))); 
   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
   assertFalse(Money.franc(5).equals(Money.dollar(5)));
}

public void testCurrency() {
   assertEquals("USD", Money.dollar(1).currency());
   assertEquals("CHF", Money.franc(1).currency());
}