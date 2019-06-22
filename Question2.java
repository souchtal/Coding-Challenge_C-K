import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N1 = Integer.valueOf(scanner.next());
        int N2 = Integer.valueOf(scanner.next());

        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();

        //init arguments
        System.out.println("Waiting for input..");
        for(int n=0;n<N1;n++){
            L1.add(Integer.valueOf(scanner.next()));
        }
        for(int n=0;n<N2;n++){
            L2.add(Integer.valueOf(scanner.next()));
        }

        //util vars
        List<Integer> temp = L1;
        HashMap<Integer, ArrayList<Integer>> indices = new HashMap<>();

        int min_transformation = 0;
        int add_ops = 0;
        int rm_ops = 0;
        int mv_ops = 0;

        //count the add/remove operations
        for(int i=0;i<N1;i++){
            if(! L2.contains(L1.get(i))){
                //in L1 but not in L2
                rm_ops +=1;
                temp.remove(L1.get(i));
            }if(! L1.contains(L2.get(i))){
                //in L2 but not in L1
                add_ops +=1;
                temp.add(i, L2.get(i));
            }
        }

        //reorder for final transformation
        for(int i=0;i<N2;i++){
            //setting up indices for the temp array
            int finalI = i;
            indices.put(temp.get(i), new ArrayList<Integer>() {{
                add(finalI);
            }});
        }

        for(int k=0;k<N2;k++){

            indices.get(temp.get(k));
            ArrayList<Integer> old_index = (ArrayList<Integer>)indices.get(temp.get(k));
            int new_index = L2.indexOf(temp.get(k));

            if(! (old_index).contains(new_index)){
                //swap by updating index
                indices.put(temp.get(k), new ArrayList<Integer>() {{
                    add(new_index);
                }});
                //update indices of substitute elements
                for(int j=new_index;j<N2;j++){
                    indices.get(temp.get(j)).add(indices.get(temp.get(j)).get(0)+1);
                }
                mv_ops++;
            }
        }

        min_transformation = add_ops+rm_ops+mv_ops;
        //System.out.println("Added ops "+add_ops+" removed ops "+rm_ops +" moved ops "+mv_ops);
        System.out.println("Output");
        System.out.println(min_transformation);
    }

}
