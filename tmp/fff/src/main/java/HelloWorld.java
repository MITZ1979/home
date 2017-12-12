import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello world");


        List<String> names = new ArrayList<>();
        names.add("aaa");
        names.add("bbb");
        names.add("ccc");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

    }

}

