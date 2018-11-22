
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1=new Student("Павел", "Утлик", 3, new int[]{7, 8, 9, 5});
        Student student2=new Student("Дмитрий", "Линник", 3, new int[]{8, 9, 6});
        Student student3=new Student("Тимофей", "Серединский", 3, new int[]{7, 7});
        Student student4=new Student("Тимур", "Савко", 3, new int[]{9,8,7});
        System.out.println(student1+"Average Rating: "+student1.getAverageRating()+"\n");
        System.out.println(student2+"Average Rating: "+student2.getAverageRating()+"\n");
        System.out.println(student3+"Average Rating: "+student3.getAverageRating()+"\n");
        System.out.println(student4+"Average Rating: "+student4.getAverageRating()+"\n");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
  
        Group group = new Group(1, students);
        System.out.println(group+"Средний балл группы: "+group.getAverageRatingOfGroup());

    }
}
