package Operator.Operator;
public class Account
{
  private int phoneNo;
  private double pointsBal;
  private Customer customer;

  
  public Account()
  {
      phoneNo = 0;
      pointsBal = 0.0;
      customer =null;
  }
  
  
  public Account(int phoneNo, Customer customer)
  {
      this.phoneNo = phoneNo;
      this.pointsBal = 0.0;
      this.customer = customer;
  }

  public int getPhoneNo()
  {
      return phoneNo;
  }
  
  public void updatePointsBalance(int airtime){
      this.pointsBal += airtime/10;
  }
  
  public double getBonusAirtimes(){
      return (this.pointsBal*2);
  }  
 
  public String toString(){
      return (this.phoneNo+","+this.pointsBal+","+this.customer.toString());
  } 
  
}

