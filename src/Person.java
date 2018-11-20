public class Person {

    private String name;
    private int age;
    private String city;
    private String state;
    private int zipCode;
    private String industry = "unknown";
    private boolean searching = false;


    public void setName(String name) {
        if (name.length() == 0 || name == null) {
            this.name = "unknown";
        } else {
            this.name = name;
        }
    }

    public void setAge(String age) {
        if (age.length() == 0 || age == null) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(age);
        }
    }

    public void setCity(String city) {
        if (city.length() == 0 || city == null) {
            this.city = "unknown";
        } else {
            this.city = city;
        }
    }

    public void setState(String state) {
        if (state.length() == 0 || state == null) {
            this.state = "unknown";
        } else {
            this.state = state;
        }
    }

    public void setZipCode(String zipCode) {
        if (zipCode.length() == 0 || zipCode == null) {
            this.zipCode = 0;
        } else {
            this.zipCode = Integer.parseInt(zipCode);
        }
    }

    public void setIndustry(String industry) {
        if (industry.length() == 0 || industry == null) {
            this.industry = "unknown";
        } else {
            this.industry = industry;
        }
    }

    public void setSearching(String searching) {
        if (searching.equalsIgnoreCase("Yes")) {
            this.searching = true;
        }
    }

    //getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getIndustry() {
        return industry;
    }

    public Boolean getSearching() {
        return searching;
    }

    public String toString() {                                           //replaces the hashcode object output with my own. not scalable to new fields
        return "[" + name + "," + age + "," + city + "," + state + "," + zipCode + "," + industry + "," + searching + "]";
    }
}




