package codewars;

public class A {

    public static void main(String[] args) {

        System.out.println(backWards(2, 100));
    }

    public static String backWards(long primeiroN, long segundoN) {
        String backWards = "";

        for (long i = primeiroN; i <= segundoN; i++) {
            if (primo(i) && primo(primoRevertido(i)) && i != primoRevertido(i)) {
                backWards = backWards + i + " ";
            }
        }
        return backWards;
    }

    public static boolean primo(long numero) {
        if (numero > 2 && numero % 2 == 0) {
            return false;
        }
        int max = (int) Math.sqrt(numero) + 1;
        for (int i = 3; i < max; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return  true;
    }

    public static long primoRevertido(long numero) {
        String temp = "";
        while (numero > 0) {
            temp += numero % 10;
            numero /= 10;
        }
        return Long.parseLong(temp);
    }
}




