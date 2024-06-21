package com.controller;

import com.utils.Code;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;

@RestController
@RequestMapping("/commons")
public class CommonController {

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
//        System.out.println("访问了上传文件");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFile = java.util.UUID.randomUUID().toString()+suffix;

        String path = "D:\\upload";
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        try {
            file.transferTo(new File(path +"/"+newFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Result(Code.SAVE_OK,newFile);
    }

    @GetMapping("/down")
    public Result download(String name, HttpServletResponse response){

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\upload\\" + name));
            ServletOutputStream outputStream = response.getOutputStream();
            int len=0;
            byte[] bytes = new byte[1024];
            while((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Result(Code.GET_OK,null);
    }
}
