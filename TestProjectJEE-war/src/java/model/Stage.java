/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hakim
 */
public class Stage {
   
    private String id = "";
    private String groupe = "";
    private boolean cdc = false;
    private boolean ficheVisite = false;
    private boolean ficheEval = false;
    private boolean sondageWeb = false;
    private boolean rapportRendu = false;
    private boolean soutenance = false;
    private boolean visitePlanif = false;
    private boolean visiteFaite = false;
    private String dateDebut = "";
    private String dateFin = "";
    private float noteTech = 0;
    private float noteCom = 0;
    private String maitreStage = "";
    private String adresse = "";
    private int tuteurId;
    private int etudiantId;
    private String descriptionMission = "";
    private String commentaire = "";
    
    private String nomEtudiant = "";

    public void setDescriptionMission(String descriptionMission) {
        this.descriptionMission = descriptionMission;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDescriptionMission() {
        return descriptionMission;
    }

    public String getCommentaire() {
        return commentaire;
    }
    

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }
    
    public Stage(){
        
    }

    public String getId() {
        return id;
    }

    public String getGroupe() {
        return groupe;
    }

    public boolean isCdc() {
        return cdc;
    }

    public boolean isFicheVisite() {
        return ficheVisite;
    }

    public boolean isFicheEval() {
        return ficheEval;
    }

    public boolean isSondageWeb() {
        return sondageWeb;
    }

    public boolean isRapportRendu() {
        return rapportRendu;
    }

    public boolean isSoutenance() {
        return soutenance;
    }

    public boolean isVisitePlanif() {
        return visitePlanif;
    }

    public boolean isVisiteFaite() {
        return visiteFaite;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public float getNoteTech() {
        return noteTech;
    }

    public float getNoteCom() {
        return noteCom;
    }

    public String getMaitreStage() {
        return maitreStage;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTuteurId() {
        return tuteurId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public void setFicheEval(boolean ficheEval) {
        this.ficheEval = ficheEval;
    }

    public void setSondageWeb(boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public void setRapportRendu(boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public void setSoutenance(boolean soutenance) {
        this.soutenance = soutenance;
    }

    public void setVisitePlanif(boolean visitePlanif) {
        this.visitePlanif = visitePlanif;
    }

    public void setVisiteFaite(boolean visiteFaite) {
        this.visiteFaite = visiteFaite;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setNoteTech(float noteTech) {
        this.noteTech = noteTech;
    }

    public void setNoteCom(float noteCom) {
        this.noteCom = noteCom;
    }

    public void setMaitreStage(String maitreStage) {
        this.maitreStage = maitreStage;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTuteurId(int tuteurId) {
        this.tuteurId = tuteurId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }
    
    
    
    
}
