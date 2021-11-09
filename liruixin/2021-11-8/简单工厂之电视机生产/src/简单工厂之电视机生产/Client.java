package 简单工厂之电视机生产;

public class Client {
     public static void main(String args[]) {
    	 television tv;
    	 tv=factory.getType("Haier");
    	 tv.manufacture();
     }
}
