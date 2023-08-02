package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileUploadServlet", value = "/fileUpload.do")
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024)
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private String getFilename(Part part){
        String fname="";
        String header=part.getHeader("content-disposition");
        fname=header.substring(header.lastIndexOf("=")+2,header.length()-1);
        return fname;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String path=this.getServletContext().getRealPath("/");
        System.out.println(path);
        Part p=request.getPart("filename");
        String message1="";
        if(p.getSize()>1024*1024){
            p.delete();
            message1="文件太大，不能上传";
        }else {
            File f=new File(path);
            if(!f.exists()){
                f.mkdir();
            }
            String fname=getFilename(p);
            p.write(path+"\\"+fname);
            message1="文件上传成功";
        }
        request.setAttribute("message1",message1);
        RequestDispatcher rd= request.getRequestDispatcher("/fileUpload.jsp");
        rd.forward(request,response);
    }
}
