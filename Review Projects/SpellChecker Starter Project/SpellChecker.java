import java.util.*;

/**
 * Write a description of class SpellChecker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpellChecker
{
    private ArrayList<String> words;
    private DictReader reader;

    /**
     * Constructor for objects of class SpellChecker
     */
    public SpellChecker()
    {
        reader = new DictReader("words.txt");
        words = reader.getDictionary();
    }

    public int numberOfWords()
    {
        int count = 0;
        for (int i = 0; i < words.size(); i++)
        {
            count++;
        }
        return count;
    }

    public boolean isKnownWord(String word)
    {
        for (int i = 0; i < words.size(); i++)
        {
            word = word.toLowerCase();
            if (words.get(i).equals(word))
            {
                return true;
            }
        }
        return false;
    }

    public boolean allKnown(ArrayList<String> list)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (isKnownWord(list.get(i)) == true)
            {
                return true;
            } 
        }
        return false;
    }

    public boolean isPalindrome(String word)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).equals(word))
            {
                word = word.toLowerCase(); //parse inputs into a standard format
                String rev = new StringBuilder(word).reverse().toString();
                if (word.equals(rev))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    public ArrayList<String> anagrams(String word)
    {
        ArrayList<String> wordsThatMatch = new ArrayList<String>();
        word = word.toLowerCase();
        for (int i = 0; i < words.size(); i++)
        {
            if (word == words.get(i))
            {
                wordsThatMatch.add(word);
            }
        }
        return wordsThatMatch;
    }

    public void insert(String word)
    {
        for (int i = 0; i < words.size(); i++)
        {
            word = word.toLowerCase();
            if (word.compareTo(words.get(i)) == 0)
            {
                break;
            }
            if (word.compareTo(words.get(i)) > 0)
            {
                words.add(i, word);
                break;
            }
        }
    }

    public ArrayList<String> wordsStartingWith(String pre)
    {
        ArrayList<String> datWords = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).length() >= pre.length() && words.get(i).substring(0, pre.length()).equals(pre))
            {
                datWords.add(words.get(i));
            }
        }
        return datWords;
    }

    public ArrayList<String> wordsContaining(String part)
    {
        ArrayList<String> datWords = new ArrayList<String>();
        int x = 0;
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).length() >= part.length() && words.get(i).substring(0, part.length()).equals(part))
            {
                datWords.add(words.get(i));
            }
            if (words.get(i).length() >= part.length() && words.get(i).substring(x, part.length()).equals(part))
            {
                datWords.add(words.get(i));
            }
            x++;
        }
        return datWords;
    }

    public boolean remove(String word)
    {
        for (int i = 0; i < words.size(); i++)
        {
            word = word.toLowerCase();
            if (word.equals(words.get(i)))
            {
                words.remove(words.get(i));
                return true;
            }
        }
        return false;
    }

    /*#
     *  INSERT METHODS!
     */

    /**
     * This method is done for you
     * saves updated dictionary text file
     */
    public void save()
    {
        reader.save(words);
    }

}
                                