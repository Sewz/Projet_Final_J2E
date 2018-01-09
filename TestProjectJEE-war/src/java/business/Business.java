package business;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import model.Etudiant;
import model.Stage;

public class Business {
    
    public void authenticate(User user) throws SQLException {
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TUTEUR");

        while (result.next()){
            String myUsername = result.getString("username");
            String myPassword = result.getString("password");
            if (user.getName().equals(myUsername) && user.getPassword().equals(myPassword)){
                user.setAuth(true);
                user.setFirstname(result.getString("prenom"));
                user.setLastname(result.getString("nom"));
            }
        }
       
        dbConnec.disconnect();         
    }
    
    public void fillStagesArray(ArrayList<Stage> stages, User user) throws SQLException{
        
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        String query = "SELECT * FROM Stage WHERE TuteurId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(user.getId()));
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()){
            
            Stage stage = new Stage();

            // booléens
            stage.setCdc(result.getBoolean("CAHIERDESCHARGES"));
            stage.setFicheEval(result.getBoolean("FicheEvalEntr"));
            stage.setFicheVisite(result.getBoolean("FicheVisite"));
            stage.setSondageWeb(result.getBoolean("SondageWeb"));
            stage.setSoutenance(result.getBoolean("soutenance"));
            stage.setVisiteFaite(result.getBoolean("visitefaite"));
            stage.setVisitePlanif(result.getBoolean("visiteplanif"));
            
            // chaines de caractères
            stage.setGroupe(result.getString("groupe"));
            stage.setDateDebut(result.getString("dateDebut"));
            stage.setDateFin(result.getString("dateFin"));;
            stage.setGroupe(result.getString("groupe"));
            stage.setAdresse(result.getString("adresse"));
            stage.setMaitreStage(result.getString("maitrestage"));
            stage.setDescriptionMission(result.getString("descriptionmission"));
            stage.setCommentaire(result.getString("commentaire"));
            
            // entiers
            stage.setNoteCom(result.getInt("noteCom"));
            stage.setNoteTech(result.getInt("noteTech"));
            stage.setTuteurId(result.getInt("tuteurId"));
            stage.setEtudiantId(result.getInt("etudiantId"));  
            
            stage.setId(result.getString("stageid"));
            
            stages.add(stage);
            
        }
       
