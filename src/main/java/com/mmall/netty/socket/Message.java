package com.mmall.netty.socket;

import java.io.*;
public class Message {
    /**
     * 消息长度
     */
    private Integer lenth;

    /**
     * 消息类别
     */
    private Short type;


    /**
     * 时间戳
     */
    private Long timestamp;


    /**
     * 消息内容
     */
    private byte[] content;

    /**
     * 数据
     */
    private byte[] data;

    public Message() {

    }

    public Message(Short type, Long timestamp, byte[] content, byte[] data) {
        super();
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
        this.data = data;
    }


    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    /**
     * 先计算长度，再返回。这里长度包含长度本身的字节
     */
    public Integer getLenth() {

        this.lenth = headLenth() +content.length+data.length;

        return lenth;
    }

    public static Integer headLenth() {
        return 2+4 + 8+4;
    }


    @Override
    public String toString() {
        String msg=new String(content);
        if (getLenth()>10000000) {
            return "Message [lenth=" + this.getLenth() +", type=" + type+", timestamp=" + timestamp + ", content=...(省略"+msg.length()+"字)...."+ ", datalenth="+this.getDataLenth()+"]";
        }
        return "Message [lenth=" + this.getLenth() +", type=" + type+", timestamp=" + timestamp + ", content=" + msg + ", datalenth="+this.getDataLenth()+"]";
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public Integer getDataLenth() {
        return data.length;
    }


}
