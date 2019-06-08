package com.zhang;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1.主方法
 * 2.查询所有学生
 * 3.添加学生
 * 4.删除学生
 * 5.修改学生
 */

public class Test {
public static void main(String[] args) {
	ArrayList<Student> array = new ArrayList<Student>();
	
	while(true) {
		System.out.println("欢迎来到中三宿舍成员管理中心:");
		System.out.println("1查看所有学生");
		System.out.println("2添加学生");
		System.out.println("3删除学生");
		System.out.println("4修改学生");
		System.out.println("5退出");
		
		System.out.println("请输入你的选择:");
		Scanner sc = new Scanner(System.in);
		String choiceString = sc.nextLine();
		
		switch(choiceString) {
		case"1":
			//查看所有学生
			seclectStudent(array);
			break;
		case"2":
			//添加学生
			addStudent(array);
			break;
		case"3":
			//删除学生
			deleteStudent(array);
			break;
		case"4":
			//修改学生
			updateStudent(array);
			break;
		case"5":
			//退出
			dafault:
			System.out.println("谢谢你的使用");
			System.exit(0);
			break;
		}
	}
}
//查询学生
/*1.无人
 *2.有人  得出信息
 */
public static void seclectStudent(ArrayList<Student> array) {
	if(array.size() == 0) {
		System.out.println("中三内还没有学生入住");
		return;
	}
	System.out.println("学号\t\t姓名\t年龄\t房间号");
	for(int x=0; x<array.size(); x++) {
		Student s = array.get(x);
		System.out.println(s.getId()+"\t\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getRoom());
		
	}
}
//添加学生
/*1.输入你要查询的学号
 *2.判断有没有学号存在,若无,则添加;若有,则显示学号已经存在;
 */
public static void addStudent(ArrayList<Student> array) {
	Scanner sc = new Scanner(System.in);
	String id;
	
	while(true) {
		System.out.println("请输入你要添加的学生学号");
		id = sc.nextLine();
		boolean flag = false;
		
		for(int x=0; x<array.size(); x++) {
			Student s = array.get(x);
			if(s.getId().equals(id)) {
			flag = true;
			break;
			}
		}
			if(flag) {
				System.out.println("你输入的学号已经被占用");
			}else {
				break;
			}
	}
		System.out.println("请输入姓名:");
		String name = sc.nextLine();
		System.out.println("请输入年龄:");
		String age = sc.nextLine();
		System.out.println("请输入房间号:");
		String room = sc.nextLine();
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setRoom(room);
		
		array.add(s);
		
		System.out.println("添加学生成功");
	}

//删除学生
public static void deleteStudent(ArrayList<Student> array) {
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入你要删除的学号:");
	String id = sc.nextLine();
	
	int index = -1;
	for(int x=0; x<array.size(); x++) {
		Student s = array.get(x);
		
		if(s.getId().equals(id)) {
			index = x;
			break;
		}
	}
	if(index == -1) {
		System.out.println("你要删除的学号不存在:");
	}else {
		array.remove(index);
		System.out.println("删除成功");
	}
}
//修改学生
public static void updateStudent(ArrayList<Student> array) {
	Scanner sc= new Scanner(System.in);
	System.out.println("请输入你想要修改的学号");
	String id = sc.nextLine();
	
	int index = -1;
	
	for(int x=0; x<array.size(); x++) {
		Student s = array.get(x);
		
		if(s.getId().equals(id)) {
			index = x;
			break;
		}
	}
	if(index == -1) {
		System.out.println("你要删除的学号信息不存在");
	}else {
		
		
		System.out.println("请输入你要改的名字");
		String name = sc.nextLine();
		System.out.println("请输入你要改的年龄");
		String age = sc.nextLine();
		System.out.println("请输入你要换的房间号");
		String room = sc.nextLine();
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setRoom(room);
		
		array.set(index,s);
		System.out.println("修改成功成功");
		
	}
}
}
