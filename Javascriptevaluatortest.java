import javax.script.*;
/**
 * Created by Ryan on 11/28/16.
 */
public class Javascriptevaluatortest
{
    public static void main(String[] args) throws ScriptException
    {
        ScriptEngine js=new ScriptEngineManager().getEngineByName("javascript");
        Bindings bindings=js.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("stdout",System.out);
        js.eval("stdout.println(Math.cos(Math.PI));");
        // Prints "-1.0" to the standard output stream.
        Integer i=2;
        r.println(r.fansi(""+i,r.fansi_colors.yellow));
        bindings.put("i",i);
        js.eval("stdout.println(i);");
        js.eval("i=8;");
        js.eval("stdout.println(i);");
        bindings.put("i",i);





        js.eval("p=stdout.println;");
        js.eval("p(i)");

        r.println(r.fansi(""+i,r.fansi_colors.magenta));
    }
}