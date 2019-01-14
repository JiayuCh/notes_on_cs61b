import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        dog chiwawa = new dog(9);
        //chiwawa.weightInPounds = 9;
        chiwawa.makeNoise();

        //declaration only
        dog little_one;
        //Instantiation without declaration
        new dog(20);
        //Instantiation and Assignment
        little_one = new dog(7);
        //Declaration, Instantiation and Assignment
        dog big_one = new dog(33);
        //Invocation
        little_one.makeNoise();
        big_one.makeNoise();

        dog[] dog_hommmie = new dog[2];
        dog_hommmie[0] = new dog(8);
        dog_hommmie[1] = new dog(18);
        //if u r trying to get access to a static variable of a class. This is preferred
        System.out.println(dog.general_name);
        //over this one.
        System.out.println(little_one.general_name);
    }
}