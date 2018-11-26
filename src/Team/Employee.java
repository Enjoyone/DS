package Team;

public class Employee{
	int type;
	int id;
	String name;
	int age;
	double salary;

	public Employee(int type,int id,String name,int age,double salary){
		super();
		this.type=type;
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	public int type(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(){
		this.salary=salary;
	}
//
	public String getEmployeeInfo(){
		return type+"/"+id+"\t \t"+name+" \t \t"+age+"\t\t"+salary+"\t\t";
	}

	public String toString(){
		return getEmployeeInfo();
	}
}

class Programmer extends Employee{
	private int memberId;
    private Status status=Status.FREE;//
    private Equipment equipment;

	public Programmer(int type,int id,String name,int age,double salary,Equipment equipment){
		super(type,id,name,age,salary);
		this.equipment=equipment;
	}

	public int getMemberId(){
        return getMemberId();
	}
	public void setMemberId(int memberId){
		this.memberId=memberId;
	}
	public Status getStatus(){
		return status;
	}
	public void setStatus(Status status){
		this.status=status;
	}
	public Equipment getEquipment(){
		return equipment;
	}
	public void setEquipment(Equipment equipment){
		this.equipment=equipment;
	}

	//
	public String toString(){
		return getEmployeeInfo()+"\t程序员\t\t"+status+"\t\t \t\t\t\t\t"+equipment.getDiscription();
	}
	public String getEmployeeInfo(){
		return memberId+"/"+getId()+"\t\t\t"+getName()+"\t\t\t"+getAge()+"\t\t\t"+getSalary()+"\t";
	}
	
}
class Designer extends Programmer{
	double bonus;

	/*public Designer(){
		super();
	}*/
	public Designer(int type,int id,String name,int age,double salary,Equipment equipment,double bonus){
		super(type,id,name,age,salary,equipment);
		this.bonus=bonus;
	}
	public double getBonus(){
		return bonus;
	}
	public void setBoonus(double bonus){
		this.bonus=bonus;
	}
	//
	public String toString(){
		return getEmployeeInfo()+"设计师\t\t"+getStatus()+"\t"+getBonus()+"\t"+getBonus()+"\t"+getEquipment().getDiscription();
	}
	public String getMemberInfo(){
		return getMemberId()+getId()+getName()+getAge()+getSalary()+"设计师"+getBonus();
	}



}
class Architect extends Designer{
	int stock;

	/*public Architect(){
		super();
	}*/
	public Architect(int type,int id,String name,int age,double salary,Equipment equipment,double bonus,int stock){
		super(type,id,name,age,salary,equipment,bonus);
		this.stock=stock;
	}

	public int getStock(){
		return stock;
	}
	public void setStock(int stock){
		this.stock=stock;
	}
	//
	public String toString(){
		return getEmployeeInfo()+"架构师\t\t"+getStatus()+" \t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDiscription();
	}
	public String getMemberInfo(){
		return getMemberId()+getId()+getName()+"\t"+getAge()+getSalary()+"架构师\t"+getBonus()+"\t"+getStock();
	}
}
