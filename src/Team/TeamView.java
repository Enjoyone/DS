package Team;

public class TeamView {

	NameListService nameListService = new NameListService();
	TeamService teamService = new TeamService();


	public void listMainMenu() {
		boolean isFlag = true;
		do {
			System.out.println("2017012194刘国磊，开发团队调度软件");
			System.out.println("-------------------------------开发团队调度软件--------------------------------");
			System.out.println("ID\t \t\t姓名\t \t\t年龄\t \t\t工资\t\t \t职位\t\t \t状态\t\t \t奖金\t\t \t股票\t \t领用设备");
			Employee[] allEmployee = nameListService.getAllEmployee();
			for (int i = 0; i < allEmployee.length; i++) {
				System.out.println(allEmployee[i].toString());
			}
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

			char readMenuSelection =Get2_.readMenu();
			switch (readMenuSelection) {
			case '1':
				this.listTeamAllEmployee();
				break;
			case '2':
				 addEmployee();
				break;

			case '3':
				 deleteEmployee();
				break;

			case '4':
				System.out.println("是否退出（Y/N）?:");
				char readConfirmSelection = Get2_.readYN();
				if (readConfirmSelection == 'Y') {
					isFlag = false;
				}
				System.out.println("你以退出系统！！！");
				break;

			}
		} while (isFlag);

	}

	public void deleteEmployee() {
		System.out.print("请输入要删除员工的TID：");
		int readInt = Get2_.readInt();
		System.out.print("确认是否删除(Y/N)");
		char confirmSelection = Get2_.readYN();
		if (confirmSelection =='Y') {
			try {
				teamService.deleteMember(readInt);
				System.out.println("刪除成功");
			} catch (TeamExpection e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}

	public  void addEmployee() {
		// TODO Auto-generated method stub
		System.out.print("请输入要添加的员工ID：");
		int readInt = Get2_.readInt();
		Employee employee = null;
		try {
			employee = nameListService.getEmployee(readInt);
			teamService.addMember(employee);
			System.out.println("添加成功");
		} catch (TeamExpection e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Get2_.readReturn();
	}

	public  void listTeamAllEmployee()   {
		// TODO Auto-generated method stub
		System.out.println("--------------------团队成员列表---------------------");
		System.out.println("TID/ID\t	姓名\t\t\t年龄\t\t\t工资");
		Programmer[] team = teamService.getTeam();
		if (team.length>0 && team!=null) {
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getEmployeeInfo());
			}
		}else {
			System.out.println("目前团队没人，赶紧组织团队！!M");
		}
		Get2_.readReturn();
	}

	public static void main(String[] args) {
		new TeamView().listMainMenu();
	} 
}
