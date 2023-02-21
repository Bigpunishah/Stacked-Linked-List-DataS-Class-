
import java.util.Scanner;
import java.text.DecimalFormat;

class Stack{
    class Node{
        double data;
        Node next;

        Node(double data){
            this.data = data;
            next = null;
        }
    }

        Node top;

        protected void insert(double newData){
            Node newNode = new Node(newData);

            newNode.next = top;
            top = newNode;
        }

        public void pop(){
            if(top == null){
                System.out.println("Stack Empty.\n");
                return;
            }
            else{
                System.out.println("Top element removed.\n");
                top = top.next;
            }
        }

        public void deleteStack(){
            while(top != null){
                top = top.next;
            }
            System.out.println("Stack has been cleared\n");
        }

}

class Circle extends Stack{
    DecimalFormat df = new DecimalFormat(".00");
    double radius;
 
    public void setRadius(double radius){
        this.radius = radius;
        insert(radius);
    }
    
    public void getRadius(){
        radius = top.data;
        if(top == null){
            return;
        }
        else
        System.out.println(df.format(radius)); 
    }

    protected double calculateArea(){
        radius = top.data;
        double area;
        area = radius * Math.PI;
        return area;
    }

    public void displayStackElement(){
        if(top == null){
            System.out.println("Stack empty.\n");
            return;
        }
        else{
            System.out.println("\nRadius:  " + top.data);
            System.out.println("Area:    " + df.format(calculateArea()));
            System.out.println("\n");
        }
    }
}

public class Project7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle();

        String choice = "yes";
        int input = 0;

        while(choice == "yes"){
            System.out.print("(1 add to stack)\n(2 pop stack)\n(3 display element)\n(4 delete stack)\n(5 exit)\n\t");
            input = sc.nextInt();

            if(input == 1){
                System.out.print("Enter Radius:  ");
                double value = sc.nextInt();
                circle.insert(value);
            }
            if(input == 2){
                circle.pop();
            }
            if(input == 3){
                circle.displayStackElement();
                
            }
            if(input == 4){
                circle.deleteStack();
            }

            if(input == 5){
                choice = "no";
            }
        }
            sc.close();
    }
}
