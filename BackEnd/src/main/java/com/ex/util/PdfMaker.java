package com.ex.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang.CharSet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PdfMaker {

    private ByteArrayOutputStream output;
    private Document doc;

    /// Create a new PDF
    public PdfMaker() {
        newDocument();
    }
    /// (private) set up a new document
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
    /// returns the final byte array of the pdf
    /// no more elements can be added after this
    /// send this back to the client
    public Object finishDocument() {
        try {
            doc.close();
            return output.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /// sets the title metadata of the pdf
    public PdfMaker setTitle(String title) {
        doc.addTitle(title);
        return this;
    }
    /// sets the subject metadata of the pdf
    public PdfMaker setSubject(String subject) {
        doc.addTitle(subject);
        return this;
    }
    /// add a com.itextpdf.text element to the pdf
    public PdfMaker add(Element e) {
        try {
            doc.add(e);
        } catch (DocumentException e1) {
            e1.printStackTrace();
            return null;
        }
        return this;
    }
    /// adds text to the pdf in a new paragraph
    public PdfMaker addText(String s) {
        try {
            Paragraph paragraph = new Paragraph();
            paragraph.add(s);
            doc.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
        return this;
    }
    /// adds a list to the pdf
    /// can be ordered or unordered
    public PdfMaker addList(List list, boolean ordered) {
        if (list != null) {
            try {
                com.itextpdf.text.List pdflist;
                pdflist = new com.itextpdf.text.List(ordered);
                for (int i = 0; i < list.size(); i++) {
                    pdflist.add(String.valueOf(list.get(i)));
                }
                doc.add(pdflist);
            } catch (DocumentException e1) {
                e1.printStackTrace();
                return null;
            }
        }
        return this;
    }
    @Override
    protected void finalize() throws Throwable {
        finishDocument();
        super.finalize();
    }
}
