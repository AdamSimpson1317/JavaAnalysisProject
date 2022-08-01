import java.util.List;

public class Analysis {
    public static long total(List<String> result) {
        long total = 0;
        for(int i =0; i < result.size(); i++){
            total = total + Integer.parseInt(result.get(i));
        }

        return total;
    }
    public static double averageCase(long total, int sizeOfList) {
        double average;
        average = total/sizeOfList;
        return average;
    }

    public static long bestCase(List<String> result) {
        int best = 99999999;
        for(int i =0; i < result.size(); i++) {
            if (Integer.parseInt(result.get(i)) < best) {
                best = Integer.parseInt(result.get(i));
            }
        }
        return best;
    }

    public static long worseCase(List<String> result){
        int worse = 0;
        for(int i =0; i < result.size(); i++){
            if (Integer.parseInt(result.get(i)) > worse){
                worse = Integer.parseInt(result.get(i));
            }

        }

        return worse;
    }


}
