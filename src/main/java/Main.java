import Model.CronParameters;

public class Main {
    public static void main(String[] args){
        if(args.length != 1) {
            System.out.println("Incorrect number of arguments!. Arguements Found: " + args.length);
            return;
        }

        try {
            CronParameters cronParameters = new CronParameters(args[0]);
            System.out.println(cronParameters);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
