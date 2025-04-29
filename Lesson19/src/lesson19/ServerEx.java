package lesson19;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
    public static void main(String[] args) throws Exception{  //네트워크,스레드.io같은건 뜨는게 너무 많아서 exception
        ServerSocket server = null;

        server = new ServerSocket(9999);  //9999포트를 만드는거
        while(true) {
            System.out.println("클라이언트 접속 대기");
            Socket client = server.accept();  //accept-기다린다. 지금 서버대기상태. 클라이언트 요청 있을 때 accept
            System.out.println("스레드 생성");
            HttpThread ht = new HttpThread(client);
            ht.start();  //클라이언트에 대한건 멀티로 처리
        }
    }
}

class HttpThread extends Thread {
    private Socket client;
    BufferedReader br;
    PrintWriter pw;
    public HttpThread(Socket client) {
        this.client = client;
        try {
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));  //한줄단위가 편해서 buffer 
            pw = new PrintWriter(client.getOutputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        BufferedReader fbr = null;
        try {
            String line = br.readLine();  //요청자가 가지고 있었던 헤더 정보를 ..
            System.out.println("Http Header :: " + line);

            // 요청 헤더 전체 읽기
            while (!(line = br.readLine()).equals("")) {
                System.out.println("Http Header :: " + line);
            }

            String fileName = "index.html";

            fbr = new BufferedReader(new FileReader(fileName));
            pw.println("HTTP/1.0 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");  //text/plain으로 적으면 평문으로 나옴.문자로
            pw.println();
            String fileLine;
            while ((fileLine = fbr.readLine()) != null) {
                pw.println(fileLine);
            }
            pw.flush();
            fbr.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
                if (client != null) client.close();
            } catch (Exception ignore) {}
        }
    }
}