        dbConnec.disconnect();      
        
    }
    
    public void fillUser(User user) throws SQLException{
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        
        String query = "SELECT * FROM TUTEUR WHERE username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        ResultSet result = preparedStatement.executeQuery();
        
        while (result.next()){
            user.setId(Integer.toString(result.getInt("TuteurId")));
            user.setFirstname(result.getString("prenom"));
            user.setLastname(result.getString("nom"));
        }
        
        dbConnec.disconnect();  
    }
    
    public String fetchStudentById(int id) throws SQLException{
        
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        
        String query = "SELECT * FROM Etudiant WHERE EtudiantId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        
        String nom = "";
        while (result.next()){
            nom = result.getString("Nom");
        }
        
        dbConnec.disconnect(); 
        
        return nom;
    }
    
    public String fetchStudentNameById(int id) throws SQLException{
        
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        
        String query = "SELECT * FROM Etudiant WHERE EtudiantId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        
        String nom = "";
        while (result.next()){
            nom = result.getString("Nom");
        }
        
        dbConnec.disconnect(); 
        
        return nom;
    }
    
    public void updatStageDescriptionComm(Stage stage) throws SQLException{
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();  
        
       
        String updateTableSQL = "UPDATE Stage "
                + "SET descriptionmission = ?,"
                + " commentaire = ? "
                + "WHERE stageid = ?";  

        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, stage.getDescriptionMission());
        preparedStatement.setString(2, stage.getCommentaire());
        preparedStatement.setString(3, stage.getId());
        

        
        preparedStatement.executeUpdate();
        
        dbConnec.disconnect(); 
    }
    
    public Stage createStage(Etudiant etudiant, User user) throws SQLException{
        
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();  
        
        Stage stage = new Stage();
        
        
        // booléens
        stage.setCdc(false);
        stage.setFicheEval(false);
        stage.setFicheVisite(false);
        stage.setSondageWeb(false);
        stage.setSoutenance(false);
        stage.setVisiteFaite(false);
        stage.setVisitePlanif(false);
            
        // chaines de caractères
        stage.setGroupe("");
        stage.setDateDebut("");
        stage.setDateFin("");
        stage.setGroupe("");
        stage.setAdresse("");
        stage.setMaitreStage("");
        stage.setDescriptionMission("");
        stage.setCommentaire("");
        stage.setNomEtudiant(etudiant.getNom());

        // entiers
        stage.setNoteCom(0);
        stage.setNoteTech(0);
        stage.setTuteurId(Integer.parseInt(user.getId()));
        stage.setEtudiantId(Integer.parseInt(etudiant.getId()));  
        
        String insertTableSQL = "INSERT INTO Stage"
		+ "(TuteurId, EtudiantId, groupe, cahierdescharges, fichevisite, ficheevalentr, sondageweb,"
                + "rapportrendu, soutenance, visiteplanif, "
                + "visitefaite, datedebut, datefin, notetech,"
                + "notecom, maitrestage, adresse, "
                + "descriptionmission, commentaire) VALUES"
		+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, etudiant.getId());
        
        preparedStatement.setString(3, "");
        preparedStatement.setBoolean(4, false);
        preparedStatement.setBoolean(5, false);
        preparedStatement.setBoolean(6, false);
        preparedStatement.setBoolean(7, false);
        preparedStatement.setBoolean(8, false);
        preparedStatement.setBoolean(9, false);
        preparedStatement.setBoolean(10, false);
        preparedStatement.setBoolean(11, false);
        
        preparedStatement.setString(12, "");
        preparedStatement.setString(13, "");
        
        preparedStatement.setFloat(14, 0);
        preparedStatement.setFloat(15, 0);
        
        preparedStatement.setString(16, "");
        preparedStatement.setString(17, "");
        preparedStatement.setString(18, "");
        preparedStatement.setString(19, "");
        

        
        
        preparedStatement .executeUpdate();
        
        dbConnec.disconnect(); 
        
        return stage;
        
    }
    
    public void updateStage(Stage stage)throws SQLException{
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();  
        
        String updateTableSQL = "UPDATE Stage "
                + "SET groupe = ?,"
                + "cahierdescharges = ?, "
                + "fichevisite = ?, "
                + "ficheevalentr = ?, "
                + "sondageweb = ?, "
                + "rapportrendu = ?, "
                + "soutenance = ?, "
                + "visiteplanif = ?, "
                + "visitefaite = ?, "
                + "datedebut = ?, "
                + "datefin = ?, "
                + "notetech = ?, "
                + "notecom = ?, "
                + "maitrestage = ?, "
                + "adresse = ? "
                + "WHERE stageid = ?";  

        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, stage.getGroupe());
        preparedStatement.setBoolean(2, stage.isCdc());
        preparedStatement.setBoolean(3, stage.isFicheVisite());
        preparedStatement.setBoolean(4, stage.isFicheEval());
        preparedStatement.setBoolean(5, stage.isSondageWeb());
        preparedStatement.setBoolean(6, stage.isRapportRendu());
        preparedStatement.setBoolean(7, stage.isSoutenance());
        preparedStatement.setBoolean(8, stage.isVisitePlanif());
        preparedStatement.setBoolean(9, stage.isVisiteFaite());
        
        preparedStatement.setString(10, stage.getDateDebut());
        preparedStatement.setString(11, stage.getDateFin());
        
        preparedStatement.setFloat(12, stage.getNoteTech());
        preparedStatement.setFloat(13, stage.getNoteCom());
        
        preparedStatement.setString(14, stage.getMaitreStage());
        preparedStatement.setString(15, stage.getAdresse());

        preparedStatement.setInt(16, Integer.parseInt(stage.getId()));
        
        preparedStatement.executeUpdate();
        
        dbConnec.disconnect(); 
    }
    
    
    
    public ArrayList<Etudiant> getAllEtudiants() throws SQLException{
        ArrayList<Etudiant> etudiants =  new ArrayList<>();
        
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        
        String query = "SELECT * FROM Etudiant";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        
        
        while (result.next()){
            Etudiant etu = new Etudiant();
            etu.setId(result.getString("etudiantid"));
            etu.setNom(result.getString("nom"));
            etudiants.add(etu);
        }
        
        dbConnec.disconnect(); 
        
        
        return etudiants;
    }
    
    public boolean isApprenti(Etudiant etudiant) throws SQLException{
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        connection.createStatement(
    			       ResultSet.TYPE_FORWARD_ONLY,
    			       ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT * FROM Etudiant WHERE EtudiantId = ? And Statut = 'apprenti'";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(etudiant.getId()));
        ResultSet result = preparedStatement.executeQuery();
        
        boolean value = true;
        
        if (!result.next() ) {
            value = false;
        } 
        
        dbConnec.disconnect(); 
        
        return value;
        
        
    }
    
    public boolean isInStage(Etudiant etudiant) throws SQLException{
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        connection.createStatement(
    			       ResultSet.TYPE_FORWARD_ONLY,
    			       ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT * FROM Stage WHERE EtudiantId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(etudiant.getId()));
        ResultSet result = preparedStatement.executeQuery();
        
        boolean value = true;
        
        if (!result.next() ) {
            value = false;
        } 
        
        dbConnec.disconnect(); 
        
        return value;
        
        
    }
    
    
}