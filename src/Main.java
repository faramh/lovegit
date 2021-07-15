import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class voter{
    ArrayList<Integer> choice;
    final int maxVote=5;
    public voter(int cId) {
        choice = new ArrayList<Integer>();
        choice.add(cId);
    }
    public boolean voting(int cId){
        if(choice.contains(cId))
            return false;
        if(choice.size() == maxVote)
            return false;
        choice.add(cId);
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        final int endTime = 30*60*100;

        Matcher vm,matcher ;
        String pass;
        String Id;
        int requests;
        int i;
        int time;
        int cId;
        boolean error;
        String address;
        final int passedTime=10;
        int[] votes = new int[11];
        final String voteStr = "(\\d+)\\s(\\d+\\.\\d+\\.\\d+\\.\\d+)\\svote\\?id=(\\d+)&candidate=(\\d+)";
        final String tallystr = "(\\d+)\\s(\\d+\\.\\d+\\.\\d+\\.\\d+)\\stally\\?id=(\\d+)&password=([^&]+)&candidate=(\\d+)";
        Pattern vp = Pattern.compile(voteStr);
        Pattern tallyPattern = Pattern.compile(tallystr);
      
        
        HashMap<String, Integer> Timela = new HashMap<String, Integer>();
        HashMap<String, voter> voters = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String request;
        requests = Integer.parseInt(sc.nextLine());
        for (i = 0; i <= requests-1; i++){
            request = sc.nextLine();
            vm = vp.matcher(request);
            matcher = tallyPattern.matcher(request);
            if(vm.matches()){
                int a = Integer.parseInt(vm.group(4));
                cId=a;
                String b = vm.group(3);
                Id=b;
                String c = vm.group(2);
                address=c;

                int t = Integer.parseInt(vm.group(1));
                time =t;
                for (int j = 0; j < requests; j++) {
                    
                }
     
                if(endTime<time ){
                    System.out.println("403");
                    continue;
                }
                if(Timela.containsKey(address))
                    if(Timela.get(address)+passedTime <= time)
                        Timela.replace(address,time);
                    else {
                        Timela.replace(address,time);
                        System.out.println("403");
                        continue;
                    }
                else
                    Timela.put(address,time);
                if(cId>10 && cId < 1){
                    System.out.println("403");
                    continue;
                }
                if(voters.containsKey(Id)){
                    if(!voters.get(Id).voting(cId)){
                        System.out.println("403");
                        continue;
                    }
                }
                else
                    voters.put(Id,new voter(cId));
                votes[cId]++;
                System.out.println("200");
            }
            else if(matcher.matches()){
                int a = Integer.parseInt(matcher.group(1));
                time =a;
                String ad = matcher.group(2);
                address=ad;

                String I = matcher.group(3);
                Id=I;

                String p = matcher.group(4);
                pass=p;
                int ci = Integer.parseInt(matcher.group(5));
                cId=ci;
                for (int j = 0; j < 10; j++) {

                }
                if(time > endTime){
                    System.out.println("403");
                    continue;
                }
                if(Timela.containsKey(address))
                    if(Timela.get(address)+passedTime <= time)
                        Timela.replace(address,time);
                    else {
                        Timela.replace(address,time);
                        System.out.println("403");
                        continue;
                    }
                else
                    Timela.put(address,time);
                if((!Id.equals("4984760") ||
                        !pass.equals("#abc123M") )&&(!Id.equals("7589175")
                        || !pass.equals("46812sQ$") )){
                    System.out.println("403");
                    continue;
                }
                if(cId>10 && cId < 1){
                    System.out.println("403");
                    continue;
                }
                System.out.print("200 ");
                System.out.println(votes[cId]);
            }

        }
    }
}
