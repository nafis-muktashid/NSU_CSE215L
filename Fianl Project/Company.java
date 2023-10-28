public class Company{

    private String industry;
    private int companyIds;
    private String companyNames;
    private String designations;
    private int howManyEmployee;
    private double income;



    //Constructors
    Company(String indName, int companyIds, String companyNames, String designations, int howManyEmployee, double income){
        this.industry = indName;
        this.companyIds = companyIds;
        this.companyNames = companyNames;
        this.designations = designations;
        this.howManyEmployee = howManyEmployee;
        this.income = income;
    }



    //Setter Methods
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public void setCompanyIds(int companyIds) {
        this.companyIds = companyIds;
    }
    public void setCompanyNames(String companyNames) {
        this.companyNames = companyNames;
    }
    public void setDesignations(String designations) {
        this.designations = designations;
    }
    public void setHowManyEmployee(int howManyEmployee) {
        this.howManyEmployee = howManyEmployee;
    }
    public void setIncome(double income) {
        this.income = income;
    }



    //Getter Methods
    public String getIndustry() {
        return industry;
    }
    public int getCompanyIds() {
        return companyIds;
    }
    public String getCompanyNames() {
        return companyNames;
    }
    public String getDesignations() {
        return designations;
    }
    public int getHowManyEmployee() {
        return howManyEmployee;
    }
    public double getIncome() {
        return income;
    }


    @Override
    public String toString() {
            return industry + " " + companyIds + " " + companyNames + " "
                    + designations + " " + howManyEmployee + " " + income + "\n" ;
    }
}
