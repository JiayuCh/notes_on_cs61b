public class dog {
    //instance variable
    public int weightInPounds;
    //static variable
    public static String general_name = "DOG";
    //constructor
    public dog(int w){
        weightInPounds = w;
    }
    //Non-static method, a.k.a Instance Method
    public void makeNoise() {
        if(weightInPounds < 10){
            System.out.println("too small a dog!");
        }else if(weightInPounds < 20){
            System.out.println("this dog is fine");
        }else{
            System.out.println("Too fat a dog");
        }
    }
    //Static method
    public static void declaration(){
        System.out.println("Yep, dogs.");
    }
    /*There is differences between static and non-static method:
    1 static methods are invoked using class name, whereas non-static methods are invoked
    using instance name.
    e.g. for static method: dog.declaration()
        for instance method: dog puppy = new dog(27); puppy.makeNoise();
    2 static methods don't have access to self.instance variables. The static method below
    is an example of wrong-using.
        public static void makeNoise(){
            if(weightInPounds < 10){
                System.out.println("too small a dog!");
            }else if(weightInPounds < 20){
                System.out.println("this dog is fine");
            }else{
                System.out.println("Too fat a dog");
            }
        }
    */
    /*why static methods?
    some methods just never instantiated. e.g. Math.round(5, 6);
    */
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
    //what does this String[] args do?
    /*if u call this method from cmd:
    $ java dog hey some args
    it wound return: hey
    */
}
