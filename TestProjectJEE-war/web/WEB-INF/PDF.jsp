<%@page import="java.util.HashMap"%>
<%@page import="java.awt.Point"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="com.lowagie.text.DocumentException"%>
<%@page import="com.lowagie.text.PageSize"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.FontFactory"%>
<%@page import="com.lowagie.text.Font"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.Table"%>
<%@page import="com.lowagie.text.Cell"%>
<%@page import="com.lowagie.text.Image"%>
<%@page import="model.User"%>
<%@page import="com.lowagie.text.Chunk"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <link rel="stylesheet" href="bulma.css" />
        <title>fICHE</title>
    </head>
        
  </nav>
        <hr>
        <%
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document,
            new FileOutputStream((String) session.getAttribute("pdf")));
            document.open();
            
            Image image = Image.getInstance((String)config.getServletContext().getRealPath("/") + "logo-efrei-paris.jpg");
            image.scaleToFit(150f, 600f);
            document.add(image);
            Paragraph p = new Paragraph("Fiche de Visite",new Font(Font.BOLD, 14,Font.UNDERLINE));
            p.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p);
            p = new Paragraph("Sur Site / Téléphonique",new Font(10));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p);
            p = new Paragraph("Année : M1 / M2",new Font(10));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p);
            p = new Paragraph("(entourer la mention utile)",new Font(Font.ITALIC,8));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p);
            p=new Paragraph("Stagiaire  :  "+(String)session.getAttribute("nom") +"Filière",new Font(10) );
            p.add(new Paragraph("",new Font(4)));
            document.add(p);
            p=new Paragraph("Entreprise :  " + (String)session.getAttribute("entreprise") + "   "+ (String)session.getAttribute("adresse") ,new Font(10));
            p.add(new Paragraph("",new Font(4)));
            document.add(p);
            p=new Paragraph("Responsable du stage :  " + (String)session.getAttribute("Mds"),new Font( 10));
            p.add(new Paragraph("",new Font(4)));
            document.add(p);
            p=new Paragraph((String)session.getAttribute("titre"),new Font( 10));
            p.add(new Paragraph("",new Font(4)));
            document.add(p);
            p=new Paragraph("Cahier des charges du stage fourni : OUI / NON ",new Font( 10));
            p.add(new Paragraph("",new Font(4)));
            document.add(p);
            
            Table tableau = new Table(24);
           
            p = new Paragraph();
            p.add(new Paragraph(" Comportement Général",new Font(8)));
            p.add(new Paragraph("",new Font(2)));
            Cell c = new Cell(p);
            c.setColspan(19);
            c.setVerticalAlignment(Cell.HEADER);
            tableau.addCell(c);
            tableau.addCell(" A");
            tableau.addCell(" B");
            tableau.addCell(" C");
            tableau.addCell(" D");
            tableau.addCell(" E");
            
            p = new Paragraph();
            p.add(new Paragraph(" Intégration au sein de l'entreprise, comportement",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Motivation et Intégrêt pour les missions confiées",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Prise d'initiative, créativité",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Sens des responsabilités",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Rigueur, professionnalisme",new Font(Font.NORMAL,8)));
            p.add(new Paragraph("",new Font(2)));
            c = new Cell(p);
            c.setRowspan(5);
            c.setColspan(19);
            tableau.addCell(c);
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            
            p = new Paragraph();
            p.add(new Paragraph(" Compétences Techniques",new Font(8)));
            p.add(new Paragraph("",new Font(2)));
            c = new Cell(p);
            c.setColspan(19);
            tableau.addCell(c);
            tableau.addCell(" A");
            tableau.addCell(" B");
            tableau.addCell(" C");
            tableau.addCell(" D");
            tableau.addCell(" E");
            
            p = new Paragraph();
            p.add(new Paragraph(" Acquisition du contexte",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Maitrise des technologies",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Capacité à s'adapter à de nouvelles techniques ou technologies",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Capacité d'analyse d'une situation ou d'une problématique",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Capacité de proposition de solutions",new Font(Font.NORMAL,8)));
            p.add(new Paragraph("",new Font(2)));
            c= new Cell(p);
            c.setRowspan(5);
            c.setColspan(19);
            tableau.addCell(c);
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            
            p = new Paragraph();
            p.add(new Paragraph(" Gestion du Projet",new Font(8)));
            p.add(new Paragraph("",new Font(2)));
            c = new Cell(p);
            c.setColspan(19);
            tableau.addCell(c);
            tableau.addCell(" A");
            tableau.addCell(" B");
            tableau.addCell(" C");
            tableau.addCell(" D");
            tableau.addCell(" E");
            
            p = new Paragraph();
            p.add(new Paragraph(" Organisation du travail",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Autonomie",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Compte rendu régulier du travail au Maitre de stage",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Prise de parole en réunion",new Font(Font.NORMAL,8)));
            p.add(new Paragraph(" Communication écrite",new Font(Font.NORMAL,8)));
            p.add(new Paragraph("",new Font(2)));
            c= new Cell(p);
            c.setRowspan(5);
            c.setColspan(19);
            tableau.addCell(c);
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
            tableau.addCell("");
       
            
            document.add(tableau);
            p = new Paragraph();
            p.add(new Paragraph("A (excellent), B (satifaisant), C (en cours d'acquisition), D (non acquis), E (pose problème)",new Font(Font.NORMAL,8)));
            document.add(p);
            document.add(Chunk.NEWLINE);
            document.newPage();
            p = new Paragraph();
            p.add(new Paragraph("Bilan des missions",new Font(Font.BOLD,10,Font.UNDERLINE)));
            p.add(new Paragraph((String)session.getAttribute("bilan"),new Font(Font.NORMAL,8)));
            p.setSpacingAfter(40f);
            document.add(p);
            p= new Paragraph();
            p.add(new Paragraph("Points positifs",new Font(Font.BOLD, 10,Font.UNDERLINE)));
            p.add(new Paragraph((String)session.getAttribute("positif"),new Font(Font.NORMAL,8)));
            p.setSpacingAfter(40f);
            document.add(p);
             p= new Paragraph();
            p.add(new Paragraph("Axe de progrès",new Font(Font.BOLD, 10,Font.UNDERLINE)));
            p.add(new Paragraph((String)session.getAttribute("axe"),new Font(Font.NORMAL,8)));
            p.setSpacingAfter(40f);
            document.add(p);
             p= new Paragraph();
            p.add(new Paragraph("Voix de l'entreprise (vis-à-vis de l'école)",new Font(Font.BOLD, 10,Font.UNDERLINE)));
            p.add(new Paragraph((String)session.getAttribute("voix"),new Font(Font.NORMAL,8)));
            p.setSpacingAfter(40f);
            document.add(p);
            User user = (User) session.getAttribute("user");
            String nom = user.getLastname();
            String prenom = user.getFirstname();
            p = new Paragraph("Visite effectuée par : "+nom+" "+prenom,new Font(Font.BOLD,10));
            p.setSpacingAfter(20f);
            document.add(p);
            p = new Paragraph("Le  "+(String)session.getAttribute("date")+"durée de la visite : "+(String)session.getAttribute("duree"),new Font(Font.BOLD,10));
            p.setSpacingAfter(30f);
            document.add(p);
            document.add(new Paragraph("Signature",new Font(Font.BOLD,10)));
            
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
            document.close();
        %>
    </body>
</html>
