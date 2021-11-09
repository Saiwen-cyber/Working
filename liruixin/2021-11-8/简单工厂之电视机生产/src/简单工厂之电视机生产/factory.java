package 简单工厂之电视机生产;

public class factory {
	public static television getType(String type) {
		television tv=null;
		if(type.equalsIgnoreCase("Haier")) {
			tv=new Haier();
			}
		else if(type.equalsIgnoreCase("Hisense")) {
			tv=new Hisense();
			}
		return tv;
	}

}
