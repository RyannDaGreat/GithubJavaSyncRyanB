import java.io.IOException;
public class TestClass
{
    public static void main(String... args) throws  ClassNotFoundException, InstantiationException, IOException, IllegalAccessException
    {
        System.out.println(System.getProperty("user.home") + "/Desktop");
        r.say("WOOT WOOT WOOT WOOT Now for an auto-update test....SUCCESS!!!...If you're reading this from a terminal, then we're up and running.");
        System.out.println("WOOT WOOT WOOT WOOT Now for an auto-update test....SUCCESS!!!...If you're reading this from a terminal, then we're up and running.");
        String out=r.scan("Enter a string in the console: ");
        for(int i=0;i<out.length();i++)
        {
            System.out.println(out.substring(i));
        }
        try
        {
            HUHUHUrAutoUpdaterRefactorated.main("".split("."));
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
