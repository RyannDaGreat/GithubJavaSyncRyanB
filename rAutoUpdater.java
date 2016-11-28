import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
@SuppressWarnings({"WeakerAccess","Duplicates"})
public class rAutoUpdater
{
    //region Gears
    static
    {
//        //System.out.println("hellooooooo?");
    }
    //region  [getPath, makeDirectory, deleteDirectory, fullPathNamesOfDirectoryContents]
    //region getPath
    public static String getPath()
    {
//        String path=java.nio.file.Paths.get("").toAbsolutePath().toString()+"";//Example path at this point:"/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards"
//        class ⵁ
//        {
//        }//A dummy class, just so that we can get the file path of it
//        String packageExtension=""+ⵁ.class.getPackage();
//        if(packageExtension.equals("null"))//If this class is not in a package
//        {
//            return path;
//        }
//        assert packageExtension.substring(0,8).equals("package ");//Example packageExtension at this point: "package CSE114_Old_Labs.HW"
//        packageExtension=packageExtension.substring(8);//"package CSE114_Old_Labs.HW"⟶"CSE114_Old_Labs.HW"
//        packageExtension=packageExtension.replaceAll("\\.","/");//"CSE114_Old_Labs.HW"⟶"CSE114_Old_Labs/HW" This will happen if we're in a package within a package
//        path=path+"/"+packageExtension;
////        return path;
//
//        //System.out.println(System.getProperty("user.home") + "/Desktop");
        return        System.getProperty("user.home") + "/Desktop";//The desktop path. i changed my mind.

    }
    //endregion
    //region makeDirectory
    public static boolean makeDirectory(String pathToFolder,String folderName)
    {
        return new java.io.File(pathToFolder+"/"+folderName).mkdir();
    }
    public static boolean makeDirectory(String folderName)
    {
        //Do not include the path of the folder you want to make, just give me its name!
        return makeDirectory(getPath(),folderName);
    }
    //endregion
    //region deleteDirectory
    private static void deleteDirectory(java.io.File file)
    {
        //Clears the folder of any files it may contains, then deletes the folder.
        java.io.File[] contents=file.listFiles();
        if(contents!=null)
        {
            for(java.io.File f : contents)
            {
                deleteDirectory(f);
            }
        }
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }
    //Disabled the following method because it looked dangerous.
    /*public static void deleteDirectory(String absolutePathIncludingFolderName)
    {
        assert absolutePathIncludingFolderName.startsWith(getPath())&&absolutePathIncludingFolderName.length()>getPath().length():"If this assertion fails, then your code might be really dangerous! Attempted to delete: "+absolutePathIncludingFolderName;
        deleteDirectory(new java.io.File(absolutePathIncludingFolderName));
    }*/
    //Nerfed the above commented method and created another one that only lets you delete local directories:
    public static void deleteDirectory(String folderNameWithoutPath)
    {
        //Do not include the path of the folder, just give me its name!
        deleteDirectory(new java.io.File(getPath()+"/"+folderNameWithoutPath));
    }
    //endregion
    //region fullPathNamesOfDirectoryContents
    private static String[] fullPathNamesOfDirectoryContents(java.io.File file)
    {
        //Returns the names of all files in the directory
        String out="";//Every file name will be split by '\n'.
        java.io.File[] contents=file.listFiles();
        if(contents!=null)
        {
            for(java.io.File f : contents)
            {
                //System.out.println(f);
                //NOTE: f.getAbsolutePath() ≣ f.toString() ≣ ""+f
                out+="\n"+f;//Note: The fact that "\n" comes first is important for the "out=out.substring(1);" line
            }
        }
        if(!out.equals(""))
        {
            out=out.substring(1);
        }
        return out.split("[\n]");
    }
    public static String[] fullPathNamesOfDirectoryContents(String folderNameWithoutPath)
    {
        //Do not include the path of the folder, just give me its name!
        return fullPathNamesOfDirectoryContents(new java.io.File(getPath()+"/"+folderNameWithoutPath));
    }
    //endregion
    //region fileNamesOfDirectoryContentsWithoutPaths
    private static String[] fileNamesOfDirectoryContentsWithoutPaths(java.io.File file)
    {
        //Returns the names of all files in the directory
        String out="";//Every file name will be split by '\n'.
        java.io.File[] contents=file.listFiles();
        if(contents!=null)
        {
            for(java.io.File f : contents)
            //NOTE: f.getAbsolutePath() ≣ f.toString() ≣ ""+f
            {
                out+="\n"+f.getName();//Note: The fact that "\n" comes first is important for the "out=out.substring(1);" line
            }
        }
        if(!out.equals(""))
        {
            out=out.substring(1);
        }
        return out.split("[\n]");
    }
    public static String[] fileNamesOfDirectoryContentsWithoutPaths(String folderNameWithoutPath)
    {
        //Do not include the path of the folder, just give me its name!
        return fileNamesOfDirectoryContentsWithoutPaths(new java.io.File(getPath()+"/"+folderNameWithoutPath));
    }
    public static String ReadFile(String FilePathName) throws java.io.FileNotFoundException
    {
        java.util.Scanner Input=new java.util.Scanner(new java.io.File(FilePathName));
        if(!Input.hasNextLine())
        {
            return "";
        }
        String Output=Input.nextLine();
        while(Input.hasNextLine())
        {
            Output+="\n"+Input.nextLine();
        }
        Input.close();
        return Output;
    }
    //endregion
    //endregion

