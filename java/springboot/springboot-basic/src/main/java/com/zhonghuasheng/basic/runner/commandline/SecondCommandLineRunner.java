package com.zhonghuasheng.basic.runner.commandline;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@Order(2)
public class SecondCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SecondCommandLineRunner order = 2");
        PdfReader reader = new PdfReader("https://jv-product-1259380639.cos.ap-shanghai.myqcloud.com/fc-store-merchants/upload/tempr.pdf");
        String path = "/data/" + System.currentTimeMillis();
        FileOutputStream out = new FileOutputStream(path + "--xxxx-.pdf");
        PdfStamper stamper = new PdfStamper(reader, out);
        AcroFields form = stamper.getAcroFields();

        Map<String, String> data=new HashMap();
        data.put("year", "2021");
        data.put("month","5");

        int i = 0;
        Map<String, AcroFields.Item> fields = form.getFields();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        // set the field values in the pdf form
        for (Iterator it = data.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            String value = (String) data.get(key);
            form.setFieldProperty(key, "textfont", bfChinese, null);
            form.setField(key, value);

        }
/*        fields.keySet().forEach(item -> {
            item.toString();
            try {
                form.setFieldProperty(item.toString(), "textfont", bfChinese, null);
                form.setField(item.toString(), data.get(item.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });*/
        stamper.setFormFlattening(true);//设置为无法编辑
        stamper.close();
    }
}
