package Usst;

public class Test {

}
/*
 * 对象序列化包括如下步骤：

　　1） 创建一个对象输出流，它可以包装一个其他类型的目标输出流，如文件输出流；

　　2） 通过对象输出流的writeObject()方法写对象。

　　对象反序列化的步骤如下：

　　1） 创建一个对象输入流，它可以包装一个其他类型的源输入流，如文件输入流；

　　2） 通过对象输入流的readObject()方法读取对象。

*/

/*
ObjectOutputStream objectOut=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.bin")));
Customer cus=new Customer("wang","0001","pddd",3000);
objectOut.writeObject(cus);
objectOut.close();

ObjectInputStream objectIn=new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.bin")));
cus=(Customer)objectIn.readObject();
System.out.println("Name:"+cus.getName());
System.out.println("ID:"+cus.getID());
System.out.println("Password:"+cus.getPassword());
System.out.println("Salary:"+cus.getSalary());
}
catch (NotSerializableException e)
{
System.out.println(e.getMessage());
}
catch(ClassNotFoundException e)
{
   System.out.println(e.getMessage());
}
catch(IOException e)
{
   System.out.println(e.getMessage());
}
}
}

class Customer implements Serializable
{
private String name,ID;
transient private String password;
private float salary;

public Customer(String name,String ID,String password,float salary)
{
this.name=name;
this.ID=ID;
this.password=password;
this.salary=salary;
}

public String getName()
{
return name;
}

public String getID()
{
return ID;
}

public String getPassword()
{
return password;
}

public float getSalary()
{
return salary;
}
*/

