package Team;

import java.util.*;
import java.lang.String;
public class Get2_{
	private static Scanner scanner=new Scanner(System.in);

	public static String reaKeyBoard(int limit,boolean blankReturn){
		String line="";
		while(scanner.hasNextLine()){
			line=scanner.nextLine();
			if(line.length()==0){
				if(blankReturn)
					return line;
				else
					continue;
			}
			if(line.length()<1||line.length()>limit){
				System.out.println("错误！");
				continue;
			}
			break;
		}
		return line;
	}

	public static char readMenu(){
		char c;
		for (; ; ) {
			String str=reaKeyBoard(1,false);
			c=str.charAt(0);
			if (c!='1'&&c!='2'&&c!='3'&&c!='4') {
				System.out.println("错误！");
			}
			else
				break;
		}
		return c;
	}

	public static void readReturn(){
		System.out.println("回车继续");
		reaKeyBoard(100,true);
	}

	public static int readInt(){
		int n;
		for (; ; ) {
			String str=reaKeyBoard(2,false);
			try{
				n=Integer.parseInt(str);
				break;
			}
			catch(NumberFormatException e){
				System.out.println("错误！");
			}
		}
		return n;
	}


	public static char readYN(){
		char c;
		for (; ; ) {
			String str=reaKeyBoard(1,false).toUpperCase();
			c=str.charAt(0);
			if (c=='Y'||c=='N') {
				break;
			}
			else{
				System.out.println("错误！");
			}
		}
		return c;
	}

	














}