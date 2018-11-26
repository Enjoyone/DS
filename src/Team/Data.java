package Team;

public class Data {
	/*
	 * 员工职位的分类
	 */
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    /*
     * 设备的分类
     */
    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"10", "1", "bill", "22", "3000"},
        {"13", "2", "mike", "32", "18000", "15000", "2000"},
        {"11", "3", "May", "23", "7000"},
        {"11", "4", "Sum", "24", "7300"},
        {"12", "5", "Spring", "28", "10000", "5000"},
        {"11", "6", "We", "22", "6800"},
        {"12", "7", "john", "29", "10800","5200"},
        {"13", "8", "james", "30", "19800", "15000", "2500"},
        {"12", "9", "KD", "26", "9800", "5500"},
        {"11", "10", "tom", "21", "6600"},
        {"11", "11", "lili", "25", "7100"},
        {"12", "12", "curry", "27", "9600", "4800"}
    };

    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, type, name
    public static final String[][] EQIPMENTS = {
        {},
        {"22", "联想", "6000"},
        {"21", "戴尔", "NEC17寸"},
        {"21", "戴尔", "三星 17寸"},
        {"23", "apple", "佳能 2900"},
        {"21", "华硕", "三星 17寸"},
        {"21", "华硕", "三星 17寸"},
        {"23", "samsung", "爱普生20K"},
        {"22", "惠普", "5800"},
        {"21", "戴尔", "NEC 17寸"},
        {"21", "华硕","三星 17寸"},
        {"22", "惠普", "5800"}
    };
}
