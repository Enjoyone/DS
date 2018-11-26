package Team;

public interface Equipment{
	String getDiscription();
}

class NoteBook implements Equipment{
	private String model;
	private double price;
	public NoteBook(){
		super();
	}
	public NoteBook(String model,double price){
		super();
		this.model=model;
		this.price=price;
	}
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model=model;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(){
		this.price=price;
	}
//override
	public String getDiscription(){
		return model+"("+price+")";
	}

}
class PC implements Equipment {
	private String model;
	private String display;
	public PC(){
		super();
	}
	public PC(String model,String display){
		super();
		this.model=model;
		this.display=display;
	}
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model=model;
	}
	public String getDisplay(){
		return display;
	}
	public void setDisplay(String display){
		this.display=display;
	}
//override
	public String getDiscription(){
		return model+"("+display+")";
	}

}
class Printer implements Equipment{
	private String type;
	private String name;
	public Printer(){
		super();
	}
	public Printer(String type,String name){
		super();
		this.type=type;
		this.name=name;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}

//over...

	public String getDiscription(){
		return type+"("+name+")";
	}


} 