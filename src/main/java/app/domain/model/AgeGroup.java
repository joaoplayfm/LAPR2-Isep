package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *It represents an age group that knows one or more doses.
 */
public class AgeGroup {

    private  static final int ZERO_DOSES=0;

    private int ageX;
    private int ageY;

private List<Dose> doses;

    /**
     * Constructor of AgeGroup
     * @param ageX
     * @param ageY
     */
    public AgeGroup(int ageX, int ageY) {
        this.ageX = ageX;
        this.ageY = ageY;
        doses=new ArrayList<Dose>();
    }

    /**
     * Gets age
     * @return
     */
    public int getAgeX() {
        return ageX;
    }

    /**
     * Sets age
     * @param ageX
     */
    public void setAgeX(int ageX) {
        this.ageX = ageX;
    }

    /**
     * Gets Age
     * @return
     */
    public int getAgeY() {
        return ageY;
    }

    /**
     * Sets Age2
     * @param ageY
     */
    public void setAgeY(int ageY) {
        this.ageY = ageY;
    }

    /**
     *Sets a dose in the list.
     * @param doses
     * @return
     */

    public boolean addDoses(Dose doses) {
        return this.doses.add(doses);
    }

    /**
     * Gets the value  of Vaccine dose.
     * @return
     */
    public int getVaccineDose(){

        return doses.size();
    }

    /**
     *Gets of number of Vaccine dose
     * @param index
     * @return
     */

    public Dose getDose(int index) {
        return doses.get(index);
    }



    /**
     *Obtains in text format the information needed.
     * @return
     */
    @Override
    public String toString() {
        String string;

        if(ageY<=0){
                string= "Greater than "+ageX+" years old.\n ";
        }else if (ageX<=0) {
            string= "Minor than "+ageY+" years old.\n ";
        }else{
            string="Age from" + ageX + " to "+ ageY +".\n" ;
        }


        if(doses.size()==ZERO_DOSES){
            return string +"0 doses registered";
        }else{
            for(int i=0;i<doses.size(); i++){
                string+="dose nº"+(i+1)+":"+doses.get(i).toString()+"\n";

            }
            return string;
        }



    }
}
