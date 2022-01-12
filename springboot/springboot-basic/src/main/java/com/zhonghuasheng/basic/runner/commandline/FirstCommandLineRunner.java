package com.zhonghuasheng.basic.runner.commandline;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Order(1)
public class FirstCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FirstCommandLineRunner order = 1");
        Map<String, String> maps = new HashMap<>();
        Date now = new Date();

        maps.put("${year}", "2021");
        maps.put("${month}", "04");
        maps.put("${day}", "19");
        maps.put("${applicant}", "加盟商1号");
        maps.put("${businessLicenseNum}", "9DFDD8FDS899898");
        maps.put("${address}", "湖北省武汉市洪山区关山大道111号");
        System.out.println("step1");
        String pathPrefix = "/data/" + System.currentTimeMillis();
        try {
            URL url = new URL("https://jv-product-1259380639.cos.ap-shanghai.myqcloud.com/fc-store-merchants/upload/%E7%BE%8E%E5%AD%9A1%E5%8F%B7%E8%BD%A6%E5%85%BB%E6%8A%A4%E8%87%BB%E9%80%89%E5%BA%97%E7%89%B9%E8%AE%B8%E7%BB%8F%E8%90%A5%E5%8D%8F%E8%AE%AE.docx");
            InputStream doc = url.openStream();
            XWPFDocument document = new XWPFDocument(doc);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            // 填充占位符
            for (XWPFParagraph paragraph : paragraphs) {
                String text = paragraph.getText();
                if (text.contains("${")) {
                    List<XWPFRun> runs = paragraph.getRuns();
                    for (XWPFRun run : runs) {
                        if (run.toString().contains("${")) {
                            run.setText(maps.get(run.text()), 0);
                        }
                    }
                }
            }

            FileOutputStream docOut = new FileOutputStream(pathPrefix + ".docx");
            document.write(docOut);
            FileOutputStream docOut2 = new FileOutputStream(pathPrefix + ".txt");
            document.write(docOut2);
            System.out.println("step2");
            // 生成PDF
            //String pdfPath = "C:\\Users\\yong.chen\\Downloads\\" + System.currentTimeMillis() + ".pdf";
            String pdfPath = pathPrefix + ".pdf";
            PdfOptions options = PdfOptions.create();
            FileOutputStream fileOutputStream = new FileOutputStream(pdfPath);
            PdfConverter.getInstance().convert(document, fileOutputStream, options);
            doc.close();
            doc.close();
            fileOutputStream.close();
            // 设置PDF水印
            //String pdfPath2 = "C:\\Users\\yong.chen\\Downloads\\" + System.currentTimeMillis() + "-copy-.pdf";
            String pdfPath2 = pathPrefix + "-yyyyyy-.pdf";
            PdfReader reader = new PdfReader(pdfPath);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pdfPath2));
            // 设置是支持中文的写法 使用系统字体
            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            int total = reader.getNumberOfPages() + 1;
            System.out.println("step3");
            PdfContentByte under;
            Rectangle pageRect = null;
            for (int i = 1; i < total; i++) {
                pageRect = stamper.getReader().getPageSizeWithRotation(i);
                // 计算水印X,Y坐标
                float x = 290;//
                x = pageRect.getWidth() / 2;
                float y = 400;//
                y = pageRect.getHeight() / 2;
                // 获得PDF最顶层 在内容上方加水印
                under = stamper.getOverContent(i);//
                under.saveState();
                PdfGState gs = new PdfGState();
                // 设置透明度范围为0到1
                gs.setFillOpacity(0.3f);
                under.setGState(gs);
                under.beginText();
                under.setFontAndSize(base, 90);//字体大小
                under.setColorFill(BaseColor.GRAY);//字体颜色
                // 水印文字成45度角倾斜
                under.showTextAligned(Element.ALIGN_CENTER, "孚创合同专用", x, y, 45);
                // 添加水印文字
                under.endText();
                under.setLineWidth(1f);
                under.stroke();
            }
            stamper.close();
            reader.close();
            System.out.println("step4");
            /*String fileName = URLEncoder.encode("美孚1号车养护臻选店特许经营协议", "UTF-8");
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf8");
            //response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
            response.setHeader("Content-Type", "application/octet-stream;charset=utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(pdfPath2);
            // 读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            System.out.println("step5");*/
            fileOutputStream.close();
            /*outputStream.flush();
            outputStream.close();*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
