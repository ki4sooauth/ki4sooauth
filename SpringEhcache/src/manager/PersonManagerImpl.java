package manager;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PersonManagerImpl
{
    private static List persons;

    static
    {
        persons = new ArrayList();

        persons.add("Wang");
        persons.add("zang");
        persons.add("Li");
        persons.add("song");
        persons.add("yan");
    }

    public List getList()
    {
        System.out.println("getPerons from DB");
        return persons;
    }

}
