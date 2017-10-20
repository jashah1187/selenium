package testNG;

public class helloworld {
	public static  int i;
    public static void main(String[] args) {
	multiply david = new multiply();
		 david.mul("10");
		i=1;
		while (i<=10)
		{
		System.out.println("Hello, World");
		System.out.println("helllo my name is ezekiel david , i study in bishop cotton boys school");
		i++;
		}
    }
public static class multiply{
private int counter,table,temp;
public  void mul(String table)
	{
	counter=1;
	while (counter <= table)
		{
			temp = counter*table;
			System.out.println(temp);
			counter=counter+1;
		}
	}	
} 
}
