package app.domain.model;

/**
 *It represents a vaccine.
 */
public class Vaccine {

    private int id;
    private String name;
    private String brand;
    private VaccineType vtype;
    private AdministrationProcess process;

    /**
     * Conrtructor Vaccine
     * @param id
     * @param name
     * @param brand
     * @param type
     */
    public Vaccine(int id, String name, String brand, VaccineType type) throws IllegalArgumentException {
        setId(id);
        setName(name);
        setBrand(brand);
        this.vtype = type;
        process=new AdministrationProcess();
    }

    /**
     * Gets  the administration process of vaccine.
     * @return
     */
    public  AdministrationProcess getAdministrationProcess(){

        return process;
 }

    /**
     * Obtains in text format the information needed of the vaccine.
     * @return
     */
    public String toString(){
        return " id: "+this.id+" Name: "+ this.name+" Brand: "+this.brand+ " "+vtype.toString();

    }

    /**
     * Sets the Id
     * @param id
     * @throws IllegalArgumentException
     */
    public void setId(int id)throws IllegalArgumentException {
        if (id<=0 ) {
            throw new IllegalArgumentException("The lot can't be negative number!");
        }
        this.id = id;
    }

    /**
     * Sets Name
     * @param name
     * @throws IllegalArgumentException
     */
    public void setName(String name) throws  IllegalArgumentException{
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name can't be null or empty!");
        }
        this.name = name;
    }

    /**
     *  Sets vaccineType
     * @param type
     */
    public void setvType(VaccineType type) {
        this.vtype = type;
    }

    /**
     * Sets the  Administration Procees
     * @param process
     */
    public void setProcess(AdministrationProcess process) {
        this.process = process;
    }

    /**
     * Sets the Brand
     * @param brand
     * @throws IllegalArgumentException
     */
    public void setBrand(String brand) throws IllegalArgumentException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("The brand can't be null or empty!");
        }
        this.brand = brand;
    }

    /**
     * Gets the ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Gets Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Brand
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the VaccineType
     * @return
     */
    public VaccineType getvType() {
        return vtype;
    }
}
