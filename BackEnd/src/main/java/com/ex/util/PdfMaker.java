package com.ex.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang.CharSet;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class PdfMaker {

    PdfWriter pdfwriter;
    ByteArrayOutputStream output;
    Document doc;

    public PdfMaker() {
        newDocument();
    }
    private void newDocument() {
        doc = new Document();
        try {
            output = new ByteArrayOutputStream();
            pdfwriter = PdfWriter.getInstance(doc, output);
            doc.open();
            doc.addAuthor("Universal Healthcare Force");
            doc.addCreator("Team Triple G Force");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public String finishDocument() {
        doc.close();
        pdfwriter.close();
        try {
            String pdfdata = output.toString("UTF-8");
            return pdfdata;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public PdfMaker setTitle(String title) {
        doc.addTitle(title);
        return this;
    }
    public PdfMaker setSubject(String subject) {
        doc.addTitle(subject);
        return this;
    }
    public PdfMaker add(Element e) {
        try {
            doc.add(e);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        return this;
    }
    @Override
    protected void finalize() throws Throwable {
        finishDocument();
        super.finalize();
    }
}
