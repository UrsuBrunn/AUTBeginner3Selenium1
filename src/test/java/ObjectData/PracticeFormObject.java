package ObjectData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PracticeFormObject extends CommonObject{

    private String firstName;
    private String lastName;
    private String userEmail;
    private String mobileNumber;
    private String gender;
    private List<String> subjects;


    public PracticeFormObject(HashMap <String, String> testData) {
        populateData(testData);
    }


    public void populateData(HashMap<String, String> testData){
        for(String key : testData.keySet()){
            switch(key){
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "userEmail":
                     setUserEmail(testData.get(key));
                     break;
                case "mobileNumber":
                     setMobileNumber(testData.get(key));
                     break;
                case "gender":
                    setGender(testData.get(key));
                    break;
                case "subjects":
                    setSubjects(getValueList(testData.get(key)));
                    break;
            }
        }
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
