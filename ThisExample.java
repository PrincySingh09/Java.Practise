class student{
    int rollno;
    String name;
    float fee;
    student (int rollno,String name,float fee){
        this.rollno=rollno;
        this.name=name;
        this.fee=fee;
    }
    void print(){
        System.out.println("hello this");
    }
    void display(){
        System.out.println(rollno+""+name+""+fee);
        this.print();
    }
}
class test{
    public static void main (String[] args) {
        student s1 =new student(001,"abc",22000);
         student s2 =new student(005,"xyz",23000);
         s1.display();
         s2.display();
    }
}