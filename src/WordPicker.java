import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: wugege
 * @Date: 2019/11/9 16:19
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class WordPicker {


    /**
     * 分析文件信息
     */
    Word head = new Word(null,null,null);
    public Word read() throws IOException {

        FileReader f = new FileReader("C:/Users/Administrator/Desktop/LinkedList.txt");
        char[] c= new char[1];
        boolean fen  = false;

        String str = "";
        while (f.read(c)!=-1){
            
            if(separated(c)){//是否分隔符
               if(!fen){  //新单词拼接完毕
                   if(exist(str)){ //存在
                       str = "";
                   }else {//新建链表
                       //head = new Word();
                       head.next = new Word(str,1,head.next);
                      // head = head.next;
                       //list.add(str);
                       str = "";
                   }

                }else{//
                   fen = true;
               }
            }else{ //不是分隔符
                str+=String.valueOf(c);
                fen = false;
            }
        }


        return head;


    }

    private boolean exist(String str) {

      Word cur  = head.next;
       while(cur!=null){
           if(cur.value .equals(str) ){
               cur.num+=1;
               return true;
           }else{
               cur = cur.next;
           }
       }
       return false;
    }

    private boolean separated(char[] c) {
        /*if(String.valueOf(c).equals("\r")||String.valueOf(c).equals("\n")||String.valueOf(c).equals(" ")||String.valueOf(c).equals("(")||String.valueOf(c).equals(",")
                ||String.valueOf(c).equals(".")||String.valueOf(c).equals("\"")||String.valueOf(c).equals("'")||String.valueOf(c).equals(")")||Character.isDigit(c[0]))
    */
        String content="asd";
        String pattern="[a-zA-Z]";
        boolean isMatch= Pattern.matches(pattern,String.valueOf(c));

        if(!isMatch)
        {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
      WordPicker wordPicker = new WordPicker();
       Word node  = wordPicker.read();
       System.out.println(node);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:/Users/Administrator/Desktop/newList.txt");//创建文本文件
            int i=0;
            node = node.next;
            while(node!=null){//循环写入

                fileWriter.write(node.value+":"+node.num+"\r\n");//写入 \r\n换行
                node = node.next;
                i++;
            }
            fileWriter.write("共"+i+"条");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
