package Operator.Operator;
public class Customer
{
    private String idNo;
    private String name;
    private int age;
    private char gender;
    private Address Address;
         
    public Customer(){
        idNo = name = ""; age = 0; gender = ' ';  
    }

    public Customer(String idNo, String name, int age, char gender,Address address){
        this.idNo = idNo; setName(name); setAge(age); setGender(gender);      
    }

    public void setName(String name)
    {
        if(name.length()>=3){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name is less than 3 Characters");
        }
    }
    
    public void setAge(int age)
    {
        if(!(age<0)){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Age is a negative number");
        }
    }

    public void setGender(char gender)
    {
        if(gender=='M' || gender == 'F'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Gender is not F or M");
        }
    }
    public void setAddress(Address address){
        this.Address = address;
    }
    static class Address{
    	private String houseNum;
        private String street;
        private String city;
        private int postal;
        public Address(){
            postal =  0;
            street = city =  houseNum=" ";

        }
        public  Address(String street, String city,String houseNo,int postal){
            this.city = city;
            this.houseNum = houseNo;
            this.postal =postal;
            this.street = street;
        }
        public void setStreet(String Street)throws IllegalArgumentException{
            if (Street.length()<5){
                throw new IllegalArgumentException("Street cannot be less than 5 letters");
            }else{

                this.street = Street;
            }
        }public void setCity(String city)throws IllegalArgumentException{
            if (city.length()<5){
                throw new IllegalArgumentException("City cannot be less than 5 letters");
            }else{
                this.city = city;
            }
        }public String toString(){
            return (houseNum+","+street+","+city+","+postal);
        }

    }
    
    public String toString(){
        return (idNo+","+name+","+age+","+gender+","+Address);
    }
    
    
}
