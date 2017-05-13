package test;
//代码功能是显示本机可用的COM端口号可以对照设备管理器中端口COM 查看。

import java.util.ArrayList;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;  
  
public class Test4 {  
  
	 public static void main(String[] args) 
	    {
	        for(String tmp:findPort()){
	            System.out.println(tmp);
	        }
	        System.exit(0);
	    }
	    public static final ArrayList<String> findPort() {

	            @SuppressWarnings("unchecked")
	            Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();//获得所有串口

	            ArrayList<String> portNameList = new ArrayList<>();

	            //串口名字添加到List并返回    

	            while (portList.hasMoreElements()) {

	                String portName = portList.nextElement().getName();

	                portNameList.add(portName);

	            }

	            return portNameList;
	        }
}
