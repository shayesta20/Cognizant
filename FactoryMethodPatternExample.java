interface Document {
    String getType();
}

class WordDocument implements Document {
    @Override
    public String getType() {
        return "Word Document";
    }
}

class PdfDocument implements Document {
    @Override
    public String getType() {
        return "PDF Document";
    }
}

class ExcelDocument implements Document {
    @Override
    public String getType() {
        return "Excel Document";
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        System.out.println("Created: " + word.getType());
        System.out.println("Created: " + pdf.getType());
        System.out.println("Created: " + excel.getType());
    }
}
