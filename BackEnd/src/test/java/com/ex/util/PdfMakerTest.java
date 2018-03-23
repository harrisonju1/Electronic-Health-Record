package com.ex.util;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Assert;
import org.junit.Test;

import javax.print.Doc;

import java.io.*;

import static org.junit.Assert.*;

public class PdfMakerTest {

    @Test
    public void pdfDocumentTest() {
        PdfMaker maker = new PdfMaker();
        maker.setTitle("PdfTitleTest");
        maker.setSubject("PDF Subject Test");
        maker.add(new Paragraph("Test Text here"));
        Object pdfdata = maker.finishDocument();
//        System.out.println(pdfdata);
        Assert.assertNotNull(pdfdata);
    }
}