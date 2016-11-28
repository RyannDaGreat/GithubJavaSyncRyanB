import java.io.IOException;
public class TestClass
{
    public static void main(String... args) throws  ClassNotFoundException, InstantiationException, IOException, IllegalAccessException
    {
        System.out.println(System.getProperty("user.home") + "/Desktop");
        System.out.println("WOOT WOOT WOOT WOOT Now for an auto-update test....SUCCESS!!!...If you're reading this from a terminal, then we're up and running.");
    }
}
