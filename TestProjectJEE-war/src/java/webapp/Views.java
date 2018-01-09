package webapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import model.Etudiant;
import model.Stage;
import model.User;

public class Views {

    public String loginForm(HttpServletRequest request, User user, String message) {
        request.setAttribute("user", user);
        request.setAttribute("message", message);
        return ("/WEB-INF/loginForm.jsp");
    }

    public String home(HttpServletRequest request, User user, ArrayList<Stage> stages, String message) {
        request.setAttribute("user", user);
        request.setAttribute("stages", stages);
        request.setAttribute("message", message);
        return ("/WEB-INF/home.jsp");
    }

    public String message(HttpServletRequest request, String message) {
        request.setAttribute("message", message);
        return ("/WEB-INF/message.jsp");
    }
    
    public String addStudent(HttpServletRequest request, String message, User user, ArrayList<Etudiant> etudiants){
        request.setAttribute("message", message);
        request.setAttribute("user", user);
        request.setAttribute("etudiants", etudiants);
        return ("/WEB-INF/addStudent.jsp");
    }
    
    public String studentDetails(HttpServletRequest request, User user, Stage stage, Etudiant etu, String message){
        request.setAttribute("user", user);
        request.setAttribute("stage", stage);
        request.setAttribute("etudiant", etu);
        request.setAttribute("message", message);
        return ("/WEB-INF/studentDetails.jsp");
    }
    
    public String showPdf(HttpServletRequest request, User user, Stage stage, Etudiant etu){
        request.setAttribute("user", user);
        request.setAttribute("stage", stage);
        request.setAttribute("etudiant", etu);
        return ("/WEB-INF/printPdf.jsp");
    }
    
    public String printPdf(HttpServletRequest request, User user, Stage stage, Etudiant etu, HashMap<String, String> pdfInfos){
            
        
        request.getSession().setAttribute("bilan", pdfInfos.get("bilan"));
        request.getSession().setAttribute("positif", pdfInfos.get("positif"));
        request.getSession().setAttribute("axe", pdfInfos.get("axe"));
        request.getSession().setAttribute("date", pdfInfos.get("date"));
        request.getSession().setAttribute("titre", pdfInfos.get("titre"));
        request.getSession().setAttribute("voix", pdfInfos.get("voixEntreprise"));
        request.getSession().setAttribute("duree", pdfInfos.get("duree"));
        request.getSession().setAttribute("pdf", pdfInfos.get("pdf"));
        
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("stage", stage);
        request.getSession().setAttribute("etudiant", etu);
        request.getSession().setAttribute("pdfInfos", pdfInfos);
        
        request.getSession().setAttribute("nom", etu.getNom());
        request.getSession().setAttribute("entreprise", "entreprise");
        request.getSession().setAttribute("adresse", stage.getAdresse());
        request.getSession().setAttribute("Mds", stage.getMaitreStage());
        
        
        return ("/WEB-INF/PDF.jsp");
    }
    
}