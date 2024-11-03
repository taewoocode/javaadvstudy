package thread.cas.increasement;

public class Teacher {
    private int h;

    public void hello() {
        System.out.println( "hello" );
    }

    public int add(int a, int b) {// 3 + 5
        return a + b; // -> 8
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        int result = teacher.add( 3, 5 ); //8 -> result
        System.out.println(result + 8); //? 16
        int add = teacher.add( 8, 8 ); //16

    }
}

