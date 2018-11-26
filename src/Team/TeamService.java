package Team;

import javafx.scene.web.PromptData;

public class TeamService {

		private int counter = 1;

		private final int MAX_MEMBER = 5;

		private Programmer[] team = new Programmer[MAX_MEMBER];

		private int total = 0;

	public Programmer[] getTeam() {

		Programmer[] p = new Programmer[total];
		for (int i = 0; i < total; i++) {
			p[i] = team[i];
		}
		return p;
	}
	// 成员已满，无法添加
	// 该成员不是开发人员，无法添加
	// 该员已是团队成员
	// 该员正在休假，无法添加
	// 团队中只能有一名架构师
	// 团队中只能有两名设计师
	// 团队中只能有三名程序员
	public void addMember(Employee e) throws TeamExpection {
		//成员已满，无法添加
		if (total >= team.length) {
			throw new TeamExpection("成员已满，无法添加");
		}
		//该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamExpection("该成员不是开发人员，无法添加");
		}
		//已是
		for (int i = 0; i < total; i++) {
			if (e.getId() == team[i].getId()) {
				throw new TeamExpection("该员已是团队成员");
			}
		}

		Programmer p1 = (Programmer) e;
		if (p1.getStatus() == Status.VOCATION) {
			throw new TeamExpection("该员正在休假，无法添加");
		}
		// 一名架构师两名设计师三名程序员
		int proCount = 0;
		int desCount = 0;
		int arcCount = 0;
		for (int i = 0; i < team.length; i++) {
			Programmer p2 = team[i];
			if (p2 instanceof Designer) {
				arcCount++;
			} else if (p2 instanceof Designer) {
				desCount++;
			} else if (p2 instanceof Programmer) {
				proCount++;
			}
		}
		//p2 是团队中的程序员 p1是传进来要添加为团队成员的程序员
		if (p1 instanceof Architect) {
			if (arcCount >= 1) {
				throw new TeamExpection("团队只能有一名架构师");
			}
		} else if (p1 instanceof Designer) {
			if (desCount >= 2) {
				throw new TeamExpection("团队中只能有两名设计师");
			}
		} else if (p1 instanceof Programmer) {
			if (proCount >= 3) {
				throw new TeamExpection("团队中只能有三名程序员");
			}
		}
		// 添加成员到到团队中
		team[total++] = p1;
		// 改变成员的状态
		p1.setStatus(Status.BUSY);
		// 设置团队 成员id
		p1.setMemberId(counter++);

	}

	/*
	 * 删除团队成员
	 */
	public void deleteMember(int memberId) throws TeamExpection {
		//查找memberId是否在该团队中
		int j = 0;
		for (; j < total; j++) {
			if (team[j].getMemberId() == memberId) {
				team[j].setStatus(Status.FREE);
				break;
			}

		}
		//如果查不到在该团队中，就抛出异常
		if (j >= total) {
			throw new TeamExpection("没有找到对应的成员");
		}
		for (int i = j; i < total-1; i++) {
			 
			team[i] = team[i + 1];
		}
		team[total - 1] = null;
		total--;

	}
}
