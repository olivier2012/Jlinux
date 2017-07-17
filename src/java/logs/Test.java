package logs;

public class Test
{
public static void main (String args[]) throws Exception
{ 
Test o = new Test ();
System.out.println (o.content ()); 
} 
public String content () throws Exception
{ 
throw new Exception ("This is an exception on this.content ()"); 
}
private static class B 
{ 
public String content ()
{ 
return "B"; 
}
} 
private static class A extends B
{ 
public String content ()
{ 
return "A"; 
}
}
}