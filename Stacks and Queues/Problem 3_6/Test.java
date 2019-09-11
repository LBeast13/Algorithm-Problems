public class Test{
    public static void main(String [] args){
        AnimalQueue shelter = new AnimalQueue();

        Dog d1 = new Dog("Max");
        Dog d2 = new Dog("Tom");
        Dog d3 = new Dog("Rex");

        Cat c1 = new Cat("Miaou");
        Cat c2 = new Cat("Mickey");

        shelter.enqueue(d1);
        shelter.enqueue(c1);
        shelter.enqueue(c2);
        System.out.println("Dequeued : " + shelter.dequeueAny().getName()); // Must dequeue d1 (Max)
        shelter.enqueue(d2);
        shelter.enqueue(d3);
        System.out.println("Dequeued Dog : " + shelter.dequeueDog().getName()); // Must be d2 (Tom)
        System.out.println("Dequeued Cat : " + shelter.dequeueCat().getName()); // Must be c1 (Miaou)

    }
}