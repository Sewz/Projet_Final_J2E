/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;

import business.Business;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import model.Etudiant;
import model.Stage;



public class Controller extends HttpServlet {
    private Business business = new Business();
    final private ArrayList<Stage> STAGES = new ArrayList<Stage>();
    final private Views VIEWS = new Views();

    final private String LOGIN_URL = "/login.do";
    final private String LOGOUT_URL = "/logout.do";
    final private String ADD_STUDENT_URL = "/addStudent.do";
    final private String STUDENT_DETAILS = "/studentDetails";
    final private String UPDATE_STUDENT = "/updateStudent.do";
    final private String UPDATE_STUDENT_INFOS = "/updateStudentsInfo";
    final private String SHOW_PDF = "/showPdfPage";    
    final private String PRINT_PDF = "/printPdf.do";  
    
    public User getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        synchronized (session) {
            Object o = session.getAttribute("user");
            if (o instanceof User) {
                return (User) o;
            }
            User newUser = new User();
            session.setAttribute("user", newUser);

            return (newUser);
        }
    }
    
    // Interception d'une requête
    public String beforeAll(HttpServletRequest request) {
        // pour obtenir le temps de calcul
        request.setAttribute("timer", System.currentTimeMillis());
        // vérifier l'authentification
        
        
        
        if (!request.getServletPath().equals(LOGIN_URL)) {
            User user = getUser(request);
            
            if (user.getAuth() == false) {
                String msg = "Vous devez vous authentifier";
                return VIEWS.loginForm(request, user, msg);
            }
        }
        return null;
    }

    // Interception après vue
    public void afterAll(HttpServletRequest request) {
        Long start = (Long) request.getAttribute("timer");
        Long duration = System.currentTimeMillis() - start;
    }
    
    // Interception avant vue
    public String beforeView(String view, HttpServletRequest request) {
        return (view);
    }

    // Interception d'une erreur
    public String error(HttpServletRequest request,
            HttpServletResponse response, Throwable e) {
        String msg = "erreur interne : " + e.getMessage();
        return VIEWS.message(request, msg);
    }
    
    
    public String doPdf(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");
        
        
        HashMap<String, String> pdfInfos = new HashMap<>();
        pdfInfos.put("titre", request.getParameter("titre"));
        pdfInfos.put("bilan", request.getParameter("bilan"));
        pdfInfos.put("positif", request.getParameter("positif"));
        pdfInfos.put("axe", request.getParameter("axe"));
        pdfInfos.put("voixEntreprise", request.getParameter("voixEntreprise"));
        pdfInfos.put("date", request.getParameter("date"));
        pdfInfos.put("duree", request.getParameter("duree"));
        pdfInfos.put("pdf", request.getParameter("pdf"));

        
        String stageId = request.getParameter("stageid");   
        Stage stage = findStage(stageId);
        
        Etudiant etu = new Etudiant();
        etu.setId(request.getParameter("etudiantid"));
        etu.setNom(business.fetchStudentById(Integer.parseInt(request.getParameter("etudiantid"))));

        return VIEWS.printPdf(request, user, stage, etu, pdfInfos);
        
        
    }
    
    public String doAddStudent(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");
        
        boolean isPost = "POST".equals(request.getMethod());
        ArrayList<Etudiant> etudiants = business.getAllEtudiants();
        if (isPost){
            
            Etudiant etudiant = new Etudiant();
            etudiant.setId(request.getParameter("choixEtu"));
            etudiant.setNom(business.fetchStudentById(Integer.parseInt(request.getParameter("choixEtu"))));
           
            
            // ajouter conditions vérifs étudiants, statut à ajouter dans étudiant
            
            if (business.isApprenti(etudiant)){
                return VIEWS.addStudent(request, "<div class=\"notification is-info\">"
                        + "Ajout impossible, l'élève est un apprenti</div>", user,  etudiants);
            }
            
            if (business.isInStage(etudiant)){
                return VIEWS.addStudent(request, "<div class=\"notification is-warning\">"
                        + "Ajout impossible, l'élève est déjà assigné</div>", user,  etudiants);
            }
            
            
            
            STAGES.add(business.createStage(etudiant, user));
            
            return VIEWS.addStudent(request, "<div class=\"notification is-success\">"
                    + "Etudiant ajouté à vos stages</div>", user,  etudiants);
        }
        else{
            return VIEWS.addStudent(request, "", user,  etudiants);
        }
             
        
        
        
    }
    
    public String doStudentDetails(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");
        
        if(request.getParameter("choixStage") == null)
            return VIEWS.home(request, user, STAGES, "");
        
        String stageId = request.getParameter("choixStage");   
        Stage stageToUpdate = findStage(stageId);
        
        Etudiant etu = new Etudiant();
        etu.setId(request.getParameter("etudiantid"));
        etu.setNom(business.fetchStudentById(Integer.parseInt(request.getParameter("etudiantid"))));
        
        return VIEWS.studentDetails(request, user, stageToUpdate, etu, "");
    }
    
    public String showPdf(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");
        
        
        int i = 0;
        for(Stage stage : STAGES) { 
            if(stage.getId().equals(request.getParameter("stageid"))) { 
                break;
            }
            i++;
        }
        Etudiant etu = new Etudiant();
        etu.setId(request.getParameter("etudiantid"));
        etu.setNom(business.fetchStudentById(Integer.parseInt(request.getParameter("etudiantid"))));
        
        return VIEWS.showPdf(request, user, STAGES.get(i), etu);
    }
    
    public String doUpdateStudentInfos(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");
        
        String stageId = request.getParameter("stageid");   
        Stage stageToUpdate = findStage(stageId);
            
        stageToUpdate.setDescriptionMission(request.getParameter("description")); 
        stageToUpdate.setCommentaire(request.getParameter("commentaire")); 
        
        Etudiant etu = new Etudiant();
        etu.setId(request.getParameter("etudiantid"));
        etu.setNom(business.fetchStudentById(Integer.parseInt(request.getParameter("etudiantid"))));
        
        
        business.updatStageDescriptionComm(stageToUpdate);
        String message ="<div class=\"notification is-success\">\n" +
"                Modifications bien prise en compte\n" +
"            </div>\n";
        return VIEWS.studentDetails(request, user, stageToUpdate, etu, message);
        
    }
    
    public String doUpdateStudent(HttpServletRequest request) throws SQLException{
        User user = getUser(request);
        // si l'utilisateur est inconnu
        if (!user.getAuth())
            return VIEWS.loginForm(request, user, "Veuillez vous authentifier");

        
        if(request.getParameter("choixStage") == null){
            String message ="<div class=\"notification is-info\">\n" +
"                Veuillez sélectionner un stage pour le modifier\n" +
"            </div>\n";
            return VIEWS.home(request, user, STAGES, message);
        }
            
        
        String action = request.getParameter("action");

        if ("Details".equals(action)) {
            return this.doStudentDetails(request);
        // alors "Valider"
        } else {
            
            String stageId = request.getParameter("choixStage");   
            Stage stageToUpdate = findStage(stageId);
        

            stageToUpdate.setGroupe(request.getParameter("groupe_" + stageId));
            stageToUpdate.setCdc((request.getParameter("cdc_" + stageId) != null));
            stageToUpdate.setFicheVisite((request.getParameter("fichevisite_" + stageId) != null));
            stageToUpdate.setFicheEval((request.getParameter("ficheeval_" + stageId) != null));
            stageToUpdate.setSondageWeb((request.getParameter("sondageweb_" + stageId) != null));
            stageToUpdate.setRapportRendu((request.getParameter("rapportrendu_" + stageId) != null));
            stageToUpdate.setSoutenance((request.getParameter("soutenance_" + stageId) != null));
            stageToUpdate.setVisitePlanif((request.getParameter("visiteplanif_" + stageId) != null));
            stageToUpdate.setVisiteFaite((request.getParameter("visitefaite_" + stageId) != null));
            stageToUpdate.setDateDebut(request.getParameter("datedebut_" + stageId));
            stageToUpdate.setDateFin(request.getParameter("datefin_" + stageId));
            stageToUpdate.setMaitreStage(request.getParameter("maitrestage_" + stageId));
            stageToUpdate.setAdresse(request.getParameter("adresse_" + stageId));
            stageToUpdate.setNoteCom(Float.parseFloat(request.getParameter("notecom_" + stageId)));
            stageToUpdate.setNoteTech(Float.parseFloat(request.getParameter("notetech_" + stageId)));
            //stageToUpdate.setId(request.getParameter("stageid"));


            business.updateStage(stageToUpdate);

            return VIEWS.home(request, user, STAGES, "");
        }
    }
    
    public Stage findStage(String id ){
        for(Stage stage : STAGES) {
            if(stage.getId().equals(id)) 
                return stage;     
        }
        return null;
    }
    
    public static int getIndex(Set<? extends Object> set, Object value) {
        int result = 0;
        for (Object entry:set) {
          if (entry.equals(value)) return result;
          result++;
        }
        return -1;
    }

    public String doLogin(HttpServletRequest request) throws SQLException {
        User user = getUser(request);
        // si l'utilisateur est connu
        if (user.getAuth())
            return VIEWS.home(request, user, STAGES, "");

        // récupérer les données du formulaire
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));


        // si aucune données retour au formulaire
        if (user.getName() == null || user.getPassword() == null)
            return VIEWS.loginForm(request, user, null);


        // traiter les données
        if (user.getPassword().length() == 0)
            return VIEWS.loginForm(request, user, "Mot de passe vide");

        business.authenticate(user);
        if (user.getAuth()){
            business.fillUser(user);
            business.fillStagesArray(STAGES, user);
            
            for(Stage stage : STAGES){
                stage.setNomEtudiant(business.fetchStudentNameById(stage.getEtudiantId()));
            }
            
            return VIEWS.home(request, user, STAGES, "");          
        }
            

        // l'authentification a échoué
        return VIEWS.loginForm(request, user, "mot de passe incorrecte");
    }

    public String doLogout(HttpServletRequest request) {
        User user = getUser(request);
        user.setAuth(false);
        user.setId("");
        user.setName("");
        user.setPassword("");
        STAGES.clear();
        return VIEWS.message(request, "A bientôt");
    }
    
    @Override
    final protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {            
            String view = beforeAll(request);
            if (view == null)
                view = processAction(request, response);
            if (view != null)
                view = beforeView(view, request);
            if (view != null)
                processView(view, request, response);
        } catch (Throwable t) {
            String view = error(request, response, t);
            if (view != null)
                try {
                    processView(view, request, response);
                } catch (Throwable e) {
                    throw new ServletException(e);
                }
        } finally {
            afterAll(request);
        }
    }
    
    @Override
    final protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String view = beforeAll(request);
            if (view == null)
                view = processAction(request, response);
            if (view != null)
                view = beforeView(view, request);
            if (view != null)
                processView(view, request, response);
        } catch (Throwable t) {
            String view = error(request, response, t);
            if (view != null)
                try {
                    processView(view, request, response);
                } catch (Throwable e) {
                    throw new ServletException(e);
                }
        } finally {
            afterAll(request);
        }
    }

    private String processAction(HttpServletRequest request,
            HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        if (action.equals(LOGIN_URL))
            return doLogin(request);
        if (action.equals(LOGOUT_URL))
            return doLogout(request);
        if (action.equals(ADD_STUDENT_URL))
            return doAddStudent(request);
        if (action.equals(UPDATE_STUDENT))
            return doUpdateStudent(request);
        if (action.equals(UPDATE_STUDENT_INFOS))
            return doUpdateStudentInfos(request);    
        if (action.equals(SHOW_PDF))
            return showPdf(request);
        if (action.equals(PRINT_PDF))
            return doPdf(request);
        // autres actions
        throw new ServletException("action " + action + " inconnue.");
    }

    private void processView(String view, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {
        if (view.endsWith(".jsp") || view.endsWith(".jspx")) {
            // technologie JSP/JSPX
            request.getRequestDispatcher(view).forward(request, response);
        } else if (view.endsWith(".xsl")) {
            // technologie XSLT / JAXP
        } else {
            // autres technologies
            throw new IllegalStateException("no view " + view);
        }
    }

    
    
    
    
}
    
    
    
    

