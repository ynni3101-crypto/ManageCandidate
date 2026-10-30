package view;

import java.util.List;
import model.CandidateList;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class ConsoleForm {
    public Candidate createNewCandidate() {
        System.out.println("Create new candidate!");
        System.out.print("Enter candidate ID: ");
        String id = DataInput.inputString();
        System.out.print("Enter first name of candidate: "); 
        String firstName = DataInput.inputString();
        System.out.print("Enter last name of candidate: "); 
        String lastName = DataInput.inputString();
        System.out.print("Enter birth year of candidate: "); 
        int birthCandidate = DataInput.inputBirthYear();
        System.out.print("Enter address of candidate: "); 
        String address = DataInput.inputString();
        System.out.print("Enter phone of candidate: "); 
        String phone = DataInput.getPhone();
        System.out.print("Enter email of candidate: "); 
        String email = DataInput.getEmail();
        return new Candidate(id, firstName, lastName, birthCandidate, address, phone, email, 0);

 
    }

    public Experience inputExperience() {
        Candidate c = createNewCandidate();
        System.out.print("Enter years of experience: ");
        int expInYear = DataInput.getExpYear();
        System.out.print("Enter professional skill: ");
        String proSkill = DataInput.inputString();
        return new Experience(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthYear(),
            c.getAddress(), c.getPhone(), c.getEmail(), 0, expInYear, proSkill);
    }

    public Fresher inputFresher() {
        Candidate c = createNewCandidate();
        System.out.print("Enter Graduation Date: ");
        String graduationDate = DataInput.inputString(); 
        System.out.print("Enter Graduation Rank: ");
        String graduationRank = DataInput.inputString();
        System.out.print("Enter Education: ");
        String education = DataInput.inputString();
        return new Fresher(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthYear(),
            c.getAddress(), c.getPhone(), c.getEmail(), 1, graduationDate, graduationRank, education);
    }

    public Intern inputIntern() {
        Candidate c = createNewCandidate();
        System.out.print("Enter Majors: ");
        String majors = DataInput.inputString(); 
        System.out.print("Enter Semester: ");
        String semester = DataInput.inputString();
        System.out.print("Enter University Name: ");
        String universityName = DataInput.inputString();
        return new Intern(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthYear(),
            c.getAddress(), c.getPhone(), c.getEmail(), 2, majors, semester, universityName);
    }
    
    public void displayAllList(List<Candidate> candidateList) {
        System.out.println("List of candidate:");
        String[] title = {"EXPERIENCE CANDIDATE", "FRESHER CANDIDATE", "INTERN CANDIDATE"};

        for (int type = 0; type < title.length; type++) {
            System.out.println("===========" + title[type] + "============");
            for (Candidate c : candidateList) {
                if (c.getCandidateType() == type)
                    System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }
    }

    public void displaySearchCandidate(List<Candidate> result) {
        if (result.isEmpty()) {
            System.out.println("No candidate found!");
            return;
        }
        System.out.println("The candidates found:");
        for (Candidate c : result) {
            System.out.println(c.getFirstName() + " " + c.getLastName() + " | " + c.getBirthYear() + " | " + c.getAddress() + " | " + c.getPhone() + " | " + c.getEmail() + " | " + c.getCandidateType());
        }
    }

    public void searchCandidates(CandidateList list) {
        displayAllList(list.getAllList());
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = DataInput.inputString();
        System.out.print("Input type of candidate: ");
        int type = DataInput.inputLimit(0, 2);
        displaySearchCandidate(list.search(name,type));
    }

    public boolean YesNo() {
        System.out.print("Do you want to continue (Y/N)? ");
        return DataInput.inputYesNo();
    }
    
}
