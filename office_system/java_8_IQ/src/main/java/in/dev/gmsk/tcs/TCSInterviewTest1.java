package in.dev.gmsk.tcs;

public class TCSInterviewTest1 {

     static int countingVowels(String values){
        int count = 0;

         for(int i = 0; i < values.length(); i++){

             char ch = values.charAt(i);

             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                 count++;
             }
         }

        return count;
    }

    static Long countingVowelsImplLambda(String values){

        return values.chars().filter(i -> i == 'a' || i == 'e' || i == 'i'
                || i == 'o' || i == 'u').count();
    }
}
