import java.util.LinkedList;

/**
 * PROBLEM 3.6 : Animal Shelter
 * 
 * An animal shelter, which holds only dogs and cats, operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest" (based
 * on arrival time) of all animals at the shelter, or they can select wheter 
 * they would prefer a dog or cat (and will receive the oldest animal of that
 * type). They cannot select which specific animal they would like. 
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog and dequeueCat. 
 * You may use the built-in LinkedList data structure. 
 */
public class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal an){
        an.setOrder(order);
        this.order++;

        if(an instanceof Dog){
            dogs.addLast((Dog) an);
        } else if ( an instanceof Cat){
            cats.addLast((Cat) an);
        }
    }

    public Animal dequeueAny(){
        if(dogs.isEmpty()){
            return dequeueCat();
        } else if(cats.isEmpty()){
            return dequeueDog();
        } 
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        
        return (dog.isOlderThan(cat)) ? dequeueDog() : dequeueCat();
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    public Cat dequeueCat(){
        return cats.poll();
    }
}