    public static String randomLetters(int length)
    {
        String out="";
        for(int i=0;i<length;i++)
            out+=(char)('A'+r.randomInt(24)+1);
        return out;
    }
    @SuppressWarnings("unused")
    public static String getCodeAsAStringFromAFileFromAGithubRepository(String GitProjectURL,String FileName)
    {

        String temporaryFolderName="0000tEsTFoooolder_ima_dissapear_myself_soon";
        try
        {
            deleteDirectory(temporaryFolderName);
//            //r.delay(1);
        }

        catch(Exception ignored)
        {
        }
        //System.out.println("cd = \""+getPath()+"/"+"\"");
        makeDirectory(temporaryFolderName);
//        //r.delay(1);
        try
        {
            Runtime.getRuntime().exec(new String[]{"git","clone",GitProjectURL,getPath()+"/"+temporaryFolderName}).waitFor();
        }
        catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
//        //r.delay(20);
//        //r.delay(1);
        String output="getCodeAsAStringFromAFileFromAGithubRepository: (If This is the Result, then the code failed to retrieve the file you requested) GitProjectURL="+GitProjectURL+"  AND   FileName="+FileName;
        int i=0;
        for(String x : fileNamesOfDirectoryContentsWithoutPaths(temporaryFolderName))
        {
            //System.out.println(fileNamesOfDirectoryContentsWithoutPaths(temporaryFolderName).length);
            if(x.equals(FileName))
            {
                try
                {
                    output=ReadFile(fullPathNamesOfDirectoryContents(temporaryFolderName)[i]);
                    //System.out.println("HALLALOOYAH! WE GOT IT!");
                    //r.say("yay! hazaah! we got it! holy crap! this took fucking forever!");
                }
                catch(Exception ignored)
                {
                    ignored.printStackTrace();
                    output="Sadness";
                    //System.out.println("getCodeAsAStringFromAFileFromAGithubRepository: SUPER-DUPER SAD ERROR: We found the file you were looking for, but we couldn't read it!");
                }
            }
            i++;
        }
        deleteDirectory(temporaryFolderName);
//        //r.delay(1);
        return output;
    }

