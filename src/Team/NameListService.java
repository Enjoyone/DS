package Team;
public class NameListService {

	private Employee[] employees = null;

	public NameListService() {
		employees = new Employee[Data.EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);

			Double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

			double bonus = 0;
			switch (type) {
			case Data.EMPLOYEE:
				Employee employee = new Employee(type,id, name, age,salary);
				employees[i] = employee;
				break;
			case Data.PROGRAMMER:
				Programmer programmer = new Programmer(type,id, name, age,salary,createEquipment(i));
				employees[i] = programmer;
				break;
			case Data.DESIGNER:
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				Designer designer = new Designer(type,id, name,  age,salary, createEquipment(i), bonus);
				employees[i] = designer;
				break;
			case Data.ARCHITECT:
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				Architect architcet = new Architect(type,id, name,  age,salary, createEquipment(i), bonus, stock);
				employees[i] = architcet;
				break;

			}

		}
	}
	public Equipment createEquipment(int i) {
		// TODO Auto-generated method stub
		String type = Data.EQIPMENTS[i][0];
		String model = Data.EQIPMENTS[i][1];
		switch (Integer.parseInt(type)) {
		case Data.PC:
			String display = Data.EQIPMENTS[i][2];
			PC pc = new PC(model, display);
			return pc;
		case Data.NOTEBOOK:
			double price = Double.parseDouble(Data.EQIPMENTS[i][2]);
			NoteBook noteBook = new NoteBook(model, price);
			return noteBook;
		case Data.PRINTER:
			String equipmentType = Data.EQIPMENTS[i][2];
			Printer printer = new Printer(model, equipmentType);
			return printer;
		}

		return null;
	}

	public Employee[] getAllEmployee() {
		return employees;
	}

	public Employee getEmployee(int id) throws TeamExpection{
		for (int j = 0; j < employees.length; j++) {
			
			if (id == employees[j].getId()) {
				return employees[j];
			}
		}
		throw new TeamExpection("不存在该员工");
	}

	public static void main(String[] args) {

	}
}
