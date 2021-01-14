public class hello {
    public static void main(String[] args) {
        int a=8;
        int b=2;
        double c=4;
        int result1=a+b;
        double result2=a-c;
        double result3=a*c;
        int result4=a/b;

        int sum=0;
        for(int i=0;i<a;i++){
            if(i%b==0){
                sum++;
            }
        }
        int result5=sum;
    }
}
