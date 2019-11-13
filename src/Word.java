/**
 * @Author: wugege
 * @Date: 2019/11/9 17:33
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public  class Word{
    public String value;
    public Integer num;
    public Word next;

    public Word(String value,Integer num,Word next){
        this.num = num;
        this.value = value;
        this.next = next;
    }
    public Word(String value){
        this.value = value;
        this.num=1;
        this.next = null;
    }
    public Word(){
        this.next = null;
        this.num = 0;
        this.value = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Word cur = this;
        while(cur != null){
            if (cur.value!=null) {
                sb.append(cur.value + ":" + cur.num + "\n");
            }
            cur = cur.next;
        }
        return sb.toString();
    }
}