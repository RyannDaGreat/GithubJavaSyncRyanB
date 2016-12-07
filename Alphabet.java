import java.io.IOException;
/**
 * The alphabet class is a class that holds 1 lower-case letter per instance.
 * @author Ryan Burgert
 */
public class Alphabet implements Hashable
{
    private Character letter;
    /**
     * The alphabet class is a class that holds lower-case letters
     * @throws IOException if the input character  is not a lower-case letter of the english alphabet.
     */
    Alphabet(char letter) throws IOException
    {
        if(letter<'a'||letter>'z')
            throw new IOException(letter+" is not a lower-case letter of the english alphabet.");
        this.letter=letter;
    }
    /**
     * This lower-case-letter to positive-integer hash function is very simple.
     * 'a' maps to 0, 'b' maps to 1, 'c' maps to 2 ...etc... 'z' maps to 25.
     */
    @Override
    public int hash()
    {
        int output=letter-'a';
        assert output>=0;//One of the properties of the documentation of the 'Hashable' interface is that hash() cannot be negative.
        return output;
    }
    /**
     * Simply returns a string containing this Alphabet instance's letter.
     */
    public String toString()
    {
        return ""+letter;
    }
    public boolean equals(Object x)
    {
        return x instanceof Alphabet && ((Alphabet)x).hash()==hash();
    }




}
