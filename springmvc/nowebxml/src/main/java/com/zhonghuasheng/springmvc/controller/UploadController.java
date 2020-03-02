package com.zhonghuasheng.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) {
        try {
            FileUtils.writeByteArrayToFile(new File(request.getSession().getServletContext().getRealPath("") + file.getOriginalFilename()), file.getBytes(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Upload success";
    }
}
