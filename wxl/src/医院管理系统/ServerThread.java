package ҽԺ����ϵͳ;

import java.io.BufferedReader;
import java.io.*;
import java.net.Socket;
public class kehuyuyuemain{
	static int num=1;//�ͻ��˼���
	public static void main(String[] arges){
		
	Account account=new Account(" "," ",6);//�͸�������һ��flag
	
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
			client=serverSocket.accept();//ʹ��accept()�����ȴ��ͻ�����������ʱ����һ��Socketd����
		}catch (Exception e){
			System.out.println("��������ʧ�ܣ�");
			System.exit(-1);
		}
		ServerThread st=new ServerThread(client);
		Thread t=new Thread(st);
		t.start();//�����ͻ����󣬾ݿͻ��������������̲߳�����
		try{
			serverSocket.close();
		}catch(IOException e) {
			System.out.println("�ر�ʧ�ܣ�);
		}
		num++;//���ӿͻ�
	}
	}
}

public class ServerThread implements Runnable{
	private Socket client;
	public ServerThread(Socket client)
	{
		this.client=client;//��ʼ��client����
	}

public void run(){//�߳�����
	try{
	BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
	//���׽Ӷ���õ���������������һ����Ӧ��BufferedReader����
	PrintWriter os=new PrintWriter(client.getOutputStream());
	//���׽Ӷ���õ������
	BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
	//�ɱ�׼�����豸����һ���������
	System.out.println(""+is.readLine());//��ʾ�ͻ���������ַ���
	String inputString=sin.readLine();//�ӱ�׼����õ�һ���ַ���
	
	while(inputString!=null&&inputString.trim().equals("quit"))
		{
		os.println(inputString);//��ͻ���������ַ���
	    os.flush();//ˢ���������ʹ��client�����յ����ַ���
	    System.out.println("server������inputString");
	    System.out.println("client������is.readline");
	    inputString=sin.readLine();//������õ�һ���ַ��� ����ѭ��
}
	
os.close();//�ر�Scoket�����
is.close();//�ر�Socket������
client.close();//�ر��׽���
System.out.println("�ͻ��˷������Ͽ�����");

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
			
			lb1=new JLabel("Ŀǰ�޲��˲���");  
		
		    j1.add(lb1);
		    frm.setBounds(600, 100, 300, 250);//���ó����С
			  frm.setVisible(true);//��ʾ
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
