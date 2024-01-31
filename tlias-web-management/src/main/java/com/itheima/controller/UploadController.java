package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam("image") MultipartFile file) throws IOException {

        log.info("upload，{}, {}, {}", username, age, file);

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 构造唯一文件名
        String uuid = UUID.randomUUID().toString();
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String uniqueName = uuid + extname;

        // 保存文件
        file.transferTo(new File("D:\\images\\" + uniqueName));

        return Result.success();

    }

}
