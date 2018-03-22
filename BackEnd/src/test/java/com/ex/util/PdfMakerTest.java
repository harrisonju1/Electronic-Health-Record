package com.ex.util;

import com.itextpdf.text.Paragraph;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PdfMakerTest {

    @Test
    public void pdfDocumentTest() {
        PdfMaker maker = new PdfMaker();
        maker.setTitle("PdfTitleTest");
        maker.setSubject("PDF Subject Test");
        maker.add(new Paragraph("Test Text here"));
        String pdfdata = maker.finishDocument();
//        System.out.println(pdfdata);
        Assert.assertTrue(pdfdata.contains("Title"));
        Assert.assertTrue(pdfdata.contains("Subject"));
        Assert.assertTrue(pdfdata.contains("Text"));
    }

}