package Streams.TerminalOperations;

public class Employee {
    String name,department;
    int salary;
    public Employee(String name,String department,int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName(){
        return name;}
    public String getDepartment(){
        return department;}
    public int getSalary(){
        return salary;}

    @Override
    public String toString(){
        return "Employee{ name= "+ getName() +
                ", department="+ getDepartment()+
                ", salary="+ getSalary() + "}";

        }
}
