import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        List<String> Strings = new ArrayList<>();
        List<String> Queries = new ArrayList<>();

        //init arguments
        System.out.println("Waiting for input..");
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.next());
        for(int n=0;n<N;n++){
            Strings.add(scanner.next());
        }
        int Q = Integer.valueOf(scanner.next());
        for(int q=0;q<Q;q++){
            Queries.add(scanner.next());
        }
        //output array
        int []output = new int[Queries.size()];

        //checking
        for(int i=0;i<Queries.size();i++){
            for(int j=0; j<Strings.size();j++){
                //if(Strings.get(j).contains(Queries.get(i))){
                if(Strings.get(j).equals(Queries.get(i))){
                    //got a match
                    output[i] += 1;
                }
            }
        }
        //printing the output
        System.out.println("Output");
        for(int k=0;k<output.length;k++){
            System.out.println(output[k]);
        }
    }
}
