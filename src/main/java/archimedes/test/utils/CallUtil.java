package archimedes.test.utils;

public final class CallUtil {

    private CallUtil(){
        throw new IllegalStateException();
    }

    public static boolean isOperator(String number, String prefix){
        int start = Integer.parseInt(prefix);
        int end = start + 999;
        int op = Integer.parseInt(number.substring(3, 7));
        return op >= start && op <=end;
    }

}
