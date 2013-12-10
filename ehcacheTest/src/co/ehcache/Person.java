/*
 * Created on Jan 28, 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package co.ehcache;

import java.io.Serializable;

/**
 * @author lichun
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Person implements Serializable
{
    private String name;
    private int age;
    
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    /**
     * @return Returns the age.
     */
    public int getAge()
    {
        return age;
    }
    /**
     * @param age The age to set.
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    /**
     * @return Returns the name.
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        // TODO Auto-generated method stub
        return this.name + ":" + this.age;
    }
}
