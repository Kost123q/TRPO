package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
    {
		ArrayList<Detail> details = new ArrayList<Detail>();
		Detail detail = null;

		Scanner in = new Scanner(System.in);
		System.out.print("Введите количество деталей: ");
	    int amount = in.nextInt();
        
        String type;
        String shape;
        String material;
        double weight;
    	double length;
    	double width;
    	double height;
    	String carType;
    	String model;
    	
    	// Создание объектов
    	
        try
        {
        	

        	for (int i = 0; i < amount; i++)
            {
            	System.out.print("\nВыберите тип создаваемой детали (машинная, станочная, телефонная): ");
            	type = in.next().toLowerCase();
            	System.out.print("Введите форму детали: ");
            	shape = in.next().toLowerCase();
            	System.out.print("Введите материал детали: ");
            	material = in.next().toLowerCase();
            	System.out.print("Введите вес детали: ");
            	weight = in.nextDouble();
            	System.out.print("Введите длину детали: ");
            	length = in.nextDouble();
            	System.out.print("Введите ширину детали: ");
            	width = in.nextDouble();
            	System.out.print("Введите высоту детали: ");
            	height = in.nextDouble();
            	
            	switch (type)
            	{
    				case "машинная": 
    				{
    					System.out.print("Введите тип машины (легковая, грузовая): ");
    					carType = in.next().toLowerCase();
    					detail = new CarDetail(shape, material, weight, length, width, height, carType);
    					break;
    				}
    				case "станочная":
    				{
    					detail = new MachineDetail(shape, material, weight, length, width, height);
    					break;
    				}
    				case "телефонная":
    				{
    					System.out.print("Введите модель телефона: ");
    					model = in.next().toLowerCase();
    					detail = new PhoneDetail(shape, material, weight, length, width, height, model);
    					break;
    				}
    				default:
    					System.out.print("Такого типа детали нет!");
    					continue;
            	}

            	details.add(detail);
            }
            
            // Общий вес деталей, имеющих одинаковую форму
            double[] totalWeight = Detail.GetTotalWeight(details);
            System.out.println(String.format("\nОбщий вес машинных деталей: %.2f\nОбщий вес станочных деталей: %.2f\n"
            		+ "Общий вес телефонных деталей: %.2f", totalWeight[0], totalWeight[1], totalWeight[2]));
            
            // Количество деталей
            System.out.println(String.format("\nКоличество деталей: %s", details.size()));
            
            
            // Полная информация по конкретной детали из всех имеющихся
            while (true)
            {
            	System.out.print("Выберите номер детали, по которой необходимо вывести полную информацию: ");
            	int numberOfDetail = in.nextInt() - 1;
            	System.out.print(details.get(numberOfDetail).GetFullInfo());
            	
            	System.out.print("Желаете выйти (Да / Нет)? ");
            	if (in.next().equals("Да"))
            		break;
            }
        }
        catch (java.util.InputMismatchException e)
        {
        	System.out.println("Ошибка: неверный формат ввода.");
        }
        finally
        {
        	in.close();
        }
    }
}