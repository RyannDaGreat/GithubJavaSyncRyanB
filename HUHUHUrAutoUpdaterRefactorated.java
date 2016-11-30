import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
@SuppressWarnings({"WeakerAccess","Duplicates"})
public class HUHUHUrAutoUpdaterRefactorated
{

    public static String getPath()
    {
        return System.getProperty("user.home")+"/Desktop";//The desktop path. i changed my mind.

    }
    public static boolean makeDirectory(String pathToFolder,String folderName)
    {
        return new java.io.File(pathToFolder+"/"+folderName).mkdir();
    }
    private static void deleteDirectory(java.io.File file)
    {
        //Clears the folder of any files it may contains, then deletes the folder.
        java.io.File[] contents=file.listFiles();
        if(contents!=null)
            for(java.io.File f : contents)
                deleteDirectory(f);
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }
    public static void deleteDirectory(String folderNameWithoutPath)
    {
        //Do not include the path of the folder, just give me its name!
        deleteDirectory(new java.io.File(getPath()+"/"+folderNameWithoutPath));
    }
    private static String[] fullPathNamesOfDirectoryContents(java.io.File file)
    {
        //Returns the names of all files in the directory
        String out="";//Every file name will be split by '\n'.
        java.io.File[] contents=file.listFiles();
        if(contents!=null)
            for(java.io.File f : contents)
                out+="\n"+f;//NOTE: f.getAbsolutePath() ≣ f.toString() ≣ ""+f
        return out.split("[\n]");//expect to have an empty string at the end of the array
    }
    public static String randomLetters(int length)
    {
        String out="";
        for(int i=0;i<length;i++)
            out+=(char)('A'+((int)(Math.random()*24))+1);
        return out;
    }
    public static Class<?> compileAndRunJavaCodeFromAbsoluteFilePath(String srcFolderPath,String javaFileNameWithoutExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException
    {
        File root=new File(srcFolderPath); // On Windows running on C:\, this is C:\java.
        int n=0;
        String[] allFiles=fullPathNamesOfDirectoryContents(root);
        for(String x : allFiles)
            if(x.endsWith(".java"))
                n++;
        String[] out=new String[n];//A list of file paths of all .java files so that the compiler compiles all of them at the same time
        n=0;
        for(String x : allFiles)
            if(x.endsWith(".java"))
                out[n++]=x;
        ToolProvider.getSystemJavaCompiler().run(null,null,null,out);//This is the part that might take a few seconds...
        URLClassLoader classLoader=URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        return Class.forName(/*temporaryPackageName+"."+*/javaFileNameWithoutExtensionAndPackagePathSeparatedBySlashesInsteadOfPeriods_AllRelativeTo_srcFolderPath,true,classLoader); // Invokes the static initialization block. Should print "hello".;
    }
    public static void WriteFile(String FilePathName,String Contents) throws java.io.IOException
    {
        java.io.PrintWriter Writer=new java.io.PrintWriter(FilePathName);
        Writer.print(Contents);
        Writer.close();
    }
    public static void compileAndRunJavaCodeFromGithubRepository(String GitZipURL,String MainJavaClassFileNameWithoutExtension) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InterruptedException
    {
//        String temporaryFolderName="TemporaryFolder_"+randomLetters(20);//To avoid collisions if multiple instances of java are running at once. Better make sure that you don't stop this program in the middle of running, or else it will leave that folder on your desktop!
//        Runtime.getRuntime().exec(new String[]{"git","clone",GitProjectURL,getPath()+"/"+temporaryFolderName}).waitFor();
//        makeDirectory(getPath(),temporaryFolderName);
//        String TemporaryClassName="TemporaryClass_"+randomLetters(20);
//        String DesiredCode="public class "+TemporaryClassName+"{static{try{"+MainJavaClassFileNameWithoutExtension+".main();}catch(Exception e){e.printStackTrace();}}}";
//        String TempClassFullPath=getPath()+"/"+temporaryFolderName+"/"+TemporaryClassName+".java";
//        WriteFile(TempClassFullPath,DesiredCode);//We're going to create a dummy class here. This class will simply call the main method of the class we want to start from via a static initialization block.
//        compileAndRunJavaCodeFromAbsoluteFilePath(getPath()+"/"+temporaryFolderName,TemporaryClassName);
//        deleteDirectory(temporaryFolderName);//We don't wanna clog our hard drives, now do we?

//THE BELOW CODE NO LONGER RELIES ON HAVING GIT ON YOUR COMPUTER!

//        String MainJavaClassFileNameWithoutExtension="TestClass";
//        String GitZipURL="https://github.com/RyannDaGreat/GithubJavaSyncRyanB/archive/master.zip";
        String temporaryFolderName="TemporaryFolder_"+randomLetters(20);//To avoid collisions if multiple instances of java are running at once. Better make sure that you don't stop this program in the middle of running, or else it will leave that folder on your desktop!
        String absoluteDownloadDirectory=getPath()+"/"+temporaryFolderName+"/";//Must have a '/' at the end.
        makeDirectory(getPath(),temporaryFolderName);
        assert absoluteDownloadDirectory.endsWith("/");
        String downloadedFileName="TEMP_"+randomLetters(20)+".zip";
        saveUrl(absoluteDownloadDirectory+downloadedFileName,GitZipURL);
        String denchbunch=absoluteDownloadDirectory+unzip(absoluteDownloadDirectory+downloadedFileName,absoluteDownloadDirectory);

        String TemporaryClassName="TemporaryClass_"+randomLetters(20);
        String DesiredCode="public class "+TemporaryClassName+"{static{try{"+MainJavaClassFileNameWithoutExtension+".main();}catch(Exception e){e.printStackTrace();}}}";
        String TempClassFullPath=denchbunch+TemporaryClassName+".java";
        WriteFile(TempClassFullPath,DesiredCode);//We're going to create a dummy class here. This class will simply call the main method of the class we want to start from via a static initialization block.

        compileAndRunJavaCodeFromAbsoluteFilePath(denchbunch,TemporaryClassName);

        deleteDirectory(temporaryFolderName);//We don't wanna clog our hard drives, now do we?

    }
    public static void saveUrl(final String filename,final String urlString) throws IOException
    {
        BufferedInputStream in=null;
        FileOutputStream fout=null;
        try
        {
            in=new BufferedInputStream(new URL(urlString).openStream());
            fout=new FileOutputStream(filename);
            final byte data[]=new byte[1024];
            int count;
            while((count=in.read(data,0,1024))!=-1)
            {
                fout.write(data,0,count);
            }
        }
        finally
        {
            if(in!=null)
            {
                in.close();
            }
            if(fout!=null)
            {
                fout.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, IllegalAccessException, InstantiationException, ClassNotFoundException
    {
        compileAndRunJavaCodeFromGithubRepository("https://github.com/RyannDaGreat/GithubJavaSyncRyanB/archive/master.zip","TestClass");
    }
    //region unziptool from some website idr where but think was off stackexchange
    private static final int BUFFER_SIZE=4096;
    public static String unzip(String zipFilePath,String destDirectory) throws IOException
    {
        //Luckily this method is strong enough to overwrite any folder/file it previously created
        File destDir=new File(destDirectory);
        if(!destDir.exists())
            destDir.mkdir();
        ZipInputStream zipIn=new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry=zipIn.getNextEntry();
        try
        {
            return entry.toString();//Returns the name of the folder that will be created as a result. Example: "GithubJavaSyncRyanB-master/"
        }
        finally
        {
            // iterates over entries in the zip file
            while(entry!=null)
            {
                String filePath=destDirectory+File.separator+entry.getName();
                if(entry.isDirectory())
                    new File(filePath).mkdir();// if the entry is a directory, make the directory
                else
                    extractFile(zipIn,filePath); // if the entry is a file, extracts it
                zipIn.closeEntry();
                entry=zipIn.getNextEntry();
            }
            zipIn.close();
        }
    }
    private static void extractFile(ZipInputStream zipIn,String filePath) throws IOException
    {
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn=new byte[BUFFER_SIZE];
        int read;
        while((read=zipIn.read(bytesIn))!=-1)
            bos.write(bytesIn,0,read);
        bos.close();
    }
    //endregion
}