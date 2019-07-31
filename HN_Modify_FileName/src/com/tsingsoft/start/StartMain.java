package com.tsingsoft.start;
import com.tsingsoft.service.FileServiceImp;

public class StartMain {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        FileServiceImp service = new FileServiceImp();
        service.handleModifyFileName();
        Long end = System.currentTimeMillis();
        Long time = end - start;
        System.out.println("用时："+time/1000+" 秒");
    }
}

