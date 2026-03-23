package Ex10;
//Lớp CreditCard - Phí 2%
class CreditCard extends PaymentMethod {
 public CreditCard(double amount) { super(amount); }

 @Override
 public double calculateFee() { return amount * 0.02; }

 @Override
 public double processPayment() { return amount + calculateFee(); }

 @Override
 public String processPayment(String currency) {
     return processPayment() + " " + currency;
 }
}

//Lớp DebitCard - Phí 1%
class DebitCard extends PaymentMethod {
 public DebitCard(double amount) { super(amount); }

 @Override
 public double calculateFee() { return amount * 0.01; }

 @Override
 public double processPayment() { return amount + calculateFee(); }

 @Override
 public String processPayment(String currency) {
     return processPayment() + " " + currency;
 }
}

//Lớp Cash - Không tính phí
class Cash extends PaymentMethod {
 public Cash(double amount) { super(amount); }

 @Override
 public double calculateFee() { return 0; }

 @Override
 public double processPayment() { return amount; }

 @Override
 public String processPayment(String currency) {
     return processPayment() + " " + currency;
 }
}
