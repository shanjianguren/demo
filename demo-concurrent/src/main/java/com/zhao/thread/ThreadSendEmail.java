package com.zhao.thread;

import com.zhao.thread.pool.BulletPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadSendEmail {

    public static ArrayList<Map> readCsv() {
        File csv = new File("D:\\logs/yeahbra1.csv"); // CSV文件路径
        csv.setReadable(true);//设置可读
        csv.setWritable(true);//设置可写
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        ArrayList<Map> allString = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                Map map = new HashMap();
                map.put("name", everyLine.split(",")[0]);
                map.put("email", everyLine.split(",")[1]);

                allString.add(map);
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allString;

    }

    public void sendEmail() {
        List<Map> list = readCsv();
        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
        for (Map map : list) {
            poolExecutor.execute(new Thread(new test(map.get("name").toString(), map.get("email").toString())));
        }
    }

    public class test implements Runnable {
        private String name;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public test(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+"name:----" + name + "    email:" + email);
        }
    }

    public static void main(String[] args) {
        new ThreadSendEmail().sendEmail();
    }
}
