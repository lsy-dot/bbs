package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.util.ImageUploadUtil;
import com.sun.deploy.net.HttpResponse;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 富文本编辑器图片上传
     * @param
     * @return
     */
    @RequestMapping(value="/uploadImage")
    public String imageUpload(@RequestParam("upload") MultipartFile file,
                              @RequestParam("CKEditorFuncNum") String CKEditorFuncNum,
                              HttpServletResponse response,
                              HttpServletRequest request) throws IOException {
        System.out.println("有文件想要上传");
        PrintWriter out = response.getWriter();
        String name = null;
        name = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
        String uploadContentType = file.getContentType();
        //处理文件后缀
        String expandedName = "";
        if (uploadContentType.equals("image/pjpeg")
                || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png")
                || uploadContentType.equals("image/x-png")) {
            // IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            //文件格式不符合，返回错误信息
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return null;
        }

        //文件命名并保存到服务器
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        name = df.format(new Date()) +expandedName;
        String DirectoryName =request.getContextPath()+"/tempImag";
        System.out.println(DirectoryName);
        try {
            File file1 = new File(request.getServletContext().getRealPath("/tempImag"),name);
            System.out.println(file1.getPath());
            file.transferTo(file1);//这里是真正上传
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileURL =request.getContextPath() + "/tempImag/"+name;

        // 返回"图像"选项卡和图像在服务器的地址并显示图片
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" +fileURL+"','')");
        out.println("</script>");
        out.close();
        return null;
    }

    /**
     * 新版本上传图片的方式返回json串
     * @param request
     * @param response
     */
    @RequestMapping(value = "/root/uploadSource")
    public void uploadSource(HttpServletRequest request, HttpServletResponse response){

        String DirectoryName = "upload";
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
