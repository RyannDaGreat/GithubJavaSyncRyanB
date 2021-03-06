//import java.awt.*;
//import java.math.BigDecimal;
//import java.util.*;
///**
// * Created by Ryan B on 2/7/16.
// * <p>
// * This is a class that can be easily extended, or copied and pasted into, any other class.
// * It contains many shorthand notations for otherwise annoyingly verbose methods, and offers
// * additional functionality such as complex mathematical operations and inverse hyperbolic trig.
// */
////region UML (May be outdated)
////    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
////    ┃ r                                                                     ┃
////    ┠───────────────────────────────────────────────────────────────────────┨
////    ┃ - Complex : class                                                     ┃
////    ┃ - DEG_PER_RAD : double                                                ┃
////    ┃ - DEG_TO_RAD : double                                                 ┃
////    ┃ - E : double                                                          ┃
////    ┃ - PI : double                                                         ┃
////    ┃ - RAD_PER_DEG : double                                                ┃
////    ┃ - RAD_TO_DEG : double                                                 ┃
////    ┃ - TWO_PI : double                                                     ┃
////    ┠┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┨
////    ┃ + abs(x:Complex) : double                                             ┃
////    ┃ + abs(x:double) : double                                              ┃
////    ┃ + acos(x:double) : double                                             ┃
////    ┃ + acosh(x:double) : double                                            ┃
////    ┃ + acot(x:double) : double                                             ┃
////    ┃ + acoth(x:double) : double                                            ┃
////    ┃ + acsc(x:double) : double                                             ┃
////    ┃ + acsch(x:double) : double                                            ┃
////    ┃ + add(a:double, b:double, x:double, y:double) : Complex               ┃
////    ┃ + add(X:Complex, Y:Complex) : Complex                                 ┃
////    ┃ + angleOf(x:double, y:double) : double                                ┃
////    ┃ + arg(x:Complex) : double                                             ┃
////    ┃ + asec(x:double) : double                                             ┃
////    ┃ + asech(x:double) : double                                            ┃
////    ┃ + asin(x:double) : double                                             ┃
////    ┃ + asinh(x:double) : double                                            ┃
////    ┃ + atan(x:double) : double                                             ┃
////    ┃ + atanh(x:double) : double                                            ┃
////    ┃ + avg() : double                                                      ┃
////    ┃ + avg() : double                                                      ┃
////    ┃ + Boolean(x:int) : boolean                                            ┃
////    ┃ + booleanScan() : boolean                                             ┃
////    ┃ + ceil(x:double) : long                                               ┃
////    ┃ + chance(Probability:double) : boolean                                ┃
////    ┃ + complex(real:double, imag:double) : Complex                         ┃
////    ┃ + cos(x:double) : double                                              ┃
////    ┃ + cosh(x:double) : double                                             ┃
////    ┃ + cot(x:double) : double                                              ┃
////    ┃ + coth(x:double) : double                                             ┃
////    ┃ + csc(x:double) : double                                              ┃
////    ┃ + csch(x:double) : double                                             ┃
////    ┃ + delay(delayDurationInSeconds:double) : void                         ┃
////    ┃ + delayInMillis(delayDurationInMilliseconds:long) : void              ┃
////    ┃ + distance(X:double, Y:double, x:double, y:double) : double           ┃
////    ┃ + div(a:double, b:double, x:double, y:double) : Complex               ┃
////    ┃ + div(X:Complex, Y:Complex) : Complex                                 ┃
////    ┃ + Double(Input:String) : double                                       ┃
////    ┃ + doubleArray() : double[]                                            ┃
////    ┃ + doubleScan() : double                                               ┃
////    ┃ + exp(a:double, b:double) : Complex                                   ┃
////    ┃ + exp(X:Complex) : Complex                                            ┃
////    ┃ + exp(x:double) : double                                              ┃
////    ┃ + factorial(x:long) : long                                            ┃
////    ┃ + floatScan() : float                                                 ┃
////    ┃ + floor(x:double) : long                                              ┃
////    ┃ + im(imag:double) : Complex                                           ┃
////    ┃ + im(x:Complex) : double                                              ┃
////    ┃ + imag(imag:double) : Complex                                         ┃
////    ┃ + imag(x:Complex) : double                                            ┃
////    ┃ + Int(Input:String) : double                                          ┃
////    ┃ + Int(x:boolean) : int                                                ┃
////    ┃ + intScan() : int                                                     ┃
////    ┃ + ln(a:double, b:double) : Complex                                    ┃
////    ┃ + ln(X:Complex) : Complex                                             ┃
////    ┃ + ln(x:double) : double                                               ┃
////    ┃ + log(Base:Complex, X:Complex) : Complex                              ┃
////    ┃ + log(Base_a:double, Base_b:double, X_x:double, X_y:double) : Complex ┃
////    ┃ + Long(Input:String) : double                                         ┃
////    ┃ + longScan() : long                                                   ┃
////    ┃ + mag(x:double, y:double) : double                                    ┃
////    ┃ + max(x:double, y:double) : double                                    ┃
////    ┃ + millis() : long                                                     ┃
////    ┃ + min(x:double, y:double) : double                                    ┃
////    ┃ + mouseX() : int                                                      ┃
////    ┃ + mouseY() : int                                                      ┃
////    ┃ + mult(a:double, b:double, x:double, y:double) : Complex              ┃
////    ┃ + mult(X:Complex, Y:Complex) : Complex                                ┃
////    ┃ + OpenWebsite(URL:String) : void                                      ┃
////    ┃ + pow(a:double, b:double, x:double, y:double) : Complex               ┃
////    ┃ + pow(X:Complex, Y:Complex) : Complex                                 ┃
////    ┃ + print(message:BigDecimal) : void                                    ┃
////    ┃ + print(message:boolean) : void                                       ┃
////    ┃ + print(message:char) : void                                          ┃
////    ┃ + print(message:double) : void                                        ┃
////    ┃ + print(message:long) : void                                          ┃
////    ┃ + print(message:String) : void                                        ┃
////    ┃ + println() : void                                                    ┃
////    ┃ + println(message:BigDecimal) : void                                  ┃
////    ┃ + println(message:boolean) : void                                     ┃
////    ┃ + println(message:char) : void                                        ┃
////    ┃ + println(message:double) : void                                      ┃
////    ┃ + println(message:long) : void                                        ┃
////    ┃ + println(message:String) : void                                      ┃
////    ┃ + random(x:double) : double                                           ┃
////    ┃ + randomInt(x:double) : int                                           ┃
////    ┃ + re(real:double) : Complex                                           ┃
////    ┃ + re(x:Complex) : double                                              ┃
////    ┃ + ReadFile(FilePathNamethrows:String) : String                        ┃
////    ┃ + real(real:double) : Complex                                         ┃
////    ┃ + real(x:Complex) : double                                            ┃
////    ┃ + round(x:double) : long                                              ┃
////    ┃ + scan() : String                                                     ┃
////    ┃ + scan(Message:String) : String                                       ┃
////    ┃ + sec(x:double) : double                                              ┃
////    ┃ + sech(x:double) : double                                             ┃
////    ┃ + seconds() : double                                                  ┃
////    ┃ + sign(x:double) : double                                             ┃
////    ┃ + sign(x:float) : float                                               ┃
////    ┃ + sin(x:double) : double                                              ┃
////    ┃ + sinh(x:double) : double                                             ┃
////    ┃ + sqrt(X:Complex) : Complex                                           ┃
////    ┃ + sqrt(x:double) : double                                             ┃
////    ┃ + stdDev_population() : double                                        ┃
////    ┃ + stdDev_population() : double                                        ┃
////    ┃ + stdDev_population_ofMean() : double                                 ┃
////    ┃ + stdDev_population_ofMean() : double                                 ┃
////    ┃ + StringDialog() : String                                             ┃
////    ┃ + StringDialog(message:String) : String                               ┃
////    ┃ + StringFromClipboard() : String                                      ┃
////    ┃ + StringScan() : String                                               ┃
////    ┃ + StringToClipboard(myStringToCopy:Object) : void                     ┃
////    ┃ + sub(a:double, b:double, x:double, y:double) : Complex               ┃
////    ┃ + sub(X:Complex, Y:Complex) : Complex                                 ┃
////    ┃ + sum() : double                                                      ┃
////    ┃ + sum() : int                                                         ┃
////    ┃ + tan(x:double) : double                                              ┃
////    ┃ + tanh(x:double) : double                                             ┃
////    ┃ + WriteFile(FilePathName:String, Contentsthrows:String) : void        ┃
////    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
////endregion
//
//@SuppressWarnings({"WeakerAccess","unused","Duplicates","SuspiciousNameCombination"})
//public class r
//{
//    //region Console Outputs: print() and println() methods:
//    public static void println()
//    {
//        System.out.print("\n");
//    }
//    public static void println(String message)
//    {
//        System.out.println(message);
//    }
//    public static void print(String message)
//    {
//        System.out.print(message);
//    }
//    public static void print(char message)
//    {
//        System.out.print(message);
//    }
//    public static void println(char message)
//    {
//        System.out.println(message);
//    }
//    public static void println(long message)
//    {
//        System.out.println(""+message);
//    }
//    public static void print(long message)
//    {
//        System.out.print(""+message);
//    }
//    public static void println(double message)
//    {
//        System.out.println(""+message);
//    }
//    public static void print(double message)
//    {
//        System.out.print(""+message);
//    }
//    public static void println(boolean message)
//    {
//        System.out.println(""+message);
//    }
//    public static void print(boolean message)
//    {
//        System.out.print(""+message);
//    }
//
//    //Special: Can be expanded as I learn new classes
//    public static void println(BigDecimal message)
//    {
//        System.out.println(message.toPlainString());
//    }
//    public static void print(BigDecimal message)
//    {
//        System.out.print(message.toPlainString());
//    }
//    public static void print(Object... message)
//    {
//        print(Arrays.toString(message));
//    }
//    public static void println(Object... message)
//    {
//        print(message);
//        println();
//    }
//    //END FOLD
//    //endregion
//    //region Console Inputs: {int,long,float,double,boolean,String}Scan() methods:
//    public static int intScan()
//    {
//        return new Scanner(System.in).nextInt();
//    }
//    public static long longScan()
//    {
//        return new Scanner(System.in).nextLong();
//    }
//    public static float floatScan()
//    {
//        return new Scanner(System.in).nextFloat();
//    }
//    public static double doubleScan()
//    {
//        return new Scanner(System.in).nextDouble();
//    }
//    public static boolean booleanScan()
//    {
//        return new Scanner(System.in).nextBoolean();
//    }
//    public static String StringScan()
//    {
//        return new Scanner(System.in).nextLine();
//    }
//    public static String scan()
//    {
//        return new Scanner(System.in).nextLine();
//    }
//    public static String scan(String Message)
//    {
//        print(Message);
//        return new Scanner(System.in).nextLine();
//    }
//    public static String StringDialog(String message)
//    {
//        return javax.swing.JOptionPane.showInputDialog(message);
//    }
//    public static String StringDialog()
//    {
//        return javax.swing.JOptionPane.showInputDialog("");
//    }
//    //endregion END FOLD
//    //region Timing Methods: millis(), seconds(), delay(time), tic(),toc(),toc:
//    public static long millis()
//    {
//        return System.currentTimeMillis();
//    }
//    public static double seconds()
//    {
//        return System.currentTimeMillis()/1000d;
//    }
//    public static void delayInMillis(long delayDurationInMilliseconds)
//    {
//        //region Old version that always kills my laptop's battery!
////        long startTime=System.currentTimeMillis();
////        //noinspection StatementWithEmptyBody
////        while(System.currentTimeMillis()-delayDurationInMilliseconds-startTime<0);
//        //endregion
//        try
//        {
//            Thread.sleep(delayDurationInMilliseconds);
//        }
//        catch(Exception ignored)
//        {
//        }
//    }
//    public static void delay(double delayDurationInSeconds)
//    {
//        //region Old version that always kills my laptop's battery!
////        long startTime=System.currentTimeMillis();
////        //noinspection StatementWithEmptyBody
////        while(System.currentTimeMillis()-delayDurationInSeconds*1000-startTime<0);
//        //endregion
//        try
//        {
//            Thread.sleep((long)(delayDurationInSeconds*1000));
//        }
//        catch(Exception ignored)
//        {
//        }
//    }
//    //region Tic and Toc
//    private static double toc_start=seconds();
//    public static void tic()
//    {
//        toc_start=seconds();
//    }
//    public static double toc()
//    {
//        return toc_start-seconds();
//    }
//    public static double ptoc()
//    {
//        double out=toc();
//        System.out.println("r.toc() ﹦ "+out);
//        return out;
//    }
//    //endregion
//    //END FOLD
//    //endregion
//    //region Array Math:
//    public static int[] range(int Start_Inclusive,int Finish_Exclusive)
//    {
//        //Works for both forward-sequences, like 12345, and reverse-sequences like 98765.
//        //Also works for negative numbers like -1,-2,-3 etc (in both directions of course)
//        reverse(new Integer[]{1,2});
//        //Generates an integer range like in Python or Matlab
//        if(Start_Inclusive<Finish_Exclusive)
//        {
//            return java.util.stream.IntStream.range(Start_Inclusive,Finish_Exclusive).toArray();
//        }
//        else if(Start_Inclusive>Finish_Exclusive)
//        {
//            return toint(reverse(toInteger(range(Finish_Exclusive+1,Start_Inclusive+1))));
//        }
//        // ∴ else ⋂ Start_Inclusive == Finish_Exclusive ∴ (output is empty int[] array)
//        return new int[0];
//    }
//    public static int[] rangeClosed(int Start_Inclusive,int Finish_Exclusive)
//    {
//        //Works for both forward-sequences, like 12345, and reverse-sequences like 98765.
//        //Also works for negative numbers like -1,-2,-3 etc (in both directions of course)
//        reverse(new Integer[]{1,2});
//        //Generates an integer range like in Python or Matlab
//        if(Start_Inclusive<Finish_Exclusive)
//        {
//            return java.util.stream.IntStream.rangeClosed(Start_Inclusive,Finish_Exclusive).toArray();
//        }
//        else if(Start_Inclusive>Finish_Exclusive)
//        {
//            return toint(reverse(toInteger(rangeClosed(Finish_Exclusive,Start_Inclusive))));
//        }
//        // ∴ else ⋂ Start_Inclusive == Finish_Exclusive ∴ (output is empty int[] array)
//        return new int[]{Start_Inclusive};//====return new int[]{Finish_Inclusive};
//    }
//    public static Integer[] toInteger(int[] x)
//    {
//        //Converts an int[] array to an Integer[] array
//        Integer[] out=new Integer[x.length];
//        int i=0;
//        for(int y : x)
//        {
//            out[i++]=y;
//        }
//        return out;
//    }
//    public static int[] toint(Integer[] x)
//    {
//        //Converts an Integer[] array to an int[] array
//        int[] out=new int[x.length];
//        int i=0;
//        for(Integer y : x)
//        {
//            out[i++]=y;
//        }
//        return out;
//    }
//    public static <T> T[] reverse(T[] array)
//    {
//        //Using generics to reverse an array without the need for casting
//        T[] copy=array.clone();
//        Collections.reverse(Arrays.asList(copy));
//        return copy;
//    }
//    public static double[] doubleArray(int... x)
//    {
//        double[] out=new double[x.length];
//        for(int i=0;i<x.length;i++)
//        {
//            out[i]=x[i];
//        }
//        return out;
//    }
//    @SafeVarargs
//    public static <T>T randomElement(T...array)
//    {
//        return array[randomIndex(array.length)];
//    }
//    //endregion
//    //region All Real-Number Double Mathematics:
//    //Math Constants:
//    public static final double PI=3.1415926535897932384626433832795028841971693993751058209749;
//    public static final double E=2.7182818284590452353602875;
//    public static final double TWO_PI=2*PI;
//    public static final double RAD_TO_DEG=360/TWO_PI;
//    public static final double DEG_TO_RAD=TWO_PI/360;
//    public static final double RAD_PER_DEG=RAD_TO_DEG;//<- Reworded just for clarification
//    public static final double DEG_PER_RAD=DEG_TO_RAD;//<- Reworded just for clarification
//    //END FOLD
//    //Standard Misc Math:
//    public static double sum(double... x)
//    {
//        double out=0;
//        for(double y : x)
//        {
//            out+=y;
//        }
//        return out;
//    }
//    public static int sum(int... x)
//    {
//        int out=0;
//        for(int y : x)
//        {
//            out+=y;
//        }
//        return out;
//    }
//    public static double avg(double... x)
//    {
//        return sum(x)/x.length;
//    }
//    public static double avg(int... x)
//    {
//        return avg(doubleArray(x));
//    }
//    public static double stdDev_population(double... x)
//    {
//        double avg=avg(x);
//        for(int i=0;i<x.length;i++)
//        {
//            x[i]-=avg;
//            x[i]*=x[i];
//        }
//        return sqrt(sum(x)/(x.length));
//    }
//    public static double stdDev_population(int... x)
//    {
//        return stdDev_population(doubleArray(x));
//    }
//    public static double stdDev_population_ofMean(double... x)
//    {
//        return stdDev_population(x)/sqrt(x.length);
//    }
//    public static double stdDev_population_ofMean(int... x)
//    {
//        return stdDev_population(x)/sqrt(x.length);
//    }
//    public static double sign(double x)
//    {
//        return java.lang.Math.signum(x);
//    }
//    public static float sign(float x)
//    {
//        return java.lang.Math.signum(x);
//    }
//    public static double abs(double x)
//    {
//        return java.lang.Math.abs(x);
//    }
//    public static double max(double x,double y)
//    {
//        return java.lang.Math.max(x,y);
//    }
//    public static double min(double x,double y)
//    {
//        return java.lang.Math.min(x,y);
//    }
//    public static long round(double x)
//    {
//        return java.lang.Math.round(x);
//    }
//    public static long ceil(double x)
//    {
//        return (long)java.lang.Math.ceil(x);
//    }
//    public static long floor(double x)
//    {
//        return (long)java.lang.Math.floor(x);
//    }
//    public static double mag(double x,double y)
//    {
//        return java.lang.Math.hypot(x,y);
//    }
//    public static double sqrt(double x)
//    {
//        return java.lang.Math.sqrt(x);
//    }
//    public static double random(double x)
//    {
//        return java.lang.Math.random()*x;
//    }
//    public static int randomInt(double x)
//    {
//        return (int)(java.lang.Math.random()*x);
//    }
//    public static int randomIndex(int length)
//    {
//        return (int)floor(random(length));
//    }
//    public static boolean chance(double Probability)
//    {
//        //0<Probability<1
//        return random(1)<Probability;
//    }
//    public static long factorial(long x)
//    {
//        if(x<0)
//        {
//            //Cannot take the factorial of a negative integer! Exit the script and return an error message on the console...
//            println("ERROR: long factorial(long x) : x="+x+" and x<0 : Cannot take the factorial of a negative integer!");
//            System.exit(0);
//        }
//        int y=1;
//        for(int i=1;i<=x;i++)
//        {
//            y*=i;
//        }
//        return y;
//    }
//    //END FOLD
//    //Specialized Math Methods:
//    public static double angleOf(double x,double y)
//    {
//        //double AngleOf: Returns the angle between the x-axis and a 2D coordinate in radians. Accepts any coordinate pair except (0,0).
//        //Note: This function can be optimized by using arctan() instead of arcsin() and arccos(). I'm too lazy to bother with that today.
//        double Magnitude=sqrt(x*x+y*y);
//        x/=Magnitude;
//        y/=Magnitude;
//
//        if(y>0)
//        {
//            return acos(x);
//        }
//        else if(y<0)
//        {
//            return TWO_PI-acos(x);
//        }
//        else //if(y==0) <-- Implied
//        {
//            if(x>0)
//            {
//                return 0;
//            }
//            else if(x<0)
//            {
//                return PI;
//            }
//            else //if(x==0)
//            {
//                //Note: The name of this function is mentioned in the following error readout, so if "AngleOf" changes to something else change the error message too!
//                println("Error: the point (0,0) does not have an angle! Returning 0... [double AngleOf(float x,float y)]");
//                return 0;
//            }
//        }
//    }
//    public static double distance(double X,double Y,double x,double y)
//    {
//        X-=x;
//        Y-=y;
//        return sqrt(X*X+Y*Y);
//    }
//    //END FOLD
//    //double exp(x) and ln(x):
//    public static double exp(double x)
//    {
//        return java.lang.Math.exp(x);
//    }
//    public static double ln(double x)
//    {
//        return java.lang.Math.log(x);
//    }
//    //END FOLD
//    //double Trig Functions:
//    public static double sin(double x)
//    {
//        return java.lang.Math.sin(x);
//    }
//    public static double cos(double x)
//    {
//        return java.lang.Math.cos(x);
//    }
//    public static double tan(double x)
//    {
//        return java.lang.Math.tan(x);
//    }
//    public static double asin(double x)
//    {
//        return java.lang.Math.asin(x);
//    }
//    public static double acos(double x)
//    {
//        return java.lang.Math.acos(x);
//    }
//    public static double atan(double x)
//    {
//        return java.lang.Math.atan(x);
//    }
//    //Trig Reciprocals:
//    public static double csc(double x)
//    {
//        return 1.0d/java.lang.Math.sin(x);
//    }
//    public static double sec(double x)
//    {
//        return 1.0d/java.lang.Math.cos(x);
//    }
//    public static double cot(double x)
//    {
//        return 1.0d/java.lang.Math.tan(x);
//    }
//    public static double acsc(double x)
//    {
//        return java.lang.Math.asin(1.0d/x);
//    }
//    public static double asec(double x)
//    {
//        return java.lang.Math.acos(1.0d/x);
//    }
//    public static double acot(double x)
//    {
//        return java.lang.Math.atan(1.0d/x);
//    }
//    //END FOLD
//    //double Hyperbolic Trig Functions:
//    public static double sinh(double x)
//    {
//        return java.lang.Math.sinh(x);
//    }
//    public static double cosh(double x)
//    {
//        return java.lang.Math.cosh(x);
//    }
//    public static double tanh(double x)
//    {
//        return java.lang.Math.tanh(x);
//    }
//    public static double asinh(double x)
//    {
//        return ln(x+sqrt(x*x+1));
//    }
//    public static double acosh(double x)
//    {
//        return ln(x+sqrt(x*x-1));
//    }
//    public static double atanh(double x)
//    {
//        return .5d*ln((1+x)/(1-x));
//    }
//    //Reciprocal Hyperbolic Trig Functions:
//    public static double csch(double x)
//    {
//        return 1.0d/java.lang.Math.sinh(x);
//    }
//    public static double sech(double x)
//    {
//        return 1.0d/java.lang.Math.cosh(x);
//    }
//    public static double coth(double x)
//    {
//        return 1.0d/java.lang.Math.tanh(x);
//    }
//    public static double acsch(double x)
//    {
//        return asinh(1.0d/x);
//    }
//    public static double asech(double x)
//    {
//        return acosh(1.0d/x);
//    }
//    public static double acoth(double x)
//    {
//        return atanh(1.0d/x);
//    }
//    //END FOLD
//    //endregion
//    //region String Conversions:
//    public static double Double(String Input)
//    {
//        return (new BigDecimal(Input)).doubleValue();
//    }
//    public static double Long(String Input)
//    {
//        return (new BigDecimal(Input)).longValue();
//    }
//    public static double Int(String Input)
//    {
//        return (new BigDecimal(Input)).intValue();
//    }
//    //endregionß
//    //region Ryan's Complex Double Math Methods:
//    public class Complex
//    {
//        public double real, imag;
//        Complex(double RealIn,double ImaginaryIn)
//        {
//            real=RealIn;
//            imag=ImaginaryIn;
//        }
//        double re()
//        {
//            return real;
//        }
//        double real()
//        {
//            return real;
//        }
//        double im()
//        {
//            return imag;
//        }
//        double imag()
//        {
//            return imag;
//        }
//        double abs()
//        {
//            return imag*imag+real*real;
//        }
//        double arg()
//        {
//            return r.angleOf(real,imag);
//        }
//        //Non-Math Methods:
//        void PrintLn()
//        {
//            r.print(real);
//            if(imag>=0)
//            {
//                r.print(" + ");
//                r.print(imag);
//            }
//            else
//            {
//                r.print(" - ");
//                r.print(""+(-imag));
//            }
//            r.println("i");
//        }
//    }
//    double re(Complex x)
//    {
//        return x.re();
//    }
//    double real(Complex x)
//    {
//        return x.re();
//    }
//    double im(Complex x)
//    {
//        return x.im();
//    }
//    double imag(Complex x)
//    {
//        return x.im();
//    }
//    double abs(Complex x)
//    {
//        return x.abs();
//    }
//    double arg(Complex x)
//    {
//        return x.arg();
//    }
//    Complex complex(double real,double imag)//The lower-case "complex" is so we can write equations in single lines, rather than having to declare "blah.... = new Complex()" each time we want to perform a complex arithmetic operation.
//    {
//        return new Complex(real,imag);
//    }
//    Complex real(double real)//Returns a real number in the form of the Complex class, that has an imaginary component of zero and a real component of "real".
//    {
//        return new Complex(real,0);
//    }
//    Complex re(double real)//Returns a real number in the form of the Complex class, that has an imaginary component of zero and a real component of "real".
//    {
//        return new Complex(real,0);
//    }
//    Complex imag(double imag)//Returns a purely imaginary number in the form of the Complex class, that has an imaginary component of "imag" and a real component of 0.
//    {
//        return new Complex(0,imag);
//    }
//    Complex im(double imag)//Returns a purely imaginary number in the form of the Complex class, that has an imaginary component of "imag" and a real component of 0.
//    {
//        return new Complex(0,imag);
//    }
//    //Bivariate Complex Functions:
//    Complex mult(Complex X,Complex Y)
//    {
//        double a=X.re();
//        double b=X.im();
//        double x=Y.re();
//        double y=Y.im();
//        return new Complex(a*x-b*y,a*y+b*x);
//    }
//    Complex mult(double a,double b,double x,double y)
//    {
//        //Returns a Complex number, (a+bi)*(x+yi), where a, b, x and y are all real numbers.
//        return new Complex(a*x-b*y,a*y+b*x);
//    }
//    Complex div(Complex X,Complex Y)
//    {
//        double a=X.re();
//        double b=X.im();
//        double x=Y.re();
//        double y=Y.im();
//        double imagOut=(b*x-a*y)/(x*x+y*y);
//        double realOut=(a*x+b*y)/(x*x+y*y);
//        return new Complex(realOut,imagOut);
//    }
//    Complex div(double a,double b,double x,double y)
//    {
//        //Returns a Complex number, (a+bi)/(x+yi), where a, b, x and y are all real numbers.
//        double imagOut=(b*x-a*y)/(x*x+y*y);
//        double realOut=(a*x+b*y)/(x*x+y*y);
//        return new Complex(realOut,imagOut);
//    }
//    Complex add(Complex X,Complex Y)
//    {
//        double a=X.re();
//        double b=X.im();
//        double x=Y.re();
//        double y=Y.im();
//        return new Complex(a+x,b+y);
//    }
//    Complex add(double a,double b,double x,double y)
//    {
//        //Returns a Complex number, (a+bi)+(x+yi), where a, b, x and y are all real numbers.
//        return new Complex(a+x,b+y);
//    }
//    Complex sub(Complex X,Complex Y)
//    {
//        double a=X.re();
//        double b=X.im();
//        double x=Y.re();
//        double y=Y.im();
//        return new Complex(a-x,b-y);
//    }
//    Complex sub(double a,double b,double x,double y)
//    {
//        //Returns a Complex number, (a+bi)-(x+yi), where a, b, x and y are all real numbers.
//        return new Complex(a-x,b-y);
//    }
//    //Univariate Complex Functions:
//    Complex exp(Complex X)
//    {
//        double a=X.re();
//        double b=X.im();
//        double realOut=exp(a)*cos(b);
//        double imagOut=exp(a)*sin(b);
//        return new Complex(realOut,imagOut);
//    }
//    Complex exp(double a,double b)
//    {
//        //Returns a Complex number, exp(a+bi), where a and b are both real numbers.
//        double realOut=exp(a)*cos(b);
//        double imagOut=exp(a)*sin(b);
//        return new Complex(realOut,imagOut);
//    }
//    Complex ln(Complex X)
//    {
//        double a=X.re();
//        double b=X.im();
//        double realOut=.5*ln(a*a+b*b);
//        double imagOut=X.arg();
//        return new Complex(realOut,imagOut);
//    }
//    Complex ln(double a,double b)
//    {
//        //Returns a Complex number, ln(a+bi), where a and b are both real numbers.
//        double realOut=.5*ln(a*a+b*b);
//        double imagOut=angleOf(a,b);
//        return new Complex(realOut,imagOut);
//    }
//    //Higher-order complex functions...
//    Complex pow(Complex X,Complex Y)
//    {
//        //Returns a Complex number, X^Y, where X and Y can both be complex numbers.
//        return exp(mult(Y,ln(X)));
//    }
//    Complex pow(double a,double b,double x,double y)
//    {
//        //Returns a Complex number, (a+bi)^(x+yi), where a, b, x and y are all real numbers.
//        return exp(mult(complex(x,y),ln(complex(a,b))));
//    }
//    Complex log(Complex Base,Complex X)//!!!Warning: Syntax order is arbitrary!!! Pay attention: It's log_(Base) of X.
//    {
//        //Returns a Complex number, the log of X in base Base, where X and Y can both be complex numbers.
//        return div(ln(X),ln(Base));
//    }
//    Complex log(double Base_a,double Base_b,double X_x,double X_y)//!!!Warning: Syntax order is arbitrary!!! Pay attention: It's log_(Base) of X.
//    {
//        //Returns a Complex number, the log of X in base Base, where X and Y can both be complex numbers. X and Y are constructed from the four input-doubles.
//        return log(complex(Base_a,Base_b),complex(X_x,X_y));
//    }
//    Complex sqrt(Complex X)
//    {
//        //Returns a Complex number, sqrt(X), where X is a Complex number.
//        return pow(X,re(.5));
//    }
//    boolean Boolean(int x)
//    {
//        return x>=1;
//    }
//    int Int(boolean x)
//    {
//        if(x)
//        {
//            return 1;
//        }
//        return 0;
//    }
//    //END FOLD
//    //endregion
//    //region Mouse Information:
//    public static int mouseX()
//    {
//        return MouseInfo.getPointerInfo().getLocation().x;
//    }
//    public static int mouseY()
//    {
//        return MouseInfo.getPointerInfo().getLocation().y;
//    }
//    //END FOLD
//    //endregion
//    //region Clipboard:
//    public static void StringToClipboard(Object myStringToCopy)
//    {
//        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(myStringToCopy.toString()),null);
//    }
//    public static String StringFromClipboard()
//    {
//        try
//        {
//            return (String)java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(java.awt.datatransfer.DataFlavor.stringFlavor);
//        }
//        catch(Exception a)
//        {
//            System.out.println("I honestly don't give a crap about catching this exception but it makes me put one here anyway.");
//            return "ERROR4622888886666666666";
//        }
//    }
//    //endregion
//    //region Web:
//    public static void OpenWebsite(String URL)
//    {
//        try
//        {
//            java.awt.Desktop.getDesktop().browse(new java.net.URI(URL));
//        }
//        catch(Exception x)
//        {
//            println("ERROR: Exception thrown: r.OpenWebsite("+URL+"); : "+x.getMessage()+" : "+x.toString());
//        }
//    }
//    //endregion
//    //region Read/Write from/to Text Files:
//    public static String ReadFile(String FilePathName) throws java.io.FileNotFoundException
//    {
//        java.util.Scanner Input=new java.util.Scanner(new java.io.File(FilePathName));
//        if(!Input.hasNextLine())
//        {
//            return "";
//        }
//        String Output=Input.nextLine();
//        while(Input.hasNextLine())
//        {
//            Output+="\n"+Input.nextLine();
//        }
//        Input.close();
//        return Output;
//    }
//    public static void WriteFile(String FilePathName,String Contents) throws java.io.IOException
//    {
//        java.io.PrintWriter Writer=new java.io.PrintWriter(FilePathName);
//        Writer.print(Contents);
//        Writer.close();
//    }
//    public static String ReadFileIgnoreExceptions(String FilePathName)
//    {
//        try
//        {
//            ReadFile(FilePathName);
//        }
//        catch(Exception ignored){}
//        return null;
//    }
//    public static void WriteFileIgnoreExceptions(String FilePathName,String Contents)
//    {
//        try
//        {
//            WriteFile(FilePathName,Contents);
//        }
//        catch(Exception ignored){}
//    }
//    //endregion
//    //region Screen Width/Height (In Pixels) (AKA The resolution):
//    public static final int screenWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//    public static final int screenHeight=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//
//    public static int ScreenWidth()
//    {
//        //NOTE: In order to get the maximum pixel in a dimension, you must subtract 1 from this!
//        //(When trying to detect if mouse is in corner of screen for example)
//        return screenWidth;
//    }
//    public static int ScreenHeight()
//    {
//        //NOTE: In order to get the maximum pixel in a dimension, you must subtract 1 from this!
//        //(When trying to detect if mouse is in corner of screen for example)
//        return screenHeight;
//    }
//    //endregion
//    //region Audio: Text to Speech (only on Macs)
//    public enum voices
//    {
//        //Used for the 'say' method. All possible voices on the MacOsx say command.
//        Samantha,Bad,Bahh,Bells,Boing,Bubbles,Cellos,Deranged,Good,Hysterical,Pipe,Trinoids,Whisper,Zarvox,Agnes,Kathy,Princess,Vicki,Victoria,Alex,Bruce,Fred,Junior,Ralph,Albert
//    }
//    public static void say(String message,voices voice)
//    {
//        //I've only tested this method on my Mac. I don't think it will work on windows as it relies on the Mac's terminal-based text-to-speech.
//        //It will invoke a text-to-speech method on the Mac's bash (or terminal or shell idk what to call it).
//        attemptShellCommandIgnoreExceptions("say -v "+voice+" "+message);
//    }
//    public static void say(String message)
//    {
//        voices defaultVoice=voices.Samantha;//This can be changed based on how I feel today.
//        say(message,defaultVoice);
//    }
//    //endregion
//    //region fansi (Colorful console text via ANSI stuff)
//    public enum fansi_colors
//    {
//        black(0),red(1),green(2),yellow(3),blue(4),magenta(5),cyan(6),gray(7);
//        private final int id;
//        fansi_colors(int id) { this.id = id; }
//        public int getValue() { return id; }
//    }
//    public enum fansi_styles
//    {
//        bold(1),faded(2),underlined(4),blinking(5),outlined(7);
//        private final int id;
//        fansi_styles(int id) { this.id = id; }
//        public int getValue() { return id; }
//    }
//    public static String fansi(String s,r.fansi_colors textColor,r.fansi_styles textStyle,r.fansi_colors background_color)
//    {
//        return "\033["+textStyle.getValue()+";"+(30+textColor.getValue())+";"+(40+background_color.getValue())+"m"+s+"\033[0m";//The order of textStyle.getValue(),textColor.getValue(),background_color.getValue()
//    }
//    public static String fansi(String s,r.fansi_colors textColor,r.fansi_styles textStyle)
//    {
//        return "\033["+textStyle.getValue()+";"+(30+textColor.getValue())+"m"+s+"\033[0m";//The order of textStyle.getValue(),textColor.getValue(),background_color.getValue()
//    }
//    public static String fansi(String s,r.fansi_colors textColor)
//    {
//        return "\033["+(30+textColor.getValue())+"m"+s+"\033[0m";//The order of textStyle.getValue(),textColor.getValue(),background_color.getValue()
//    }
//    //endregion
//    public static void attemptShellCommandIgnoreExceptions(String command)
//    {
//        try
//        {
//            Runtime.getRuntime().exec(command);
//        }
//        catch(Exception ignored){}
//    }
//}
