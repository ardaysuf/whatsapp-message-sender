package com.aspose.whatsapp;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import okhttp3.*;
public class Whatsapp extends JFrame{
    
    public static void WhatsappMessageSender(String phoneNumber,String message){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("token", "your token")  
                .add("to", phoneNumber)
                .add("body", message)
                .build();
        Request request = new Request.Builder()
                .url("https://api.ultramsg.com/yourInstanceID/messages/chat")//type your instance ID 
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        try{
            Response response=client.newCall(request).execute();
            System.out.println(response.body().string());
        }
        catch(IOException e){
        }
    }
    
    public Whatsapp(){
        setTitle("Whatsapp Message Sender");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel jp = new JPanel();
        jp.setLayout(new GridBagLayout());
        
        JTextField jtf=new JTextField(20);
        
        JButton jb = new JButton("Send");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jtf_text=jtf.getText();
                WhatsappMessageSender("+phoneNumber", jtf_text);//type the phone number you want to text to
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jp.add(jtf, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        jp.add(jb, gbc);
        
        add(jp);

        setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        Whatsapp wp=new Whatsapp();
        
    }
}
