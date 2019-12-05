
package demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        int a =100,b=50,c=a-- -b,d=a-- -b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
        r();
    }

    public static  void r(){
        Map<String, Integer> map = new HashMap<String, Integer>();

        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/opt/000001.txt")),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {//数据以逗号分隔
                String[] names = lineTxt.split(",");
                for (String name : names) {
                    if (map.keySet().contains(name)) {
                        map.put(name, (map.get(name)+1 ));
                    } else {
                        map.put(name,1);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }

        for (String a:map.keySet()
             ) {
            if(map.get(a)>1){
                System.out.println(a);
            }
        }
        System.out.println(map.toString());

//        /* 输出数据 */
//        try {
//              bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/value_map.txt")),
//                    "UTF-8"));
//
//            for (String name : map.keySet()) {
//                bw.write(name + " " + map.get(name));
//                bw.newLine();
//            }
//            bw.close();
//        } catch (Exception e) {
//            System.err.println("write errors :" + e);
//        }
    }
    }