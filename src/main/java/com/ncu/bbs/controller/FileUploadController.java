package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    /*
        图片文件上传
     */
    @RequestMapping("/picture")
    @ResponseBody
    public Msg uploadPicture(HttpServletRequest request, @RequestParam( value="picture",required=false)MultipartFile upload) throws Exception {

        //使用fileupload组件完成文件上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/statics/images");//

        //判断，该路径是否存在
        File file=new File(path);//path
        if(!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        if(upload!=null){
            String filename= upload.getOriginalFilename();
            int indexp=filename.lastIndexOf('.');
            filename=filename.substring(indexp);
            //把文件的名称设置唯一值，uuid
            String uuid= UUID.randomUUID().toString().replace("-","");
            filename=uuid+filename;
            //完成文件的上传
            upload.transferTo(new File(path,filename));//path
            //System.out.println("文件上传位置："+path+filename);
            return Msg.success().add("filename",filename);
        }else{
            return Msg.fail();
        }

    }
}