    public static Class<?> compileAndRunJavaCodeFromAbsoluteFilePath(String srcFolderPath,String javaFileNameWithoutExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException
    {
/*//        //System.out.println(MethodHandles.lookup().lookupClass().getCanonicalName());
// Prepare source somehow.
//        String source = "package test; public class Test { static { //System.out.println(java.lang.invoke.MethodHandles.lookup().lookupClass().getCanonicalName());//System.out.println(\"hello\"); } public Test() { //System.out.println(\"world\"); } }";
// User Settings:

// Save source in .java file.
        File root=new File(srcFolderPath); // On Windows running on C:\, this is C:\java.
//        sourceFile.getParentFile().mkdirs();
            //System.out.println(root);
            //System.out.println(javaFileNameWithExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath);
            File sourceFile=new File(root,javaFileNameWithExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath);
            sourceFile.getParentFile().mkdirs();

//        Files.write(sourceFile.toPath(),source.getBytes(StandardCharsets.UTF_8));
            //System.out.println(sourceFile);
            //System.out.println(ReadFile(sourceFile.getAbsoluteFile().toString()));
// Compile source file.
            JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
            compiler.run(null,null,null,sourceFile.getPath());

// Load and instantiate compiled class.
            URLClassLoader classLoader=URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            Class<?> cls=Class.forName(javaFileNameWithExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath,true,classLoader); // Should print "hello".
    Object instance=cls.newInstance(); // Should print "world".
    //System.out.println(instance); // Should print "test.Test@hashcode"*/
// Prepare source somehow.
//        String source = "public class Test " +
//            " { static" +
//            " {" +
//            "//System.out.println(\"hello\");" +
//            " } " +
//            " public Test() { //System.out.println(\"world\"); }  " +
//            "}";
// User Settings:
//        String temporaryPackageName="test";//Both of these names HAVE TO match the names found in 'source'! If they don't you'll get an orange compiler error.
        // Save source in .java file.
        File root=new File(srcFolderPath); // On Windows running on C:\, this is C:\java.
//        File sourceFile = new File(root, /*temporaryPackageName+"/"+*/temporaryJavaClassName+".java");
        File sourceFile=new File(root, /*temporaryPackageName+"/"+*/javaFileNameWithoutExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath+".java");
//        sourceFile.getParentFile().mkdirs();
//        Files.write(sourceFile.toPath(),source.getBytes(StandardCharsets.UTF_8));
//        //System.out.println(ReadFile(sourceFile.getAbsoluteFile().toString()));


// Compile source file.
        //r.say("Compiling Files");//Compile all .java files in the folder. NOTE THAT WILL NOT YET WORK WITH PACKAGES!!! THere can be no nesting.

        int n=0;
        String[]allFiles=fullPathNamesOfDirectoryContents(root);
        for(String x:allFiles)
            if(x.endsWith(".java"))
                n++;
        String[]out=new String[n];//A list of file paths of all .java files so that the compiler compiles all of them at the same time
        n=0;
        for(String x:allFiles)
            if(x.endsWith(".java"))
                out[n++]=x;

        ToolProvider.getSystemJavaCompiler().run(null,null,null,out);//This is the part that might take a few seconds...
//        //r.delay(1);
//        //r.say("Compilation complete.");

// Load and instantiate compiled class.
        URLClassLoader classLoader=URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});

//        //r.delay(1);
        //r.say("Running");
        Class<?> cls;
//        while(true)
//        {
//            try
//            {
        cls=Class.forName(/*temporaryPackageName+"."+*/javaFileNameWithoutExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath,true,classLoader); // Invokes the static initialization block. Should print "hello".
//                break;
//            }
//            catch(Exception ignored){}
//        }
//        Object instance=cls.newInstance(); // Should print "world".
//        //System.out.println(instance); // Should print "test.Test@hashcode".
        return cls;
    }
    //
    public static void WriteFile(String FilePathName,String Contents) throws java.io.IOException
    {
        java.io.PrintWriter Writer=new java.io.PrintWriter(FilePathName);
        Writer.print(Contents);
        Writer.close();
    }
    public static void compileAndRunJavaCodeFromGithubRepository(String GitProjectURL,String MainJavaClassFileNameWithoutExtension) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InterruptedException
    {
        String temporaryFolderName="TemporaryFolder_"+randomLetters(20);//To avoid collisions if multiple instances of java are running at once. Better make sure that you don't stop this program in the middle of running, or else it will leave that folder on your desktop!
//        try
//        {
//            deleteDirectory(temporaryFolderName);
//            //r.say("Deleting...");
////            //r.delay(1);
//        }
//
//        catch(Exception ignored)
//        {
//        }
//        //System.out.println("cd = \""+getPath()+"/"+"\"");
        Runtime.getRuntime().exec(new String[]{"git","clone",GitProjectURL,getPath()+"/"+temporaryFolderName}).waitFor();
        //System.out.println("git clone "+ GitProjectURL+" "+getPath()+"/"+temporaryFolderName);
        //r.say("Cloning...");
        makeDirectory(temporaryFolderName);
//        //r.delay(1);
        //r.say("Writing");
        String TemporaryClassName="TemporaryClass_"+randomLetters(20);
        String DesiredCode="public class "+TemporaryClassName+"{static{"+MainJavaClassFileNameWithoutExtension+".main();}}";
        String TempClassFullPath=getPath()+"/"+temporaryFolderName+"/"+TemporaryClassName+".java";
        WriteFile(TempClassFullPath,DesiredCode);//We're going to create a dummy class here. This class will simply call the main method of the class we want to start from via a static initialization block.
        //System.out.println(getPath()+"/"+temporaryFolderName+"/TEMPORARYCLASS.java");
        //System.out.println(getPath());



//        while(true)
//        {
//            try{
//            if(ReadFile(TempClassFullPath).equals(DesiredCode))
//                break;}
//            catch(Exception ignored){}
//        }

//        //System.out.println();

        //Now we have a temporary git repository

        compileAndRunJavaCodeFromAbsoluteFilePath(getPath()+"/"+temporaryFolderName,TemporaryClassName);

//        //r.delay(1);
//        WriteFile(getPath()+"/"+temporaryFolderName+"/TEMPORARYCLASS.java","");//We're going to create a dummy class here. This class will simply call the main method of the class we want to start from via a static initialization block.
        //r.say("Deleting temp folder");

        deleteDirectory(temporaryFolderName);//We don't wanna clog our hard drives, now do we?
//        //r.delay(1.5);
        //r.say("Auto update complete.");

    }


    /*public static void main(String[] args) throws IOException, InterruptedException
    {
        String temporaryFolderName="0000TestCompilerDirectory_ima_dissapear_myself_soon";
        try{deleteDirectory(temporaryFolderName);}catch(Exception ignored){}//Delete the old version of this folder if it allready exists for some reason, probably because it was cut-out in the middle of the code.
        //System.out.println("cd = \""+getPath()+"/"+"\"");
        makeDirectory(temporaryFolderName);
        String temporaryAbsoluteFolderPath=getPath()+"/"+temporaryFolderName;
        //r.delay(1);


        String theCodeWeWant=getCodeAsAStringFromAFileFromAGithubRepository("https://github.com/RyannDaGreat/GithubJavaSyncRyanB","TestClass.java");

        //System.out.println(getCodeAsAStringFromAFileFromAGithubRepository("https://github.com/RyannDaGreat/GithubJavaSyncRyanB","TestClass.java"));
    }*/

    //endregion
    public static void main(String[] args) throws IOException, InterruptedException, IllegalAccessException, InstantiationException, ClassNotFoundException
    {
        compileAndRunJavaCodeFromGithubRepository("https://github.com/RyannDaGreat/GithubJavaSyncRyanB","TestClass");
    }
}