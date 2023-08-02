package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "FileDownLoadServlet", value = "/FileDownLoadServlet.do")
public class FileDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置响应的内容为pdf文件
        String dataDirectory=request.getServletContext().getRealPath("/WEB-INF/data");
//        设置响应头，指定文件名
        File file=new File(dataDirectory,"Java.pdf");
        if(file.exists()){
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","attachment;filename=Java.pdf");
            byte[] buffer=new byte[1024];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try {
//                创建文件输入流
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
//                返回输出流对象
                OutputStream os=response.getOutputStream();
//                读取1kb
                int i=bis.read(buffer);
                while (i!=-1){
                    os.write(buffer,0,i);
                    i=bis.read(buffer);
                }
            }catch (IOException ex){
                System.out.println(ex.toString());
            }finally {
                if(bis!=null){
                    bis.close();
                }
                if (fis!=null){
                    fis.close();
                }
            }
        }else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            out.print("文件不存在！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
