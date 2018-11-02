import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	//Новый массив типа Профайл
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	public static void main(String[] args) {
		profiles = (ArrayList<Profile>)deserData("profiles");
		System.out.println(profiles.size());
		Profile p = new Profile();
		p.setName(JOptionPane.showInputDialog(null, "Введите ваше имя"));
		p.setSurname(JOptionPane.showInputDialog(null, "Введите вашу фамилию"));
		
		profiles.add(p);
		
		for (Profile i:profiles) {
			System.out.println(i.getName()+" "+i.getSurname());
		}
		System.out.println(profiles.size());
		serData("profiles", profiles);
		
	}

	private static void serData(String file_name, Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file_name+".ser");
			try {
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(obj);
				fileOut.close();
				out.close();
			} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода");
			System.exit(1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
			System.exit(2);
		}
		
	}

	private static Object deserData(String file_name) {
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream(file_name+".ser");
			try {
				ObjectInputStream in = new ObjectInputStream(fileIn);
				try {
					retObject = in.readObject();
				} catch (ClassNotFoundException e) {
					System.out.println("Класс не найден");
					System.exit(3);
				}
				fileIn.close();
				in.close();
			} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода");
			System.exit(4);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
			System.exit(5);
		}
	return retObject;	
	}
	
}
