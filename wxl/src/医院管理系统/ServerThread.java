package 医院管理系统;

import java.io.BufferedReader;
import java.io.*;
import java.net.Socket;
public class kehuyuyuemain{
	static int num=1;//客户端计数
	public static void main(String[] arges){
		
	Account account=new Account(" "," ",6);//送给服务器一个flag
	
	ServerSocket serverSocket=null;
	Socket client=null;
	while(true)
	{
		try{
			serverSocket=new ServerSocket(4444);
		}catch (Exception e){
			System.out.println("Error:"+e);
			System.exit(-1);
		}
		try{
			client=serverSocket.accept();//使用accept()阻塞等待客户请求，请求到来时产生一个Socketd对象
		}catch (Exception e){
			System.out.println("接受请求失败！");
			System.exit(-1);
		}
		ServerThread st=new ServerThread(client);
		Thread t=new Thread(st);
		t.start();//监听客户请求，据客户计数创建服务线程并启动
		try{
			serverSocket.close();
		}catch(IOException e) {
			System.out.println("关闭失败！);
		}
		num++;//增加客户
	}
	}
}

public class ServerThread implements Runnable{
	private Socket client;
	public ServerThread(Socket client)
	{
		this.client=client;//初始化client变量
	}

public void run(){//线程主体
	try{
	BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
	//由套接对象得到输入流，并构造一个相应的BufferedReader对象
	PrintWriter os=new PrintWriter(client.getOutputStream());
	//由套接对象得到输出流
	BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
	//由标准输入设备构造一个输入对象
	System.out.println(""+is.readLine());//显示客户端输入的字符串
	String inputString=sin.readLine();//从标准输入得到一个字符串
	
	while(inputString!=null&&inputString.trim().equals("quit"))
		{
		os.println(inputString);//向客户端输出该字符串
	    os.flush();//刷新输出流，使得client马上收到该字符串
	    System.out.println("server发送了inputString");
	    System.out.println("client发送了is.readline");
	    inputString=sin.readLine();//从输入得到一个字符串 继续循环
}
	
os.close();//关闭Scoket输出流
is.close();//关闭Socket输入流
client.close();//关闭套接字
System.out.println("客户端服务器断开连接");

}catch(IOException e) {
	e.printStackTrace();
}
}
}
while(true){
	
	Socket server=null;
	try {
		server =new Socket("127.0.0",2303);
		
		ObjectInputStream in=new 
				ObjectInputStream(server.getInputStream());
		
     out =new ObjectOutputStream(server.getOutputStream());
	 acc.setFlag(3); 
     out.writeObject(acc);
     out.flush();
	    try {
			clist=(ArrayList<Case>) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} /*catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}*/
	if(clist==null){
		JFrame frm=new JFrame();
		   JLabel lb1;
		   JPanel j1;
		    
			j1=new JPanel();
			frm.getContentPane().add(j1, BorderLayout.NORTH);
			
			lb1=new JLabel("目前无病人病例");  
		
		    j1.add(lb1);
		    frm.setBounds(600, 100, 300, 250);//设置长宽大小
			  frm.setVisible(true);//显示
	}
	else{
	//clist1.add(cc);
	cc=new Case();
	cc.setPi(clist.get(i).getPi());

	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Treatment frame = new Treatment();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	

}}}
