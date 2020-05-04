package JavaConcurrency.ch5;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
 
    private static String message;
    private static Person person;
    private static AtomicReference<String> aRmessage;
    private static AtomicReference<Person> aRperson;
     
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRun1());
        Thread t2 = new Thread(new MyRun2());
        message = "hello";
        person = new Person("Phillip", 23);
        aRmessage = new AtomicReference<String>(message);
        aRperson = new AtomicReference<Person>(person);
        
        System.out.println("Message is: " + message
                + "\nPerson is " + person.toString());
        
        System.out.println("Atomic Reference of Message is: " + aRmessage.get()
                + "\nAtomic Reference of Person is " + aRperson.get().toString());
        t1.start();
        t2.start();
        t1.join();
        t2.join();  
        System.out.println("\nNow Message is: " + message 
                + "\nPerson is " + person.toString());
        System.out.println("Atomic Reference of Message is: " + aRmessage.get()
                + "\nAtomic Reference of Person is " + aRperson.get().toString());
    }
         
    static class MyRun1 implements Runnable {
 
        public void run() {
        	System.out.println("inside Therad >>>> " + Thread.currentThread().getName());
            //aRmessage.compareAndSet(message, "Thread 1");
            message = message.concat("-Thread 1!");
            person.setAge(person.getAge()+1);
            person.setName("Thread 1");
            aRmessage.getAndSet(message);
            aRperson.getAndSet(person);
            
            System.out.println("\n after seeting in " + Thread.currentThread().getName() +" Atomic References "
                    + message + " - " + person.toString());
        }       
    }
     
    static class MyRun2 implements Runnable {
 
        public void run() {
        	System.out.println("inside Therad >>>> " + Thread.currentThread().getName());
            message = message.concat("-Thread 2");
            person.setAge(person.getAge()+2);
            person.setName("Thread 2");
            
            aRperson.set(person);
            
            System.out.println("\n after setting in " + Thread.currentThread().getName() +" Atomic References: "
                    + aRmessage.get() + " - " + aRperson.get().toString());
        }       
    }
     
    static class Person {
         
        private String name;
        private int age;
         
        public Person(String name, int age) {
            this.name = name;
            this.age= age;
        }
 
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        public int getAge() {
            return age;
        }
         
        public void setAge(int age) {
            this.age = age;
        }   
         
        @Override
        public String toString() {
            return "[name " + this.name + ", age " + this.age + "]";
        }
    }
     
}