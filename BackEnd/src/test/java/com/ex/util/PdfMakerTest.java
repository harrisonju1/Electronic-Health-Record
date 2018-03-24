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
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PdfMakerTest {

    @Test
    public void pdfDocumentTest() {
        PdfMaker maker = new PdfMaker();
        maker.setTitle("PdfTitleTest")
            .setSubject("PDF Subject Test")
            .add(new Paragraph("Test Text here"))
            .addText("Some text")
            .addList(new ArrayList<String>(3){}, false);
        Object pdfdata = maker.finishDocument();
//        System.out.println(pdfdata);
        Assert.assertNotNull(pdfdata);
    }
}