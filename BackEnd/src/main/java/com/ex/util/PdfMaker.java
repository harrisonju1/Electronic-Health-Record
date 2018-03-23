package com.ex.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang.CharSet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PdfMaker {

    private ByteArrayOutputStream output;
    private Document doc;

    public PdfMaker() {
        newDocument();
    }
    private void newDocument() {
        doc = new Document();
        try {
            output = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, output);
            doc.addAuthor("Universal Healthcare Force");
            doc.addCreator("Team Triple G Force");
            doc.open();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public Object finishDocument() {
        try {
            doc.close();
            return output.toByteArray();
        } catch (Exception e) {
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
            return null;
        }
        return this;
    }
    @Override
    protected void finalize() throws Throwable {
        finishDocument();
        super.finalize();
    }
}
